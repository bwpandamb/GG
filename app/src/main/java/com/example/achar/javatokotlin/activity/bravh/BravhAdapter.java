package com.example.achar.javatokotlin.activity.bravh;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.achar.javatokotlin.R;
import com.guanaj.easyswipemenulibrary.EasySwipeMenuLayout;

import java.util.List;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * Created by ext.charles.ma on 18/1/5.
 */

public class BravhAdapter extends BaseQuickAdapter<SampleData, BravhAdapter.TestViewHolder> {

    private Context mContext;
    private List<SampleData> data;

    public BravhAdapter(int layoutResId, @Nullable List<SampleData> data) {
        super(layoutResId, data);
        this.data = data;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    @Override
    protected void convert(final TestViewHolder helper, SampleData item) {
        helper.setText(R.id.item_name, item.getName());
        helper.setText(R.id.item_msg, item.getContent());
        helper.setText(R.id.item_time, item.getAge() + "");
        helper.getView(R.id.right_menu_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(helper.getLayoutPosition());
                Toast.makeText(mContext, "删除", Toast.LENGTH_SHORT).show();
                EasySwipeMenuLayout easySwipeMenuLayout = helper.getView(R.id.es);
                easySwipeMenuLayout.resetStatus();
            }
        });
        helper.getView(R.id.right_menu_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "收藏，现在没有其他实现", Toast.LENGTH_SHORT).show();
                EasySwipeMenuLayout easySwipeMenuLayout = helper.getView(R.id.es);
                easySwipeMenuLayout.resetStatus();
            }
        });


        if (item.isDraged) {
            helper.badge.setBadgeNumber(0);
        }else {
            helper.badge.setBadgeNumber(66);
        }

    }

   class TestViewHolder extends BaseViewHolder {

       private  Badge badge;

       public TestViewHolder(View view) {
           super(view);
           badge = new QBadgeView(mContext).bindTarget(view.findViewById(R.id.imageView));
           badge.setBadgeGravity(Gravity.END | Gravity.TOP);
           badge.setBadgeTextSize(10, true);
           badge.setBadgePadding(6, true);
           badge.setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
               @Override
               public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                   if (dragState == STATE_SUCCEED) {
                       data.get(getAdapterPosition()).isDraged = true;
//                       Toast.makeText(context, String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                   }
               }
           });
       }
   }
}
