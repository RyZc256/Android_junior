package com.example.zry0134.activity;

import static com.example.zry0134.utils.NetUtils.FILE_URL;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.zry0134.R;

public class SplashActivity  extends AppCompatActivity {
    private boolean isClick;
    private boolean isBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this).load(FILE_URL + "/static/dancing-mascot-android.gif")
                .into(imageView);

        new Handler().postDelayed(() -> {
            if (!isClick && !isBack){
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 5000);
    }

    public void skip(View view){
        isClick = true;
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isBack = true;
    }
}
