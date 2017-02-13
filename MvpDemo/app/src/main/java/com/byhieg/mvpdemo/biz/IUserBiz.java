package com.byhieg.mvpdemo.biz;

/**
 * Created by shiqifeng on 2017/2/13.
 * Mail:byhieg@gmail.com
 */

public interface IUserBiz {

    public void login(String username,String password,OnLoginListener loginListener);
}
