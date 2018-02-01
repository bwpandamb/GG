package com.example.achar.javatokotlin.activity.dialog_use;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.achar.javatokotlin.R;

/**
 * Created by ext.charles.ma on 17/12/11.
 */

public class MB_dialog_nhh extends MBDialog implements MB_dialog_nhh_Interface{


    private CardView ll_root_content;
    private TextView tvBtn;
    private ImageView ivClose;

    public MB_dialog_nhh(@NonNull Context context) {
        super(context);
        initView();
    }

    public MB_dialog_nhh(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initView();
    }

    protected MB_dialog_nhh(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView();
    }

    private OntvBtnClickInterface mbDialogNhhInterface;

    public void setMbDialogNhhInterface(OntvBtnClickInterface mbDialogNhhInterface){
        this.mbDialogNhhInterface = mbDialogNhhInterface;
    }

    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_x_out_3, null);

        ll_root_content = (CardView) view.findViewById(R.id.ll_root_content);
        tvBtn = (TextView) view.findViewById(R.id.tv_btn);
        ivClose = (ImageView) view.findViewById(R.id.iv_close);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDismiss();
            }
        });
        tvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mbDialogNhhInterface.onclick(MB_dialog_nhh.this);
            }
        });

        setContentView(view);

    }

    @Override
    public void DialogDismiss() {
        dismiss();
    }
}
