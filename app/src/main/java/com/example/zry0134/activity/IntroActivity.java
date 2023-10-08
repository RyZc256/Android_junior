package com.example.zry0134.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zry0134.R;
import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(AppIntroFragment.newInstance("西南大门",
                "厦门理工学院的西南大门", R.drawable.p1));
        addSlide(AppIntroFragment.newInstance("三鉴湖",
                "厦门理工学院三鉴湖", R.drawable.p2));
        addSlide(AppIntroFragment.newInstance("综合楼",
                "厦门理工学院新综合楼", R.drawable.p3));
        addSlide(AppIntroFragment.newInstance("学生宿舍",
                "厦门理工学院思明苑学生宿舍", R.drawable.p4));
        addSlide(AppIntroFragment.newInstance("明理教学楼",
                "厦门理工学院明理教学楼创意园", R.drawable.p5));
        addSlide(AppIntroFragment.newInstance("游泳馆",
                "厦门理工学院体育部游泳馆", R.drawable.p6));
        addSlide(AppIntroFragment.newInstance("食堂",
                "厦门理工学院第一食堂", R.drawable.p7));
        setSkipText("跳过");
        setDoneText("完成");
        setImmersiveMode();
    }

    @Override
    protected void onSkipPressed(@Nullable Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void onDonePressed(@Nullable Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
