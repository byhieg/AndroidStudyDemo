package com.byhieg.mvpdemo.biz;

import com.byhieg.mvpdemo.bean.User;

/**
 * Created by shiqifeng on 2017/2/13.
 * Mail:byhieg@gmail.com
 */

public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();
}
