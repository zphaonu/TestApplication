package com.zphaonu.zppalyer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zphaonu.zppalyer.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class TwoActivity extends AppCompatActivity {

    private EditText etTwo;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void init() {
        etTwo = findViewById(R.id.et_two);
        btn = findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("etTwo:",etTwo.getText() + "");
                EventBus.getDefault().postSticky(new MessageEvent(etTwo.getText() + ""));
                finish();
            }
        });
    }

//    @Subscribe
//    public void onMessageEvent(MessageEvent event){
//
//    }

}
