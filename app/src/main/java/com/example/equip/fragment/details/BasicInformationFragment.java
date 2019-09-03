package com.example.equip.fragment.details;

import android.widget.TextView;

import com.example.equip.R;
import com.example.equip.adapter.GridAdapter;
import com.example.equip.base.BaseFragment;
import com.example.equip.view.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 基本信息
 */
public class BasicInformationFragment extends BaseFragment {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.gv_name)
    MyGridView gvName;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.gv_location)
    MyGridView gvLocation;
    @BindView(R.id.tv_function)
    TextView tvFunction;
    @BindView(R.id.gv_function)
    MyGridView gvFunction;
    @BindView(R.id.tv_accountability)
    TextView tvAccountability;
    @BindView(R.id.tv_responsible)
    TextView tvResponsible;
    @BindView(R.id.tv_phone)
    TextView tvPhone;

    private List<String> list = new ArrayList<>();
    private GridAdapter adapter;

    @Override
    protected void initEventAndData() {
        for (int i = 0; i < 5; i++) {
            list.add("");
        }
        adapter = new GridAdapter(list, getActivity());
        gvName.setAdapter(adapter);
        gvLocation.setAdapter(adapter);
        gvFunction.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_basic_information;
    }
}
