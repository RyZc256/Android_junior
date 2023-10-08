package com.example.zry0134.base;

import android.content.Context;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.zry0134.activity.MainActivity;

public class BaseFragment2 extends Fragment implements OnFragmentKeyDownListener {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            activity.setOnFragmentKeyDownListener(this);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }
}
