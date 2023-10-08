package com.example.zry0134.ui.me.calendar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.haibin.calendarview.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.zry0134.R;
import com.example.zry0134.base.BaseFragment2;

public class CalendarFragment extends BaseFragment2 {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_calendar, container, false);
        CalendarView calendarView = root.findViewById(R.id.calendarView);
        return root;
    }
}
