package com.example.equip.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;

import com.example.equip.R;
import com.example.equip.base.BaseActivity;
import com.example.equip.fragment.LandscapeFragment;
import com.example.equip.fragment.PortraitFragment;
import com.example.equip.view.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_equipment)
    TextView tvEquipment;
    @BindView(R.id.tv_titleName)
    TextView tvTitleName;
    @BindView(R.id.tv_guidance)
    TextView tvGuidance;


    private FragmentTransaction transaction;
    private LandscapeFragment landscapeFragment;
    private PortraitFragment portraitFragment;
    @Override
    protected void initView() {
        ivLeft.setVisibility(View.GONE);
        transaction = getSupportFragmentManager().beginTransaction();
        landscapeFragment=new LandscapeFragment();
        transaction.replace(R.id.fl_home, landscapeFragment);
        transaction.commit();

        tvEquipment.setOnClickListener(this);
        tvGuidance.setOnClickListener(this);
    }

    public  static Intent openIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initDataAndEvent() {

    }


    @Override
    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.tv_equipment:
                if (landscapeFragment == null) {
                    landscapeFragment = new LandscapeFragment();
                }
                transaction.replace(R.id.fl_home, landscapeFragment);
                transaction.commit();
                break;
            case R.id.tv_guidance:
                if (portraitFragment == null) {
                    portraitFragment = new PortraitFragment();
                }
                transaction.replace(R.id.fl_home, portraitFragment);
                transaction.commit();
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        hideInputWhenTouchOtherView(this, ev, null);
        return super.dispatchTouchEvent(ev);
    }


    public boolean isTouchView(View view, MotionEvent event) {
        if (view == null || event == null) {
            return false;
        }
        int[] leftTop = {0, 0};
        view.getLocationInWindow(leftTop);
        int left = leftTop[0];
        int top = leftTop[1];
        int bottom = top + view.getHeight();
        int right = left + view.getWidth();
        if (event.getRawX() > left && event.getRawX() < right
                && event.getRawY() > top && event.getRawY() < bottom) {
            return true;
        }
        return false;
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            return !isTouchView(v, event);
        }
        return false;
    }

    public void hideInputWhenTouchOtherView(Activity activity, MotionEvent ev, List<View> excludeViews) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (excludeViews != null && !excludeViews.isEmpty()) {
                for (int i = 0; i < excludeViews.size(); i++) {
                    if (isTouchView(excludeViews.get(i), ev)) {
                        return;
                    }
                }
            }
            View v = activity.getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager inputMethodManager = (InputMethodManager)
                        activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }

        }
    }
}
