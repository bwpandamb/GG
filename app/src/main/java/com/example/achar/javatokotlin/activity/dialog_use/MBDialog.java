package com.example.achar.javatokotlin.activity.dialog_use;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.example.achar.javatokotlin.R;

/**
 * Created by ext.charles.ma on 17/12/8.
 */


public class MBDialog extends Dialog {

    protected WindowManager.LayoutParams mLayoutParams;

    public MBDialog(@NonNull Context context) {
        super(context);
        initBgView();
    }

    public MBDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initBgView();
    }

    protected MBDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initBgView();
    }

    private void initBgView() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //这一步使这个dialog的背景为透明，这样圆角什么才能生效，还有其他设置不在框内的叉叉什么的也需要这个作为前提
        this.getWindow().setBackgroundDrawableResource(R.mipmap.transparent_bg);
        Window window = this.getWindow();
        mLayoutParams = window.getAttributes();
        mLayoutParams.alpha = 1f; //这里可以控制透明度
//        window.setFlags(0,WindowManager.LayoutParams.FLAG_DIM_BEHIND);  //试了一下这个设置，背景不生效了貌似
        window.setAttributes(mLayoutParams);
        if (mLayoutParams != null) {
            mLayoutParams.height = android.view.ViewGroup.LayoutParams.MATCH_PARENT;
            mLayoutParams.gravity = Gravity.CENTER;
        }

    }


    public void setDialogAnimation(int animResId){
        Window window = getWindow();
        window.setWindowAnimations(animResId);
    }

    /**
     * 设置全屏显示
     */
    public void setFullScreen() {
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.FILL_PARENT;
        lp.height = WindowManager.LayoutParams.FILL_PARENT;
        window.setAttributes(lp);
    }

    /**
     * 设置宽度match_parent
     */
    public void setFullScreenWidth() {
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.FILL_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
    }

    /**
     * 设置高度为match_parent
     */
    public void setFullScreenHeight() {
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.FILL_PARENT;
        window.setAttributes(lp);
    }

    public void setOnWhole() {
        getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
    }


}
