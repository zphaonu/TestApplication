package com.zphaonu.test1.api;

import com.zphaonu.test1.bean.GankNewsBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GankApi {

    @GET("Android/{count}/{page}")
    Call<GankNewsBean> getNewsData(@Path("count") int count, @Path("page") int page);


}
