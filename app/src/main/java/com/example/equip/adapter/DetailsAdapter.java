package com.example.equip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.equip.R;

import java.util.List;

/**
 * @author :created by ${ WYW }
 * 时间：2019/8/27 12
 */
public class DetailsAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public DetailsAdapter(Context context, List<String> list) {
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
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder=null;
        if (view==null){
            view= LayoutInflater.from(context).inflate(R.layout.details_item,viewGroup,false);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }


        return view;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_img;
        private TextView tv_name;
        private TextView tv_number;
        private TextView tv_location;
        private TextView tv_function;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_img=itemView.findViewById(R.id.iv_img);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_number=itemView.findViewById(R.id.tv_number);
            tv_location=itemView.findViewById(R.id.tv_location);
            tv_function=itemView.findViewById(R.id.tv_function);
        }
    }
}
