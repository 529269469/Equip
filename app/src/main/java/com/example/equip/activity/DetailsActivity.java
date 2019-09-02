package com.example.equip.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.equip.R;
import com.example.equip.adapter.MListAdapter;
import com.example.equip.adapter.TitleAdapter;
import com.example.equip.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity {


    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.lv_title)
    ListView lvTitle;
    @BindView(R.id.lv_step)
    ListView lvStep;
    @BindView(R.id.lv_details)
    ListView lvDetails;
    private TitleAdapter titleAdapter;
    private List<String> list = new ArrayList<>();

    public static Intent openIntent(Context context) {
        Intent intent = new Intent(context, DetailsActivity.class);

        return intent;
    }

    @Override
    protected void initView() {
        ivLeft.setOnClickListener(view -> finish());

        list.add("基本信息");
        list.add("部件组成");
        list.add("操作使用");
        list.add("安装拆卸");
        list.add("诊断维修");
        list.add("健康处理");

        titleAdapter = new TitleAdapter(this, list);
        lvTitle.setAdapter(titleAdapter);



    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void initDataAndEvent() {

    }


}
