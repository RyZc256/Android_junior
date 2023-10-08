package com.example.zry0134.ui.me;

import static com.example.zry0134.utils.NetUtils.MQTT_URL;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.zry0134.R;
import com.example.zry0134.bean.User;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.bmob.v3.BmobUser;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.internal.http2.Http2Reader;

public class MeFragment extends Fragment {
    private boolean isLogin;
    //访问的地址，这里填写mqtt代理服务器ip
    private String host = MQTT_URL;   //服务器地址
    private String userName = "android-O5MIlBNu";  //账号
    private String passWord = "6AcbqwKrk0X0efna";   //密码
    private int qos = 2;
    private String myTopic = "LED";   //频道名
    private String clientId = "android-O5MIlBNu";   //客户端ID
    private MqttClient client;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_me, container, false);
        CircleImageView circleImageView=root.findViewById(R.id.circleImageView);
        circleImageView.setOnClickListener(this::click);
        TextView textView=root.findViewById(R.id.textView);
        textView.setOnClickListener(this::click);
        if (BmobUser.isLogin()) {
            User user = BmobUser.getCurrentUser(User.class);
            textView.setText(user.getUsername());
            isLogin=true;
        } else {
            textView.setText("点击登录");
            isLogin=false;
        }
        LinearLayout linearLayout_map = root.findViewById(R.id.linearLayout_map);
        linearLayout_map.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_navigation_me_to_mapFragment));

        LinearLayout linearLayout_calender = root.findViewById(R.id.linearLayout_calendar);
        linearLayout_calender.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_navigation_me_to_calendarFragment));

        LinearLayout linearLayout_qrcode = root.findViewById(R.id.linearLayout_qrcode);
        linearLayout_qrcode.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_navigation_me_to_qrcodeFragment));

        LinearLayout linearLayout_light = root.findViewById(R.id.linearLayout_light);
        linearLayout_light.setOnClickListener(this::light);



        return root;
    }

    private void click(View view) {
        if(isLogin){
            Navigation.findNavController(view).navigate(R.id.action_navigation_me_to_infoFragment);
        }else{
            Navigation.findNavController(view).navigate(R.id.action_navigation_me_to_loginFragment);
        }
    }

    public void mqtt_connect(String content) {
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            client = new MqttClient(host, clientId, persistence);

            // MQTT 连接选项
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName(userName);
            connOpts.setPassword(passWord.toCharArray());
            // 保留会话
            connOpts.setCleanSession(true);
            // 建立连接
            System.out.println("Connecting to broker: " + host);
            client.connect(connOpts);
            System.out.println("Connected");
            // 消息发布所需参数
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            client.publish(myTopic, message);
            System.out.println("Message published");

            client.disconnect();
            System.out.println("Disconnected");
            client.close();
            Toast.makeText(getContext(), "指令发送成功", Toast.LENGTH_SHORT).show();
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
            Toast.makeText(getContext(), "指令发送失败", Toast.LENGTH_SHORT).show();
        }
    }

    private void light(View view){
        mqtt_connect("1");
    }

}
