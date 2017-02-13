package com.byhieg.mvpdemo.view;

import com.byhieg.mvpdemo.bean.User;

/**
 * Created by shiqifeng on 2017/2/13.
 * Mail:byhieg@gmail.com
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
