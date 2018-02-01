package com.example.achar.javatokotlin.activity.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.achar.javatokotlin.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView mLv;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initData();

        mLv = (ListView) findViewById(R.id.lv);
        View headView = getLayoutInflater().inflate(R.layout.list_headview_item, null);
        MyListViewAdapter myListViewAdapter = new MyListViewAdapter(mData, this);
        mLv.setAdapter(myListViewAdapter);
        mLv.addHeaderView(headView);
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mData.add("哈哈哈哈   " + i);
        }
    }
}
