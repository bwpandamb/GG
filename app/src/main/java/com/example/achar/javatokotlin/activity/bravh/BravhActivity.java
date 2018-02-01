package com.example.achar.javatokotlin.activity.bravh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.achar.javatokotlin.R;
import com.example.achar.javatokotlin.activity.bravh.net.Api;
import com.example.achar.javatokotlin.activity.bravh.net.IMGroupResp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BravhActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private List<SampleData> mList;
    private Object netData;
    private BravhAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bravh);

        initData();
        initView();

        getNetData();
    }

    private void initData() {
//        mList = new ArrayList();
//        for (int i = 0; i < 10; i++) {
//            SampleData data = new SampleData("hongyang" + i, i, "这个就是内容啦",false);
//            mList.add(data);
//        }
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager layout = new LinearLayoutManager(BravhActivity.this);
        adapter = new BravhAdapter(R.layout.sample_item, mList);
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        adapter.setContext(this);
        adapter.isFirstOnly(true);
//        Adapter adapter1 = new Adapter(this, mList);


        mRv.setLayoutManager(layout);
        mRv.setAdapter(adapter);



    }

    public void getNetData() {


        Retrofit.Builder retrofit = new Retrofit.Builder();
        Retrofit ret =  retrofit.addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://cne1qassefpv2-w-alb-1472553753.cn-north-1.elb.amazonaws.com.cn/api/")
                .build();
        ret.create(Api.class).getIMGroup("100000001")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<IMGroupResp>() {
            @Override
            public void onCompleted() {
                Log.e("MMMMMMML", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("MMMMMMML", "Throwable");
            }

            @Override
            public void onNext(IMGroupResp imGroupResp) {
                Log.e("MMMMMMML", imGroupResp.getImUserId()+"");
                mList = new ArrayList();
                for (int i = 0; i < 10; i++) {
                    SampleData data = new SampleData("hongyang" + i, i, "这个就是内容啦",false);
                    mList.add(data);
                }
                mList.add(new SampleData("qeqwe", Integer.parseInt(imGroupResp.getGroupIds().get(0)), imGroupResp.getImUserId(), false));
                adapter.setNewData(mList);
            }
        });
    }
}
