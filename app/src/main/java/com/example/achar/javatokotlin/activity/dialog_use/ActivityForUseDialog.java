package com.example.achar.javatokotlin.activity.dialog_use;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.achar.javatokotlin.R;
import com.franmontiel.localechanger.LocaleChanger;
import com.franmontiel.localechanger.utils.ActivityRecreationHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityForUseDialog extends AppCompatActivity {

    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.btn_5)
    Button btn5;
    @BindView(R.id.btn_6)
    Button btn6;
    @BindView(R.id.tv_time)
    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_use_dialog);
        ButterKnife.bind(this);


    }

    @Override
    protected void attachBaseContext(Context newBase) {
        newBase = LocaleChanger.configureBaseContext(newBase);
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityRecreationHelper.onResume(this);
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                MBDialog mbDialog = new MBDialog(ActivityForUseDialog.this);
                View vv = LayoutInflater.from(ActivityForUseDialog.this).inflate(R.layout.dialog_blank, null);
                mbDialog.setContentView(vv);
                mbDialog.show();
                break;
            case R.id.btn_2:
                MB_XDialog mb_xDialog = new MB_XDialog(ActivityForUseDialog.this);
//                mb_xDialog.setFullScreen();
//                mb_xDialog.setCanceledOnTouchOutside(true);
                mb_xDialog.show();
                break;
            case R.id.btn_3:
                MB_XDialog mb_xDialog2 = new MB_XDialog(ActivityForUseDialog.this);
                mb_xDialog2.setFullScreen();
//                mb_xDialog.setCanceledOnTouchOutside(true);
                mb_xDialog2.show();

                break;
            case R.id.btn_4:
                MB_Dialog_elm mb_dialog_elm = new MB_Dialog_elm(ActivityForUseDialog.this);
                mb_dialog_elm.setFullScreen();
                mb_dialog_elm.setCanceledOnTouchOutside(false);
                mb_dialog_elm.show();
                break;

            case R.id.btn_5:
                MB_dialog_nhh mb_dialog_nhh = new MB_dialog_nhh(ActivityForUseDialog.this);
                mb_dialog_nhh.setFullScreen();
                mb_dialog_nhh.setMbDialogNhhInterface(new MB_dialog_nhh_Interface.OntvBtnClickInterface() {
                    @Override
                    public void onclick(MB_dialog_nhh dialog) {

                        Toast.makeText(ActivityForUseDialog.this,"点击成功",Toast.LENGTH_SHORT).show();
                    }
                });
                mb_dialog_nhh.setDialogAnimation(R.style.dialogAnimSet);

                mb_dialog_nhh.show();


                break;
            case R.id.btn_6:
//                DateFormat dateFormat = android.text.format.DateFormat.getMediumDateFormat(ActivityForUseDialog.this);
//
//                DateFormat dateFormat2 = android.text.format.DateFormat.getTimeFormat(ActivityForUseDialog.this);
//                tvTime.setText(dateFormat.format(new Date()) + " " + dateFormat2.format(new Date()));
                break;
        }
    }
}
