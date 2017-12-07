package com.example.achar.javatokotlin.activity.appbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.achar.javatokotlin.R;

public class CoordinatorLayoutSelectActivity extends AppCompatActivity {

    private View it_1;
    private View it_2;
    private View it_3;
    private View it_4;
    private CardView cardItem1;
    private CardView cardItem2;
    private CardView cardItem3;
    private CardView cardItem4;

    private TextView jianJie1;
    private TextView jianJie2;
    private TextView jianJie3;
    private TextView jianJie4;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout_select);

        initView();

    }

    private void initView() {
        it_1 = findViewById(R.id.it_1);
        it_2 = findViewById(R.id.it_2);
        it_3 = findViewById(R.id.it_3);
        it_4 = findViewById(R.id.it_4);

        cardItem1 = (CardView) it_1.findViewById(R.id.cardview);
        cardItem2 = (CardView) it_2.findViewById(R.id.cardview);
        cardItem3 = (CardView) it_3.findViewById(R.id.cardview);
        cardItem4 = (CardView) it_4.findViewById(R.id.cardview);

        textView1 = (TextView) it_1.findViewById(R.id.textView);
        textView2 = (TextView) it_2.findViewById(R.id.textView);
        textView3 = (TextView) it_3.findViewById(R.id.textView);
        textView4 = (TextView) it_4.findViewById(R.id.textView);

        jianJie1 = (TextView) it_1.findViewById(R.id.jianjie);
        jianJie2 = (TextView) it_2.findViewById(R.id.jianjie);
        jianJie3 = (TextView) it_3.findViewById(R.id.jianjie);
        jianJie4 = (TextView) it_4.findViewById(R.id.jianjie);


        textView1.setText("比较完整的效果");
        textView2.setText("只有toolbar的推动效果");

        jianJie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("还算比较完整，同时我尝试并发现了可以把toolbar的标题设置在中间的方式\n" +
                        "这样既可以保存动画，还不是很影响其他功能，也许以后用的到\n" +
                        "但是有一些计算上的误差，应该是方法的问题");
            }
        });

        jianJie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("这里面记录了几种toolbar的跟随方式，我保留了最后一种exitUntilCollapsed，其他几种只要相应更改就可以\n" +
                        "scroll:值设为scroll的View会跟随滚动事件一起发生移动。（一定需要设置）\n" +
                        "enterAlways:值设为enterAlways的View,当ScrollView往下滚动时，该View会直接往下滚动。而不用考虑ScrollView是否在滚动\n" +
                        "exitUntilCollapsed：值设为exitUntilCollapsed的View，当这个View要往上逐渐“消逝”时，会一直往上滑动，直到剩下的的高度达到它的最小高度后，再响应ScrollView的内部滑动事件。");
            }
        });

        cardItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoordinatorLayoutSelectActivity.this, AppBarActivity.class));
            }
        });

        cardItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CoordinatorLayoutSelectActivity.this, AppBarActivity2.class));
            }
        });

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
