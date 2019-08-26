package com.example.equip.net;


public interface MyCallBack<T> {
    void onSuccess(T t);
    void onFaile(String msg);
}
