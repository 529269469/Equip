package com.example.equip.fragment.details;

import android.widget.TextView;

import com.example.equip.R;
import com.example.equip.adapter.GridAdapter;
import com.example.equip.base.BaseFragment;
import com.example.equip.view.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class PartsFragment extends BaseFragment {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.gv_name)
    MyGridView gvName;
    @BindView(R.id.tv_property)
    TextView tvProperty;
    @BindView(R.id.tv_function)
    TextView tvFunction;
    @BindView(R.id.gv_function)
    MyGridView gvFunction;
    @BindView(R.id.tv_remark)
    TextView tvRemark;
    @BindView(R.id.gv_remark)
    MyGridView gvRemark;

    private List<String> list = new ArrayList<>();
    private GridAdapter adapter;
    @Override
    protected void initEventAndData() {

        for (int i = 0; i < 5; i++) {
            list.add("");
        }
        adapter = new GridAdapter(list, getActivity());
        gvName.setAdapter(adapter);
        gvFunction.setAdapter(adapter);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_parts;
    }
}
