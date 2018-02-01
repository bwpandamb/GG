package com.example.achar.javatokotlin.activity.viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.achar.javatokotlin.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DiffViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.btn_5)
    Button btn5;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_view_pager);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5})
    public void onViewClicked(View view) {
        intent = new Intent(DiffViewPagerActivity.this, SplashActivity.class);
        switch (view.getId()) {
            case R.id.btn_1:
                intent.putExtra("animation", "ZoomPageTransform");
                startActivity(intent);
                break;
            case R.id.btn_2:
                intent.putExtra("animation", "ZoomOutPageTransformer");
                startActivity(intent);
                break;
            case R.id.btn_3:
                intent.putExtra("animation", "DepthPageTransformer");
                startActivity(intent);
                break;
            case R.id.btn_4:
                intent.putExtra("animation", "MbTransformaer");
                startActivity(intent);
                break;
            case R.id.btn_5:

                startActivity(new Intent(DiffViewPagerActivity.this, ViewPagerActivity.class));
                break;
        }
    }
}
