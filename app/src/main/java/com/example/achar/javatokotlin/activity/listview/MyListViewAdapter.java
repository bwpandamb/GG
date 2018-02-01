package com.example.achar.javatokotlin.activity.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.achar.javatokotlin.R;

import java.util.List;

/**
 * Created by ext.charles.ma on 18/1/30.
 */

public class MyListViewAdapter extends BaseAdapter {

    private List<String> list = null;
    private Context context = null;
    private LayoutInflater inflater = null;

    public MyListViewAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_view_item, null);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_list_item);
            convertView.setTag(viewHolder);// 通过setTag将ViewHolder和convertView绑定
        }  else {
            viewHolder = (ViewHolder) convertView.getTag(); // 获取，通过ViewHolder找到相应的控件
        }
        String itemBean = list.get(position);
//        viewHolder.imageView.setImageResource(itemBean.ItemImageResid);
        viewHolder.tvTitle.setText(itemBean);
//        viewHolder.tvContent.setText(itemBean.ItemContent);
        return convertView;
    }

    class ViewHolder {
        TextView tvTitle;
    }
}
