package com.example.achar.javatokotlin.activity.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by ext.charles.ma on 17/12/25.
 */

public class NormalAdapter extends PagerAdapter {
    private Context mContext;
    private List<ImageView> mDatas;

    public NormalAdapter(Context mContext, List<ImageView> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size() * 10000;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }


    @Override
    public ImageView instantiateItem(ViewGroup container, int position) {
        ImageView mImageView = mDatas.get(position % mDatas.size());

        container.addView(mImageView);
        return mImageView;

//        container.addView(mDatas.get(position));
//        return mDatas.get(position);
    }

}
