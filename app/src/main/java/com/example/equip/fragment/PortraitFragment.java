package com.example.equip.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import androidx.fragment.app.FragmentTransaction;

import com.example.equip.R;
import com.example.equip.adapter.TitleAdapter;
import com.example.equip.base.BaseFragment;
import com.example.equip.fragment.portrait.DiagnosisOfMaintenanceFragment;
import com.example.equip.fragment.portrait.HealthTreatmentFragment;
import com.example.equip.fragment.portrait.InstallTheDisassemblyFragment;
import com.example.equip.fragment.portrait.OperationAndUseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/*
 * 纵向
 * */
public class PortraitFragment extends BaseFragment {

    @BindView(R.id.fl_portrait)
    FrameLayout flPortrait;
    @BindView(R.id.lv_portrait)
    ListView lvPortrait;

    private TitleAdapter titleAdapter;
    private List<String> list = new ArrayList<>();
    private FragmentTransaction transaction;
    private OperationAndUseFragment operationAndUseFragment;//操作使用
    private InstallTheDisassemblyFragment installTheDisassemblyFragment;//安装拆卸
    private DiagnosisOfMaintenanceFragment diagnosisOfMaintenanceFragment;//诊断维修
    private HealthTreatmentFragment healthTreatmentFragment;//健康处理
    @Override
    protected void initEventAndData() {
        list.add("操作使用");
        list.add("安装拆卸");
        list.add("诊断维修");
        list.add("健康处理");
        titleAdapter = new TitleAdapter(getActivity(), list);
        lvPortrait.setAdapter(titleAdapter);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        operationAndUseFragment=new OperationAndUseFragment();
        transaction.replace(R.id.fl_portrait, operationAndUseFragment);
        transaction.commit();


        lvPortrait.setOnItemClickListener((adapterView, view, i, l) -> {
            transaction = getActivity().getSupportFragmentManager().beginTransaction();
            switch (i){
                case 0:
                    if (operationAndUseFragment == null) {
                        operationAndUseFragment = new OperationAndUseFragment();
                    }
                    transaction.replace(R.id.fl_portrait, operationAndUseFragment);
                    break;
                case 1:
                    if (installTheDisassemblyFragment == null) {
                        installTheDisassemblyFragment = new InstallTheDisassemblyFragment();
                    }
                    transaction.replace(R.id.fl_portrait, installTheDisassemblyFragment);
                    break;
                case 2:
                    if (diagnosisOfMaintenanceFragment == null) {
                        diagnosisOfMaintenanceFragment = new DiagnosisOfMaintenanceFragment();
                    }
                    transaction.replace(R.id.fl_portrait, diagnosisOfMaintenanceFragment);
                    break;
                case 3:
                    if (healthTreatmentFragment == null) {
                        healthTreatmentFragment = new HealthTreatmentFragment();
                    }
                    transaction.replace(R.id.fl_portrait, healthTreatmentFragment);
                    break;
            }
            transaction.commit();
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_portrait;
    }
}
