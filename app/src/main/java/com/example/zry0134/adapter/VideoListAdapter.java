package com.example.zry0134.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.zry0134.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class VideoListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public VideoListAdapter(@Nullable List<String> data) {
        super(R.layout.item_video_list, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, String name) {
        baseViewHolder.setText(R.id.textView,name);
    }
}