package com.tuya.androidmvpdemo.biz;

/**
 * Created by home on 2018/3/18.
 */

public interface IUserBiz {
    public void login(String username,String password,OnLoginListener loginListener);
}
