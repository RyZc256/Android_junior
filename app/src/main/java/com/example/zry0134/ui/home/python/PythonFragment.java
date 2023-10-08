package com.example.zry0134.ui.home.python;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zry0134.R;
import com.example.zry0134.adapter.PythonAdapter;
import com.example.zry0134.base.BaseFragment2;

public class PythonFragment extends BaseFragment2 {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_python, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(root.getContext(),
                DividerItemDecoration.VERTICAL));
        PythonAdapter pythonAdapter = new PythonAdapter(null);
        recyclerView.setAdapter(pythonAdapter);
        PythonViewModel pythonViewModel = new ViewModelProvider(this).get(PythonViewModel.class);
        pythonViewModel.getPythonList().observe(getViewLifecycleOwner(), pythonAdapter::setList);
        return root;
    }
}
