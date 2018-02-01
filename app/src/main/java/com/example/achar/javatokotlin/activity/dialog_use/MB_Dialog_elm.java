package com.example.achar.javatokotlin.activity.dialog_use;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.achar.javatokotlin.R;

/**
 * Created by ext.charles.ma on 17/12/11.
 */

public class MB_Dialog_elm extends MBDialog implements View.OnClickListener {

    private ConstraintLayout rootView;
    private ImageView ivTtile;
    private ImageView ivClose;
    private TextView tvContent;
    private LinearLayout llRootContent;

    private Boolean mCancelable = true;
    public MB_Dialog_elm(@NonNull Context context) {
        super(context);
        initView();
    }

    public MB_Dialog_elm(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initView();
    }

    protected MB_Dialog_elm(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_x_out_2, null);
        rootView = (ConstraintLayout) view.findViewById(R.id.dialog_root_view);
        ivTtile = (ImageView) view.findViewById(R.id.iv_title);
        ivClose = (ImageView) view.findViewById(R.id.iv_close);
        tvContent = (TextView) view.findViewById(R.id.tv_content);
        llRootContent = (LinearLayout) view.findViewById(R.id.ll_root_content);

        rootView.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        llRootContent.setOnClickListener(this);

        setContentView(view);
    }

    @Override
    public void setCanceledOnTouchOutside(boolean cancel) {

        this.mCancelable = cancel;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_root_view:
                if (mCancelable) {
                    this.dismiss();
                }
                break;

            case R.id.iv_close:
                this.dismiss();
                break;

            case R.id.ll_root_content:
                break;
        }
    }
}
