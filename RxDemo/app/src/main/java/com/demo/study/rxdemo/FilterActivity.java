package com.demo.study.rxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class FilterActivity extends AppCompatActivity {

    @BindView(R.id.result)
    public TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.start)
    public void submit() {
        Integer[] integers = new Integer[100];
        for (int i = 0; i < 100; i++) {
            integers[i] = i;
        }
        Observable.from(integers).
                filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer % 3 == 0;
                    }
                }).
                subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        result.append(integer.toString() + " ");
                    }
                });
    }


}
