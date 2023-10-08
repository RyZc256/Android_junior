package com.example.zry0134.ui.home.web;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;


import androidx.appcompat.app.ActionBar;

import com.example.zry0134.R;
import com.example.zry0134.activity.MainActivity;
import com.example.zry0134.base.BaseFragment2;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebChromeClient;

public class WebFragment extends BaseFragment2 {
    private AgentWeb mAgentWeb;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_web, container, false);
        mAgentWeb = AgentWeb.with(this).setAgentWebParent((LinearLayout) root,
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT))
                .useDefaultIndicator()
                .setWebChromeClient(new WebChromeClient() {
                    @Override
                    public void onReceivedTitle(WebView view, String title) {
                        super.onReceivedTitle(view, title);
                        MainActivity activity = (MainActivity) getActivity();
                        if (activity != null) {
                            ActionBar supportActionBar = activity.getSupportActionBar();
                            if (supportActionBar != null) {
                                supportActionBar.setTitle(title);
                            }
                        }
                    }}).createAgentWeb()
                .ready()
                .go(getArguments() != null ? getArguments().getString("url") :
                        "https://www.jd.com");
        return root;
    }

    @Override
    public void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    public void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return mAgentWeb.handleKeyEvent(keyCode, event);
    }
}
