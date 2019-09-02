package com.example.equip.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.equip.R;
import com.example.equip.activity.DetailsActivity;
import com.example.equip.adapter.DetailsAdapter;
import com.example.equip.adapter.MListAdapter;
import com.example.equip.base.BaseFragment;
import com.example.equip.view.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/*
 * 横向
 * */
public class LandscapeFragment extends BaseFragment {

    @BindView(R.id.lv_totality)
    ListView lvTotality;
    @BindView(R.id.lv_subsystem)
    ListView lvSubsystem;
    @BindView(R.id.lv_facility)
    ListView lvFacility;
    @BindView(R.id.lv_details)
    ListView lvDetails;


    private List<String> list=new ArrayList<>();
    private MListAdapter mListAdapter;

    @Override
    protected void initEventAndData() {
        for (int i = 0; i < 5; i++) {
            list.add(i+"飞机");
        }
        mListAdapter=new MListAdapter(getActivity(),list);
        lvTotality.setAdapter(mListAdapter);
        lvSubsystem.setAdapter(mListAdapter);
        lvFacility.setAdapter(mListAdapter);

        DetailsAdapter detailsAdapter=new DetailsAdapter(getActivity(),list);
        lvDetails.setAdapter(detailsAdapter);

        lvDetails.setOnItemClickListener((adapterView, view, position, l) -> {
            startActivity(DetailsActivity.openIntent(getActivity()));

        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_landscape;
    }
}
