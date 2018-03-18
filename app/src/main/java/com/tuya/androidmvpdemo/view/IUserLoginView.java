package com.tuya.androidmvpdemo.view;

import com.tuya.androidmvpdemo.bean.User;

/**
 * Created by home on 2018/3/18.
 */

public interface IUserLoginView {
    String getUsername();
    String getPassword();
    void clearUserName();
    void clearPassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError();
}
