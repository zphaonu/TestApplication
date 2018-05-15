package com.zphaonu.test1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zphaonu.test1.R;

import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {
    private int layoutId;
    private List<T> data;
    private Context mContext;

    public BaseAdapter(int layoutId, List<T> data, Context mContext) {
        this.layoutId = layoutId;
        this.data = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
        BaseViewHolder holder = new BaseViewHolder(view, mContext);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        setBindData(holder, data.get(position));
    }

    public abstract <T> void setBindData(BaseViewHolder holder, T bean);


    @Override
    public int getItemCount() {
        return data.size() != 0 ? data.size() : 0;
    }


    public static class BaseViewHolder extends RecyclerView.ViewHolder {

        private View conventView;
        private Context context;

        public BaseViewHolder(View itemView, Context context) {
            super(itemView);
            this.conventView = itemView;
            this.context = context;
        }

        public void setText(int id, String text) {
            TextView tv = conventView.findViewById(id);
            tv.setText(text);
        }

        /**
         * 设置网络图片
         *
         * @param id
         * @param url
         */
        public void setImage(int id, String url) {
            ImageView iv = conventView.findViewById(id);
            Glide.with(context)
                    .setDefaultRequestOptions(new RequestOptions().placeholder(R.mipmap.ic_launcher_round))
                    .load(url)
                    .into(iv);
        }

        public void setImageNull(int id) {
            ImageView imageView = conventView.findViewById(id);
            imageView.setVisibility(View.GONE);
        }

        /**
         * 设置本地图片
         *
         * @param id
         * @param resouceId
         */
        public void setImageSouce(int id, int resouceId) {
            ImageView iv = conventView.findViewById(id);
            iv.setImageResource(resouceId);
        }
    }
}
