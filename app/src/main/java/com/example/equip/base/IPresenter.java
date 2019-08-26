package com.example.equip.base;


/**
 * Created by pantianxiong on 2018/4/23.
 * 描述：
 */

public interface IPresenter<V extends IView> {
    void detachView();
}
