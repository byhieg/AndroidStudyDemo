package com.demo.study.eventbusdemo;

import android.content.Intent;
import android.support.v4.app.INotificationSideChannel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.study.eventbusdemo.event.MessageEvent;
import com.demo.study.eventbusdemo.event.ObjectEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.text)
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @OnClick(R.id.button)
    public void startSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button1)
    public void startThirdActivity(){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button2)
    public void startOtherService(){
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent){
        textView.setText(messageEvent.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onObjectEvent(ObjectEvent objectEvent){
        textView.setText(objectEvent.getMessage());
        Toast.makeText(this,objectEvent.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onServiceEvent(ObjectEvent objectEvent){
        textView.setText(objectEvent.getMessage());
        Toast.makeText(this,objectEvent.getExampleJavaBean().getName() + " " + objectEvent
                .getExampleJavaBean().getName() + " ",Toast.LENGTH_SHORT).show();
    }



}
