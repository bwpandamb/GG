package com.example.achar.javatokotlin.activity.viewpager.animation;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by ext.charles.ma on 17/12/26.
 */

public class MbTransformaer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        int width = page.getWidth();
        //我们给不同状态的页面设置不同的效果
        //通过position的值来分辨页面所处于的状态
        if (position < -1) {//滑出的页面
            page.setScrollX((int) (width * 0.75 * -1));
        } else if (position <= 1) {//[-1,1]
            if (position < 0) {//[-1,0]
                page.setScrollX((int) (width * 0.75 * position));
            } else {//[0,1]
                page.setScrollX((int) (width * 0.75 * position));
            }
        } else {//即将滑入的页面
            page.setScrollX((int) (width * 0.75));
        }

    }
}
