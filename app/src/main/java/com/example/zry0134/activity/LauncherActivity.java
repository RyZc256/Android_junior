package com.example.zry0134.activity;

import static com.example.zry0134.utils.NetUtils.FILE_URL;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class LauncherActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(() -> {
            SharedPreferences sharedPreferences = getSharedPreferences("setting",
                    MODE_PRIVATE);
            boolean isFirst = sharedPreferences.getBoolean("isFirst", true);
            if (isFirst) {
                startActivity(new Intent(LauncherActivity.this,
                        IntroActivity.class));
                sharedPreferences.edit().putBoolean("isFirst", false).apply();
            } else {
                startActivity(new Intent(LauncherActivity.this,
                        SplashActivity.class));
            }
            finish();
        }, 1000);
        Glide.with(this).load(FILE_URL + "/static/dancing-mascot-android.gif").preload();
    }
}
