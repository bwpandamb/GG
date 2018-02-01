package com.example.achar.javatokotlin.activity.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.activity.viewpager.animation.DepthPageTransformer;
import com.example.achar.javatokotlin.activity.viewpager.animation.MbTransformaer;
import com.example.achar.javatokotlin.activity.viewpager.animation.ZoomOutPageTransformer;
import com.example.achar.javatokotlin.activity.viewpager.animation.ZoomPageTransform;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private ViewPager vp;
    private List<ImageView> mDatas;
    private NormalAdapter adapter;
    private String animation;

    //    private NormalPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_normal);
        animation = getIntent().getStringExtra("animation");

        vp = (ViewPager) findViewById(R.id.vp);
        initData();
        initAdapter();
    }

    private void initData() {
        ImageView imageView_1 = new ImageView(this, null);
        imageView_1.setBackgroundResource(R.mipmap.hpw1);
        ImageView imageView_2 = new ImageView(this);
        imageView_2.setBackgroundResource(R.mipmap.hpw2);
        ImageView imageView_3 = new ImageView(this);
        imageView_3.setBackgroundResource(R.mipmap.hpw3);
        ImageView imageView_4 = new ImageView(this);
        imageView_4.setBackgroundResource(R.mipmap.hpw4);
        ImageView imageView_5 = new ImageView(this);
        imageView_5.setBackgroundResource(R.mipmap.hpw5);
        mDatas = new ArrayList<>();
        mDatas.add(imageView_1);
        mDatas.add(imageView_2);
        mDatas.add(imageView_3);
        mDatas.add(imageView_4);
        mDatas.add(imageView_5);
    }

    private void initAdapter() {
        adapter = new NormalAdapter(this, mDatas);

        switch (animation) {
            case "ZoomPageTransform":
                vp.setPageTransformer(true, new ZoomPageTransform());
                break;
            case "ZoomOutPageTransformer":
                vp.setPageTransformer(true, new ZoomOutPageTransformer());
                break;
            case "DepthPageTransformer":
                vp.setPageTransformer(true, new DepthPageTransformer());
                break;
            case "MbTransformaer":
                vp.setPageTransformer(true, new MbTransformaer());
                break;
        }
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("tag", "this is offset--->" + positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
