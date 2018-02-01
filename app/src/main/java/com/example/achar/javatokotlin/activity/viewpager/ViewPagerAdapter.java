package com.example.achar.javatokotlin.activity.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    
    private Context mContext;
    private int[] mImages; // 图片资源ID数组
    private List<ImageView> mImageViews; // ImageView集合

    public ViewPagerAdapter(Context context, int[] images){
        mContext = context;
        mImages = images;
        mImageViews = new ArrayList<>();
        initImageViews(mImages);
    }

    /**
     * 初始化ImageViews集合
     * @param imageIds
     */
    private void initImageViews(int[] imageIds) {

        // 根据图片资源数组填充ImageViews集合
        for(int i = 0 ; i < imageIds.length ; i++){
            ImageView mImageView = new ImageView(mContext);
            mImageView.setBackgroundResource(imageIds[i]);
//            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageViews.add(mImageView);
        }

        // ImageViews集合中的图片个数在[2,3]时会存在问题，递归再次填充一遍
        if(mImageViews.size() > 1 && mImageViews.size() < 4){
            initImageViews(imageIds);
        }
    }

    @Override
    public int getCount() {
        return mImageViews.size() <=1 ? mImageViews.size() : Short.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView mImageView = mImageViews.get(position % mImageViews.size());
        container.addView(mImageView);
        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
