package com.example.achar.javatokotlin.activity.diff_recycle_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.achar.javatokotlin.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiffRecycleViewActivity extends AppCompatActivity {

    @BindView(R.id.diff_rv_list)
    RecyclerView diffRvList;

    List<String> mDataList;
    List<BaseBean> mDataList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_recycle_view);
        ButterKnife.bind(this);


        initData();


        diffRvList.setLayoutManager(new GridLayoutManager(this, 2));
        diffRvList.addItemDecoration(new GridSpacingItemDecoration(2, 20, true));
        diffRvList.setHasFixedSize(true);
        diffRvList.setAdapter(new DifRecycleViewAdapter(this, mDataList2));
    }

    private void initData() {
        mDataList = new ArrayList<>();
        mDataList2 = new ArrayList<>();

        OneBean oneBean1 = new OneBean(0 , "我是名字");
        OneBean oneBean2 = new OneBean(2, "我是名字");
        OneBean oneBean3 = new OneBean(4, "我是名字");
        OneBean oneBean4 = new OneBean(5, "我是名字");
        OneBean oneBean5 = new OneBean(8, "我是名字");
        OneBean oneBean6 = new OneBean(10, "我是名字");

        TwoBean twoBean1 = new TwoBean(1, "我是内容");
        TwoBean twoBean2 = new TwoBean(3, "我是内容");
        TwoBean twoBean3 = new TwoBean(6, "我是内容");
        TwoBean twoBean4 = new TwoBean(7, "我是内容");
        TwoBean twoBean6 = new TwoBean(9, "我是内容");
        mDataList2.add(oneBean1);
        mDataList2.add(oneBean2);
        mDataList2.add(oneBean3);
        mDataList2.add(oneBean4);
        mDataList2.add(twoBean1);
        mDataList2.add(twoBean2);
        mDataList2.add(twoBean3);
        mDataList2.add(twoBean4);
        mDataList2.add(oneBean5);
        mDataList2.add(twoBean6);
        mDataList2.add(oneBean6);
//        mDataList2.sort();
//        Collections.sort(mDataList2);

        Collections.sort(mDataList2, new Comparator<BaseBean>() {
            @Override
            public int compare(BaseBean o1, BaseBean o2) {

                return o1.getOrder() - o2.getOrder();
            }
        });

        for (int i = 0; i < 20; i++) {
            mDataList.add("aaaaa" + i);
        }

    }
}
