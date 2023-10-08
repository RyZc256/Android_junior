package com.example.zry0134.ui.home.python;


import com.example.zry0134.bean.PythonBean;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.zry0134.utils.NetUtils;
import com.github.leonardoxh.livedatacalladapter.Resource;

import java.util.List;

public class PythonViewModel extends ViewModel {
    public LiveData<List<PythonBean>> getPythonList(){
        return Transformations.map(NetUtils.get().getPythonList(), Resource::getResource);
    }

}
