package com.zphaonu.zppalyer;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.zphaonu.zppalyer.Fragment.BaseFragment;
import com.zphaonu.zppalyer.Fragment.OneFragment;
import com.zphaonu.zppalyer.Fragment.ThreeFragment;
import com.zphaonu.zppalyer.Fragment.TwoFragment;
import com.zphaonu.zppalyer.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BaseFragment.OnFragmentInteractionListener {

    private FrameLayout fl;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private OneFragment one;
    private TwoFragment two;
    private ThreeFragment three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    private void init() {
        fl = findViewById(R.id.fl);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        one = new OneFragment();
        two = new TwoFragment();
        three = new ThreeFragment();
        transaction.add(R.id.fl, one);
        transaction.commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackFragment() {

    }

    @Override
    public void onStartNextFragment(int i) {

    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onMessage(MessageEvent event) {
        String message = event.getMessage();
        Log.e("++++++++++++", message);
        Toast.makeText(getApplicationContext(), "收到", Toast.LENGTH_SHORT).show();
        switch (message) {
            case "1":
                showFragmnet(one);
                break;
            case "2":
                showFragmnet(two);
                break;
            case "3":
                showFragmnet(three);
                break;
            default:
                showFragmnet(one);
                break;
        }

    }


    private void showFragmnet(Fragment fragment) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl, fragment);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }

}
