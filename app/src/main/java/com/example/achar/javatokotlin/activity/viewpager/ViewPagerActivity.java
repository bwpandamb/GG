package com.example.achar.javatokotlin.activity.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.activity.viewpager.animation.AlphaPageTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerActivity extends AppCompatActivity {
    private List<ImageView> mDatas;

    @BindView(R.id.vp)
    ViewPager vp;
    private NormalAdapter adapter;

    int[] data = {R.mipmap.hpw1, R.mipmap.hpw2, R.mipmap.hpw3, R.mipmap.hpw4, R.mipmap.hpw5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);


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

        vp.setAdapter(adapter);
        vp.setCurrentItem(50);
        vp.setPageMargin(50);
//        vp.setOffscreenPageLimit(2);
        vp.setPageTransformer(true, new AlphaPageTransformer());
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
