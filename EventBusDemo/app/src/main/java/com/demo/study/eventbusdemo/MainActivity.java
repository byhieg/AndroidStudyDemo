package com.demo.study.eventbusdemo;

import android.content.Intent;
import android.support.v4.app.INotificationSideChannel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.demo.study.eventbusdemo.event.MessageEvent;

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

        textView.setText("MainActivity");
    }

    @OnClick(R.id.button)
    public void startSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        EventBus.getDefault().register(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent messageEvent){
        textView.setText(messageEvent.getMessage());
    }
}
