package com.example.achar.javatokotlin.activity.diff_recycle_view;

import android.support.annotation.NonNull;

/**
 * Created by ext.charles.ma on 18/2/8.
 */

public class BaseBeanImp implements BaseBean,Comparable<BaseBeanImp> {

    public int order;

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;

    }

    @Override
    public int compareTo(@NonNull BaseBeanImp o) {
        return this.order - o.order;
    }
}
