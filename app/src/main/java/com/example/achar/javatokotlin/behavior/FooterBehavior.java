package com.example.achar.javatokotlin.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

public class FooterBehavior extends CoordinatorLayout.Behavior<View> {
  
    private static final String TAG = "lzy";  
  
  
    public FooterBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);  
    }  
  
    @Override  
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }  
  
    @Override  
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {  
        float translationY = Math.abs(dependency.getTop());//获取更随布局的顶部位置  
        child.setTranslationY(translationY);  
        return true;  
    }  
}  
