package com.zphaonu.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zphaonu.test1.adapter.GankRecycleAdapter;
import com.zphaonu.test1.api.GankApi;
import com.zphaonu.test1.bean.GankNewsBean;
import com.zphaonu.test1.contant.Gank;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btn;
    private GankRecycleAdapter adapter;
    private List<GankNewsBean.ResultsBean> data;
    private int count = 10;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.rcl_news);
        btn = findViewById(R.id.btn_load);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
        data = new ArrayList<>();
        adapter = new GankRecycleAdapter(R.layout.recycle_item_gank, data, this);
       LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,manager.getOrientation()));
        recyclerView.setAdapter(adapter);
    }



    private void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Gank.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GankApi gankApi = retrofit.create(GankApi.class);
        Call<GankNewsBean> call = gankApi.getNewsData(count, page);
        call.enqueue(new Callback<GankNewsBean>() {
            @Override
            public void onResponse(Call<GankNewsBean> call, Response<GankNewsBean> response) {
                Log.e("response:",""+response.body());
                GankNewsBean gankNewsBean = response.body();
                if(data.size()!=0){
                    data.clear();
                }
                data.addAll(gankNewsBean.getResults());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GankNewsBean> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "网络异常", Toast.LENGTH_SHORT);
            }
        });

    }
}
