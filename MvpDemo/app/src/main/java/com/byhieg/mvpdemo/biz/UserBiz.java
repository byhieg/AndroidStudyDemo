package com.byhieg.mvpdemo.biz;

import com.byhieg.mvpdemo.bean.User;

/**
 * Created by shiqifeng on 2017/2/13.
 * Mail:byhieg@gmail.com
 */

public class UserBiz implements IUserBiz{
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000 * 2);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if ("byhieg".equals(username) && "123".equals(password)){
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                }else{
                    loginListener.loginFailed();
                }
            }
        }).start();
    }
}
