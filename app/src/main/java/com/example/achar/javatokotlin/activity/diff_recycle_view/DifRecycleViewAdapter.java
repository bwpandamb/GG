package com.example.achar.javatokotlin.activity.diff_recycle_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.achar.javatokotlin.R;

import java.util.List;

/**
 * Created by ext.charles.ma on 18/2/1.
 */

public class DifRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int FIRST_TYPE = 0;
    private static final int SECOND_TYPE = 1;


    private Context mContext;
    private LayoutInflater inflater;
    private List<BaseBean> mList;

    private DifRecycleViewAdapter.OnItemClickListener onItemClickListener;

    public DifRecycleViewAdapter(Context mContext, List<BaseBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = LayoutInflater.from(mContext);
    }

    public void setOnItemClickListener(DifRecycleViewAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder = null;
        View inflate = null;
        switch (viewType) {
            case FIRST_TYPE:
                inflate = inflater.inflate(R.layout.list_item_temple_one, parent, false);
                holder = new ViewHolderOne(inflate);
                break;
            case SECOND_TYPE:
                inflate = inflater.inflate(R.layout.list_item_temple_two, parent, false);
                holder = new ViewHolderTwo(inflate);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (mList.get(position) instanceof OneBean) {
            Log.e("MBMB", mList.get(position).getOrder() + "");
        }

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position) instanceof OneBean) {
            return FIRST_TYPE;
        } else {
            return SECOND_TYPE;
        }

    }

    private class ViewHolderOne extends RecyclerView.ViewHolder {

        public ViewHolderOne(View itemView) {
            super(itemView);
        }

    }

    private class ViewHolderTwo extends RecyclerView.ViewHolder {

        public ViewHolderTwo(View itemView) {
            super(itemView);
        }

    }


}
