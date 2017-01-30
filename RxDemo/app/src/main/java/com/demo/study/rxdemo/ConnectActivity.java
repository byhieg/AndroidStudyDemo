package com.demo.study.rxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;

public class ConnectActivity extends AppCompatActivity {

    @BindView(R.id.result)
    public TextView result;


    private Integer []integers = {1,2,3,4,5,6,7,8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start_normal)
    public void startNormal(){
        result.setText("");
        Observable observable = Observable.from(integers);
        observable.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer o) {
                result.append("观察者A  收到:  "+o+"\n");
            }
        });

        observable.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer o) {
                result.append("观察者B  收到:  "+o+"\n");

            }
        });
    }


    @OnClick(R.id.start_connect)
    public void startConnect(){
        result.setText("");
        ConnectableObservable observable = Observable.from(integers).publish();

        observable.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer o) {
                result.append("观察者A  收到:  "+o+"\n");
            }
        });

        observable.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer o) {
                result.append("观察者B  收到:  "+o+"\n");

            }
        });

        observable.connect();
    }


}
