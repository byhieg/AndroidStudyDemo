package com.demo.study.rxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class TimerActivity extends AppCompatActivity {

    @BindView(R.id.result)
    public TextView result;


    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.start)
    public void start(){
        subscription = Observable.interval(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers
                .mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        result.setText(aLong + "");

                    }
                });
    }

    @OnClick(R.id.cancel)
    public void cancel(){
        subscription.unsubscribe();
    }
}
