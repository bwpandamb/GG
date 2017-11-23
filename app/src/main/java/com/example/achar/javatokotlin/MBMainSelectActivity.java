package com.example.achar.javatokotlin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.achar.javatokotlin.activity.ActivityGetSampFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MBMainSelectActivity extends AppCompatActivity {


    @BindView(R.id.cardview_tablayout)
    CardView cardviewTablayout;
    @BindView(R.id.cardview_fg)
    CardView cardviewFragment;
    @BindView(R.id.jianjie_1)
    TextView jianjie1;
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbselect);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.cardview_tablayout, R.id.cardview_fg, R.id.jianjie_1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cardview_tablayout:
                startActivity(new Intent(MBMainSelectActivity.this, MainActivity.class));
                break;
            case R.id.jianjie_1:
                showDialog("简单的使用了tablayout，配合了ViewPager + " +
                        "Fragment的显示方式\n可以拓展的地方在于tablayout的一些属性还有tablayout放在的位置，" +
                        "我认为还是可以放在下面的");
                break;


            case R.id.cardview_fg:
                startActivity(new Intent(MBMainSelectActivity.this, ActivityGetSampFragment.class));
                break;


        }
    }

    private void showDialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Material Design Dialog");
        builder.setMessage(msg);
//        builder.setNegativeButton("取消", null);
//        builder.setPositiveButton("确定", null);
        builder.show();
    }

}
