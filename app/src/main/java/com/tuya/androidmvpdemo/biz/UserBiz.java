package com.tuya.androidmvpdemo.biz;

import com.tuya.androidmvpdemo.bean.User;

/**
 * IUserbiz的实现类
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
       Thread thread=new Thread(new Runnable() {
           @Override
           public void run() {
               try{
                   Thread.sleep(2000);
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
               //模拟登陆成功
               if("aaa".equals(username)&&"123".equals(password)){
                   User user=new User();
                   user.setUsename(username);
                   user.setPassword(password);
                   loginListener.loginsuccess(user);
               }else {
                   loginListener.loginFailed();
               }
           }
       });
       thread.start();
    }
}
