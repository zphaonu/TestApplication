package com.zphaonu.test1.adapter;


import android.content.Context;

import com.zphaonu.test1.R;
import com.zphaonu.test1.bean.GankNewsBean;

import java.util.List;

public class GankRecycleAdapter extends BaseAdapter {

    private GankNewsBean.ResultsBean resultsBean;

    public GankRecycleAdapter(int layoutId, List data, Context mContext) {
        super(layoutId, data, mContext);
    }

    @Override
    public void setBindData(BaseViewHolder holder, Object bean) {
        resultsBean = (GankNewsBean.ResultsBean) bean;
        if(resultsBean==null){
            return;
        }
        holder.setText(R.id.tv_desc,resultsBean.getDesc());
        holder.setText(R.id.tv_who,resultsBean.getWho());
        if(resultsBean.getImages()==null){
            holder.setImageNull(R.id.iv);
        }else{
            holder.setImage(R.id.iv,resultsBean.getImages().get(0));
        }

    }

}
