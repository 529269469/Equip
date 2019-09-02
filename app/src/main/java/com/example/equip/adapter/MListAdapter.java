package com.example.equip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.equip.R;

import java.util.List;

/**
 * @author :created by ${ WYW }
 * 时间：2019/8/29 13
 */
public class MListAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public MListAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view==null){
            viewHolder=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.m_list,viewGroup,false);
            viewHolder.tv_m_list=view.findViewById(R.id.tv_m_list);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }

        viewHolder.tv_m_list.setText(list.get(position));

        return view;
    }

    static class ViewHolder{
        private TextView tv_m_list;
    }
}
