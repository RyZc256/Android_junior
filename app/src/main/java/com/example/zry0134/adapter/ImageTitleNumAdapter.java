package com.example.zry0134.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zry0134.R;
import com.example.zry0134.bean.NewsBean;
import com.example.zry0134.utils.NetUtils;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class ImageTitleNumAdapter extends BannerAdapter<NewsBean,
        ImageTitleNumAdapter.BannerViewHolder> {

    public ImageTitleNumAdapter(List<NewsBean> mDatas){
        super(mDatas);
    }

    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_image_title_num,
                parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindView(BannerViewHolder holder, NewsBean data, int position, int size) {
        Glide.with(holder.imageView).load(NetUtils.BASE_URL + data.getImg1())
                .into(holder.imageView);
        holder.title.setText(data.getNewsName());
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView numIndicator;

        BannerViewHolder(@NonNull View view){
            super(view);
            imageView = view.findViewById(R.id.image);
            title = view.findViewById(R.id.bannerTitle);
            numIndicator = view.findViewById(R.id.numIndicator);
        }
    }
}
