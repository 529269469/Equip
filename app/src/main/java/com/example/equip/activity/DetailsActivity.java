package com.example.equip.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;

import com.example.equip.R;
import com.example.equip.adapter.TitleAdapter;
import com.example.equip.base.BaseActivity;
import com.example.equip.fragment.LandscapeFragment;
import com.example.equip.fragment.details.BasicInformationFragment;
import com.example.equip.fragment.details.PartsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity {
    public static Intent openIntent(Context context) {
        Intent intent = new Intent(context, DetailsActivity.class);

        return intent;
    }

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
    @BindView(R.id.fl_details)
    FrameLayout flDetails;

    private TitleAdapter titleAdapter;
    private TitleAdapter title2Adapter;
    private List<String> titleList = new ArrayList<>();
    private List<String> stepList = new ArrayList<>();
    private BasicInformationFragment basicInformationFragment;
    private PartsFragment partsFragment;
    private FragmentTransaction transaction;
    private int type=0;

    @Override
    protected void initView() {
        ivLeft.setOnClickListener(view -> finish());

        titleList.add("基本信息");
        titleList.add("部件组成");
        titleList.add("操作使用");
        titleList.add("安装拆卸");
        titleList.add("诊断维修");
        titleList.add("健康处理");

        titleAdapter = new TitleAdapter(this, titleList);
        lvTitle.setAdapter(titleAdapter);

        title2Adapter= new TitleAdapter(this, stepList);
        lvStep.setAdapter(title2Adapter);
        lvTitle.setOnItemClickListener((adapterView, view, position, l) -> {
            transaction = getSupportFragmentManager().beginTransaction();
            switch (position) {
                case 0:
                    type=0;
                    stepList.clear();
                    title2Adapter.notifyDataSetChanged();
                    if (basicInformationFragment == null) {
                        basicInformationFragment = new BasicInformationFragment();
                    }
                    transaction.replace(R.id.fl_details, basicInformationFragment);
                    transaction.commit();
                    break;
                case 1:
                    type=1;
                    stepList.clear();
                    for (int i = 0; i < 5; i++) {
                        stepList.add("部件"+i);
                    }
                    title2Adapter.notifyDataSetChanged();
                    break;
                case 2:
                    type=2;
                    stepList.clear();
                    for (int i = 0; i < 5; i++) {
                        stepList.add("使用"+i);
                    }
                    title2Adapter.notifyDataSetChanged();
                    break;
                case 3:
                    type=3;
                    stepList.clear();
                    for (int i = 0; i < 5; i++) {
                        stepList.add("安装"+i);
                    }
                    title2Adapter.notifyDataSetChanged();
                    break;
                case 4:
                    type=4;
                    stepList.clear();
                    for (int i = 0; i < 5; i++) {
                        stepList.add("维修"+i);
                    }
                    title2Adapter.notifyDataSetChanged();
                    break;
                case 5:
                    type=5;
                    stepList.clear();
                    for (int i = 0; i < 5; i++) {
                        stepList.add("健康"+i);
                    }
                    title2Adapter.notifyDataSetChanged();
                    break;
            }
        });

        lvStep.setOnItemClickListener((adapterView, view, i, l) -> {
            transaction = getSupportFragmentManager().beginTransaction();
            switch (type){
                case 0:

                    break;
                case 1:
                    if (partsFragment == null) {
                        partsFragment=new PartsFragment();
                    }
                    transaction.replace(R.id.fl_details, partsFragment);
                    transaction.commit();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
            }
        });

        transaction = getSupportFragmentManager().beginTransaction();
        basicInformationFragment = new BasicInformationFragment();
        transaction.replace(R.id.fl_details, basicInformationFragment);
        transaction.commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void initDataAndEvent() {

    }


}
