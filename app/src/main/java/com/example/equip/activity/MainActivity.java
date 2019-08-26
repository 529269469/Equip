package com.example.equip.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.equip.R;
import com.example.equip.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void initView() {

    }

    @Override
    public Intent openIntent(Context context) {
        return new Intent(context,MainActivity.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initDataAndEvent() {

    }
}
