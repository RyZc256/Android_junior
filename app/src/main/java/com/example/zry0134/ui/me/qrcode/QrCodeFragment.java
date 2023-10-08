package com.example.zry0134.ui.me.qrcode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.zry0134.R;
import com.example.zry0134.base.BaseFragment2;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;
import com.yzq.zxinglibrary.encode.CodeCreator;

public class QrCodeFragment extends BaseFragment2 {
    private View root;
    private final int REQUEST_CODE_SCAN = 1111;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.root = inflater.inflate(R.layout.fragment_qrcode, container, false);
        Button createButton = root.findViewById(R.id.button);
        Button scanButton = root.findViewById(R.id.button2);
        createButton.setOnClickListener(this::createQrCode);
        scanButton.setOnClickListener(this::scanQrCode);
        return root;
    }

    public void createQrCode(View view){
        EditText editText = root.findViewById(R.id.editText);
        ImageView imageView = root.findViewById(R.id.imageView);
        String text = editText.getText().toString();
        try{
            Bitmap logo = BitmapFactory.decodeResource(getResources(), R.mipmap.icon);
            Bitmap bitmap = CodeCreator.createQRCode(text, 400, 400, logo);
            imageView.setImageBitmap(bitmap);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void scanQrCode(View view){
        Intent intent = new Intent(getContext(), CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SCAN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);
                Toast.makeText(getContext(), "扫描结果为：" + content, Toast.LENGTH_SHORT).show();
            }
        }
    }


}
