package com.example.achar.javatokotlin.activity.dialog_use;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.achar.javatokotlin.R;

/**
 * Created by ext.charles.ma on 17/12/11.
 */

public class MB_XDialog extends MBDialog implements View.OnClickListener {

    private ConstraintLayout rootView;
    private LinearLayout rootView2;


    public MB_XDialog(@NonNull Context context) {
        super(context);
        initView();
    }

    public MB_XDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initView();
    }

    protected MB_XDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView();
    }


    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_x_out, null);

        rootView = (ConstraintLayout) inflate.findViewById(R.id.rootView);
        rootView2 = (LinearLayout) inflate.findViewById(R.id.aaa);



        rootView2.setOnClickListener(this);
        rootView.setOnClickListener(this);
        setContentView(inflate);

    }

    @Override
    public void onClick(View v) {

    }

}
