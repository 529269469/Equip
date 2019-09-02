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
 * 时间：2019/8/30 15
 */
public class OperationAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public OperationAdapter(Context context, List<String> list) {
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
            view= LayoutInflater.from(context).inflate(R.layout.operation_item,viewGroup,false);
            viewHolder.tv_num=view.findViewById(R.id.tv_num);
            viewHolder.tv_name=view.findViewById(R.id.tv_name);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }




        return view;
    }


    static class ViewHolder{
        private TextView tv_num;
        private TextView tv_name;
    }
}
