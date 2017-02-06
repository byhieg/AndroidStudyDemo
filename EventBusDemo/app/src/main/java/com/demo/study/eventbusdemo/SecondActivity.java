package com.demo.study.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.study.eventbusdemo.event.BackGroundEvent;
import com.demo.study.eventbusdemo.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {


    @BindView(R.id.text)
    public EditText textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @OnClick(R.id.send)
    public void send(){
        EventBus.getDefault().post(new MessageEvent(textView.getText().toString()));
        finish();
    }

    @OnClick(R.id.button)
    public void startThirdActivity(){
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onBackGroundEvent(BackGroundEvent backGroundEvent){
        Log.e("backgound",Thread.currentThread().getName());
        Log.e("backgound", backGroundEvent.getMessage());
    }
}
