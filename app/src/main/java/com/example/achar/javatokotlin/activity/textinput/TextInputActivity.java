package com.example.achar.javatokotlin.activity.textinput;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.view.MBtestView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TextInputActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.mbview)
    MBtestView mbview;
    @BindView(R.id.btn2)
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btn.performClick();
            }
        }, 500);
    }

    private float data_1 = 0.8f;
    float[] datalist = new float[]{1f, 1f, 1f, 1f, 0.9f, 0.5f};
    float[] datalist2 = new float[6];
    String[] dataNamelist = new String[]{"听力","阅读","写作","单词","作文","翻译"};

    @OnClick({R.id.btn, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                for (int i = 0; i < datalist2.length; i++) {
                    datalist2[i] = (float) Math.random();
                }
                mbview.setDataList(datalist2);
                mbview.setDataNameList(dataNamelist);
                mbview.animateY(300);


                break;
            case R.id.btn2:
                data_1 = data_1 + 0.1f;
                mbview.setData_1(data_1);

                break;
        }
    }


}
