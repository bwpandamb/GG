package com.example.achar.javatokotlin.activity.fragmnet_train;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
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

public class FragmentAddShowHideActivity extends AppCompatActivity {


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
        setContentView(R.layout.activity_add_show_hide_fragment);
        ButterKnife.bind(this);

        initStartFragment();

    }

    private void initStartFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (sampleFragment1 == null) {
            sampleFragment1 = new SampleFragment1();
            transaction.add(R.id.content, sampleFragment1);

            hideAllFragment(transaction);
            transaction.show(sampleFragment1);
            transaction.commit();
        } else {
            hideAllFragment(transaction);
            transaction.show(sampleFragment1);
            transaction.commit();
        }
    }

    private void initStartFragment2() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (sampleFragment2 == null) {
            sampleFragment2 = new SampleFragment2();
            transaction.add(R.id.content, sampleFragment2);
            hideAllFragment(transaction);
            transaction.show(sampleFragment2);
            transaction.commit();
        } else {
            hideAllFragment(transaction);
            transaction.show(sampleFragment2);
            transaction.commit();
        }
    }

    private void initStartFragment3() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (sampleFragment3 == null) {
            sampleFragment3 = new SampleFragment3();
            transaction.add(R.id.content, sampleFragment3);
            hideAllFragment(transaction);
            transaction.show(sampleFragment3);
            transaction.commit();
        } else {
            hideAllFragment(transaction);
            transaction.show(sampleFragment3);
            transaction.commit();
        }
    }

    private void hideAllFragment(FragmentTransaction transaction) {

        if (sampleFragment1 != null) {
            transaction.hide(sampleFragment1);
        }

        if (sampleFragment2 != null) {
            transaction.hide(sampleFragment2);
        }

        if (sampleFragment3 != null) {
            transaction.hide(sampleFragment3);
        }
    }

    @OnClick({R.id.tv_tab_1, R.id.tv_tab_2, R.id.tv_tab_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_tab_1:
                initStartFragment();
                break;
            case R.id.tv_tab_2:
                initStartFragment2();
                break;
            case R.id.tv_tab_3:
                initStartFragment3();
                break;
        }
    }
}
