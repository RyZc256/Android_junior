package com.example.zry0134.ui.video.detail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zry0134.R;
import com.example.zry0134.adapter.VideoListAdapter;

import java.util.Arrays;
import java.util.List;

public class VideoListFragment extends Fragment {

    private final VideoDetailFragment videoDetailFragment;
    private List<String> subNameList;
    private List<String> subVideoList;
//    private String url0="https://zsb.xmut.edu.cn/__local/2/AE/1D/EBE7F20862DB01E30531A5F2AC1_7C45D05A_5EF3DBE.mp4?e=.mp4";
//    private String url1="http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";

    public VideoListFragment(String[] subNameList, String[] subVideoList, VideoDetailFragment videoDetailFragment) {
        this.subNameList = Arrays.asList(subNameList);
        this.subVideoList = Arrays.asList(subVideoList);
        this.videoDetailFragment = videoDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_video_list,container,false);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        VideoListAdapter videoListAdapter=new VideoListAdapter(subNameList);
        recyclerView.setAdapter(videoListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(root.getContext(),
                DividerItemDecoration.VERTICAL));
        videoListAdapter.setOnItemClickListener((adapter, view, position) -> {
            videoDetailFragment.playNewUrl(subVideoList.get(position));
        });
        return root;
    }
}

