package com.example.achar.javatokotlin.activity.fragmnet_train;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.activity.fragmnet_train.fragment.SampleFragment1;
import com.example.achar.javatokotlin.activity.fragmnet_train.fragment.SampleFragment2;
import com.example.achar.javatokotlin.activity.fragmnet_train.fragment.SampleFragment3;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FramgentReplaceActivity extends AppCompatActivity {

    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.tv_tab_1)
    TextView tvTab1;
    @BindView(R.id.tv_tab_2)
    TextView tvTab2;
    @BindView(R.id.tv_tab_3)
    TextView tvTab3;
    private SampleFragment1 sampleFragment1;
    private SampleFragment2 sampleFragment2;
    private SampleFragment3 sampleFragment3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace_framgent);
        ButterKnife.bind(this);

        initStartFragment();


    }

    private void initStartFragment() {
        if (sampleFragment1 == null) {
            sampleFragment1 = new SampleFragment1();

        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, sampleFragment1)
                .commit();

    }

    @OnClick({R.id.tv_tab_1, R.id.tv_tab_2, R.id.tv_tab_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_tab_1:
                if (sampleFragment1 == null) {
                    sampleFragment1 = new SampleFragment1();

                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, sampleFragment1)
                        .commit();

                break;
            case R.id.tv_tab_2:
                if (sampleFragment2 == null) {
                    sampleFragment2 = new SampleFragment2();

                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, sampleFragment2)
                        .commit();

                break;
            case R.id.tv_tab_3:

                if (sampleFragment3 == null) {
                    sampleFragment3 = new SampleFragment3();

                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, sampleFragment3)
                        .commit();
                break;
        }
    }
}
