package com.tuya.androidmvpdemo.biz;

import com.tuya.androidmvpdemo.bean.User;

/**
 * Created by home on 2018/3/18.
 */

public interface OnLoginListener {
    public void loginsuccess(User user);
    public void loginFailed();
}
