package com.tuya.androidmvpdemo.Presenter;

import android.os.Handler;

import com.tuya.androidmvpdemo.bean.User;
import com.tuya.androidmvpdemo.biz.IUserBiz;
import com.tuya.androidmvpdemo.biz.OnLoginListener;
import com.tuya.androidmvpdemo.biz.UserBiz;
import com.tuya.androidmvpdemo.view.IUserLoginView;


import java.util.logging.LogRecord;

/**
 * Created by home on 2018/3/18.
 * 数据和view层交互的桥梁
 */

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler =new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView){
        this.userLoginView=userLoginView;
        this.userBiz=new UserBiz();
    }
    public void login(){
        userLoginView.showLoading();
        //实现接口
        userBiz.login(userLoginView.getUsername(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginsuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                   userLoginView.toMainActivity(user);
                   userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    userLoginView.showFailedError();
                    userLoginView.hideLoading();
                }
            });
            }
        });
    }
    public void clear(){
        //具体清除操作
    }
}
