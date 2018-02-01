package com.example.achar.javatokotlin.activity.bravh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.achar.javatokotlin.R;

import java.util.List;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * Created by ext.charles.ma on 18/1/5.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private Context context;
    private List<SampleData> mList;
    private LayoutInflater layoutInflater;

    public Adapter(Context context, List<SampleData> mList) {
        this.context = context;
        this.mList = mList;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = layoutInflater.inflate(R.layout.sample_item, parent, false);

        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (mList.get(position).isDraged) {
            holder.badge.setBadgeNumber(0);
        }else {
            holder.badge.setBadgeNumber(mList.get(position).getAge());
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_avator;
        private TextView tv_name;
        private TextView tv_context;
        Badge badge;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_avator = (ImageView) itemView.findViewById(R.id.imageView);
            tv_name = (TextView) itemView.findViewById(R.id.item_name);
            tv_context = (TextView) itemView.findViewById(R.id.item_msg);

            badge = new QBadgeView(context).bindTarget(iv_avator);
            badge.setBadgeGravity(Gravity.END | Gravity.TOP);
            badge.setBadgeTextSize(10, true);
            badge.setBadgePadding(6, true);
            badge.setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                @Override
                public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                    if (dragState == STATE_SUCCEED) {
                        mList.get(getAdapterPosition()).isDraged = true;
                        Toast.makeText(context, String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
