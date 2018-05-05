package com.zphaonu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnAdd, btnJian, btnCheng, btnChu, btnPrecent, btnDeng, btnAC, btnDel, btnPoint;
    private EditText etInput;
    private String inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBtn();
    }

    private void initBtn() {
        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btnAdd = findViewById(R.id.btn_add);
        btnJian = findViewById(R.id.btn_minus);
        btnCheng = findViewById(R.id.btn_chengyi);
        btnChu = findViewById(R.id.btn_chuyi);
        btnPrecent = findViewById(R.id.btn_percent);
        btnDeng = findViewById(R.id.btn_equal);
        btnAC = findViewById(R.id.btn_AC);
        btnDel = findViewById(R.id.btn_DEL);
        btnPoint = findViewById(R.id.btn_point);
        etInput = findViewById(R.id.et_input);
        etInput.setText("0");
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn_0:
                setEtText("0");
                break;
            case R.id.btn_1:
                setEtText("1");
                break;
            case R.id.btn_2:
                setEtText("2");
                break;
            case R.id.btn_3:
                setEtText("3");
                break;
            case R.id.btn_4:
                setEtText("4");
                break;
            case R.id.btn_5:
                setEtText("5");
                break;
            case R.id.btn_6:
                setEtText("6");
                break;
            case R.id.btn_7:
                setEtText("7");
                break;
            case R.id.btn_8:
                setEtText("8");
                break;
            case R.id.btn_9:
                setEtText("9");
                break;
            case R.id.btn_AC://清空全部
                etInput.setText("0");
                break;
            case R.id.btn_DEL:
                setEtText("Del");
                break;

        }
    }

    private void setEtText(String str) {
        inputText = etInput.getText().toString();
        StringBuilder sb = new StringBuilder();
        sb = sb.append(inputText);
        if (inputText.equals("0")) {
            etInput.setText(str);
        } else {
            if (str.equals("Del")) {

            }
            sb.append(str);
            etInput.setText(sb);

        }

    }
}
