package com.example.equip.fragment.portrait;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.equip.R;
import com.example.equip.activity.DetailsActivity;
import com.example.equip.adapter.OperationAdapter;
import com.example.equip.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 操作使用
 */
public class OperationAndUseFragment extends BaseFragment {

    @BindView(R.id.tv_totality)
    TextView tvTotality;
    @BindView(R.id.tv_subsystem)
    TextView tvSubsystem;
    @BindView(R.id.tv_facility)
    TextView tvFacility;
    @BindView(R.id.et_keyword)
    EditText etKeyword;
    @BindView(R.id.lv_fragment_operation_and_use)
    ListView lvFragmentOperationAndUse;

    private OperationAdapter adapter;
    private List<String> list=new ArrayList<>();

    @Override
    protected void initEventAndData() {
        for (int i = 0; i < 10; i++) {
            list.add("");
        }
        adapter=new OperationAdapter(getActivity(),list);
        lvFragmentOperationAndUse.setAdapter(adapter);

        lvFragmentOperationAndUse.setOnItemClickListener((adapterView, view, i, l) ->
                startActivity(DetailsActivity.openIntent(getActivity()))
        );

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_operation_and_use;
    }
}
