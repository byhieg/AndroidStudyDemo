package com.byhieg.mvpdemo.presenter;

import android.os.Handler;

import com.byhieg.mvpdemo.bean.User;
import com.byhieg.mvpdemo.biz.IUserBiz;
import com.byhieg.mvpdemo.biz.OnLoginListener;
import com.byhieg.mvpdemo.biz.UserBiz;
import com.byhieg.mvpdemo.view.IUserLoginView;

/**
 * Created by byhieg on 17/2/13.
 * Contact with byhieg@gmail.com
 */

public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login(){
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
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
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
