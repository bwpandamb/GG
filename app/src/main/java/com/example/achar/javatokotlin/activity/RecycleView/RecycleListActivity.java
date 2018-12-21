package com.example.achar.javatokotlin.activity.RecycleView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.achar.javatokotlin.MainActivity;
import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.activity.appbar.CoordinatorLayoutSelectActivity;
import com.example.achar.javatokotlin.activity.bravh.BravhActivity;
import com.example.achar.javatokotlin.activity.change_language_in_app.ChangeLanguageActivity;
import com.example.achar.javatokotlin.activity.dialog_use.ActivityForUseDialog;
import com.example.achar.javatokotlin.activity.diff_recycle_view.DiffRecycleViewActivity;
import com.example.achar.javatokotlin.activity.fast_spalsh_loading.WelcomeActivity;
import com.example.achar.javatokotlin.activity.fragmnet_train.FragmentTrainActivity;
import com.example.achar.javatokotlin.activity.listview.ListViewActivity;
import com.example.achar.javatokotlin.activity.progress_line.ProgressLineActivity;
import com.example.achar.javatokotlin.activity.rili.RiLiActivity;
import com.example.achar.javatokotlin.activity.some_bottom_bar.BottomNavigationBarActivity;
import com.example.achar.javatokotlin.activity.tablayout.TabLayoutDoubleActivity;
import com.example.achar.javatokotlin.activity.textinput.TextInputActivity;
import com.example.achar.javatokotlin.activity.viewpager.DiffViewPagerActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleListActivity extends AppCompatActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    List<ItemContextBean> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_list);
        ButterKnife.bind(this);

        initData();


        RecycleViewAdapter adapter = new RecycleViewAdapter(this, mDataList);

        rvList.setLayoutManager(new GridLayoutManager(this, 2));
        rvList.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (view.getId()) {
                    case R.id.text_context:
                        if (mDataList.get(position).getActivity() != null) {
                            Intent intent = new Intent(RecycleListActivity.this, mDataList.get(position).getActivity());
                            startActivity(intent);
                        } else {
                            showDialog("这个还没写啊，什么时候动一下手啊？！");
                        }
                        break;

                    case R.id.text_introduction:
                        showDialog(mDataList.get(position).getIntroduction());
                        break;
                }

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    private void initData() {
        mDataList = new ArrayList<ItemContextBean>();

        mDataList.add(new ItemContextBean("Tab标签的使用",
                getResources().getString(R.string.jj_fragment_attach_activity), MainActivity.class));
        mDataList.add(new ItemContextBean("单纯的写一个fragment依附于activity",
                "没有简介", FragmentTrainActivity.class));
        mDataList.add(new ItemContextBean("tablayout + viewPager 嵌套",
                getResources().getString(R.string.jj_tablelayout_fragment), TabLayoutDoubleActivity.class));
        mDataList.add(new ItemContextBean("BottomNavigationBar的使用",
                "没有简介", BottomNavigationBarActivity.class));
        mDataList.add(new ItemContextBean("AppBar的使用",
                "没有简介", CoordinatorLayoutSelectActivity.class));
        mDataList.add(new ItemContextBean("TextInputLayout的使用",
                "没有简介", TextInputActivity.class));
        mDataList.add(new ItemContextBean("dialog的各种开发",
                "没有简介", ActivityForUseDialog.class));
        mDataList.add(new ItemContextBean("修改语言",
                "没有简介", ChangeLanguageActivity.class));
        mDataList.add(new ItemContextBean("日历",
                "没有简介", RiLiActivity.class));
        mDataList.add(new ItemContextBean("ViewPager制作splash界面",
                "没有简介", DiffViewPagerActivity.class));
        mDataList.add(new ItemContextBean("软键盘和按键跟随",
                "没有简介", null));
        mDataList.add(new ItemContextBean("仿饿了么数量控件",
                "没有简介", BravhActivity.class));
        mDataList.add(new ItemContextBean("listview使用",
                "没有简介", ListViewActivity.class));
        mDataList.add(new ItemContextBean("应用打开时没有白黑屏闪，直接就是spalsh",
                getString(R.string.fast_splash), WelcomeActivity.class));
        mDataList.add(new ItemContextBean("我看看表格recycle设置不同类型",
                "没有简介", DiffRecycleViewActivity.class));
        mDataList.add(new ItemContextBean("进度条",
                "没有简介", ProgressLineActivity.class));

    }

    private void showDialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg);
        builder.show();
    }
}
