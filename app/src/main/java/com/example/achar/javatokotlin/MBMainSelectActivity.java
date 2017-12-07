package com.example.achar.javatokotlin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.achar.javatokotlin.activity.appbar.CoordinatorLayoutSelectActivity;
import com.example.achar.javatokotlin.activity.fragmnet_train.FragmentTrainActivity;
import com.example.achar.javatokotlin.activity.some_bottom_bar.BottomNavigationBarActivity;
import com.example.achar.javatokotlin.activity.tablayout.TabLayoutDoubleActivity;
import com.example.achar.javatokotlin.activity.textinput.TextInputActivity;

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
    @BindView(R.id.jianjie_2)
    TextView jianjie2;
    @BindView(R.id.textView_tablayout_2)
    TextView textViewTablayout2;
    @BindView(R.id.cardview_tablayout_2)
    CardView cardviewTablayout2;
    @BindView(R.id.jianjie_3)
    TextView jianjie3;
    @BindView(R.id.textView_buju)
    TextView textViewBuju;
    @BindView(R.id.cardview_buju)
    CardView cardviewBuju;
    @BindView(R.id.jianjie_4)
    TextView jianjie4;
    @BindView(R.id.textView_appbar)
    TextView textViewAppbar;
    @BindView(R.id.cardview_appbar)
    CardView cardviewAppbar;
    @BindView(R.id.jianjie_5)
    TextView jianjie5;
    @BindView(R.id.textView_textinput)
    TextView textViewTextinput;
    @BindView(R.id.cardview_textinput)
    CardView cardviewTextinput;
    @BindView(R.id.jianjie_6)
    TextView jianjie6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbselect);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.cardview_textinput,R.id.cardview_appbar, R.id.jianjie_5, R.id.cardview_buju, R.id.jianjie_4, R.id.cardview_tablayout, R.id
            .cardview_fg, R.id.jianjie_1, R.id
            .jianjie_3, R.id.cardview_tablayout_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cardview_appbar:
                startActivity(new Intent(MBMainSelectActivity.this, CoordinatorLayoutSelectActivity.class));
                break;
            case R.id.cardview_textinput:
                startActivity(new Intent(MBMainSelectActivity.this, TextInputActivity.class));
                break;
            case R.id.jianjie_5:
                break;

            case R.id.cardview_tablayout:
                startActivity(new Intent(MBMainSelectActivity.this, MainActivity.class));
                break;
            case R.id.jianjie_1:
                showDialog("简单的使用了tablayout，配合了ViewPager + " +
                        "Fragment的显示方式\n可以拓展的地方在于tablayout的一些属性还有tablayout放在的位置，" +
                        "我认为还是可以放在下面的");
                break;

            case R.id.cardview_fg:
                startActivity(new Intent(MBMainSelectActivity.this, FragmentTrainActivity.class));
                break;

            case R.id.cardview_tablayout_2:
                startActivity(new Intent(MBMainSelectActivity.this, TabLayoutDoubleActivity.class));
                break;

            case R.id.jianjie_3:
                showDialog("我想要使用activity+tablayout+viewpager作为第一层实现，下面的几个TAB切换fragment \n" +
                        "然后内部再使用tablayout+viewpager来嵌套使用，来实现上面TAB的切换 \n" +
                        "然后通过禁止第一个viewpager（activity）中的滑动来解决冲突，同时实现我想要的上下tab都有的效果 \n" +
                        "然而这个貌似有一些BUG，当两个页面都是tablayout+viewpager时，会出现fragment内容丢失，看起来渲染失败了，而且滑动很卡 \n" +
                        "如果只有一个页面是tablayout+viewpager，那就还好，我没发现问题");
                break;

            case R.id.cardview_buju:
                startActivity(new Intent(MBMainSelectActivity.this, BottomNavigationBarActivity.class));
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
