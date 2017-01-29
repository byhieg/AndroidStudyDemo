package com.demo.study.rxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MapActivity extends AppCompatActivity {

    @BindView(R.id.result)
    public TextView result;
    @BindView(R.id.content)
    public TextView content;

    public Integer[] integers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
        integers = new Integer[10];
        Random random = new Random();
        content.append("\n");
        for (int i = 0; i < 10; i++) {
            integers[i] = random.nextInt(10);
            content.append(integers[i].toString() + " ");
        }
    }

    @OnClick(R.id.start)
    public void submit() {
        Observable.from(integers).
                map(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer < 6;
                    }
                }).
                subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        result.append(aBoolean.toString() + " ");
                    }
                });
    }


}
