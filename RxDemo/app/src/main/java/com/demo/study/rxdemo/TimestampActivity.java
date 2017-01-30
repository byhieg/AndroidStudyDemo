package com.demo.study.rxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.schedulers.Timestamped;

public class TimestampActivity extends AppCompatActivity {


    @BindView(R.id.result)
    public TextView result;

    private Integer[] integers = {1, 3, 5, 2, 24, 7, 5, 86, 23, 43};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timestamp);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start)
    public void start(){
        Observable.from(integers).
                timestamp(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Action1<Timestamped<Integer>>() {
                    @Override
                    public void call(Timestamped<Integer> integerTimestamped) {
                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
                        result.append("value: "+integerTimestamped.getValue()+"       time:   ");
                        result.append(sdf.format(new Date(integerTimestamped.getTimestampMillis()))
                                +"\n");
                    }
                });
    }
}
