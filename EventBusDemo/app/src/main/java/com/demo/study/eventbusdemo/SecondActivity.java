package com.demo.study.eventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.study.eventbusdemo.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;

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
    }

    @OnClick(R.id.send)
    public void send(){
        EventBus.getDefault().post(new MessageEvent(textView.getText().toString()));
        finish();
    }

}
