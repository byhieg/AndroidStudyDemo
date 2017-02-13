package com.byhieg.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class UserLoginActivity extends AppCompatActivity {

    private EditText mEtUsername,mEtPassword;
    private Button mBtnLogin,mBtnClear;
    private ProgressBar mPbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        initViews();
    }

    private void initViews() {
        mEtUsername = (EditText)findViewById(R.id.)
    }
}
