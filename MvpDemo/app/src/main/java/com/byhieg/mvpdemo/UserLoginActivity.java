package com.byhieg.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.byhieg.mvpdemo.bean.User;
import com.byhieg.mvpdemo.presenter.UserLoginPresenter;
import com.byhieg.mvpdemo.view.IUserLoginView;

public class UserLoginActivity extends AppCompatActivity  implements IUserLoginView{

    private EditText mEtUsername,mEtPassword;
    private Button mBtnLogin,mBtnClear;
    private ProgressBar mPbLoading;


    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        initViews();
    }

    private void initViews() {
        mEtUsername = (EditText) findViewById(R.id.user);
        mEtPassword = (EditText) findViewById(R.id.password);

        mBtnLogin = (Button) findViewById(R.id.login);
        mBtnClear = (Button) findViewById(R.id.clear);

        mPbLoading = (ProgressBar) findViewById(R.id.progressbar);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });

    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
