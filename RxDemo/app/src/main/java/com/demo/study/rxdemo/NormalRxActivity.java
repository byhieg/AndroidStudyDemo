package com.demo.study.rxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;

public class NormalRxActivity extends AppCompatActivity {


    @BindString(R.string.content_normal)
    public String content;
    @BindView(R.id.result)
    public TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_rx);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start)
    public void submit(){
        if (!TextUtils.isEmpty(result.getText())){
            result.setText("");
        }
        startRx();
    }

    public void startRx() {
        Log.d("aaa","开始启动");
        result.append("开始执行Rx\n");
//        createObservable().subscribe(createSubscriber());
        startSimpleRx();
    }

    public Observable createObservable(){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("床前明月光");
                subscriber.onNext("疑是地上霜");
                subscriber.onNext("举头望明月");
                subscriber.onNext("低头思故乡");
                subscriber.onCompleted();
            }
        });
    }

    public Subscriber<String> createSubscriber(){
        return new Subscriber<String>() {
            @Override
            public void onCompleted() {
                result.append("执行观察者中的onCompleted()...\n");
                result.append("订阅完毕，结果观察...\n");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                result.append("执行onNext()方法...\n");
                result.append(s + "...\n");
            }
        };
    }

    public void startSimpleRx(){
        Observable.just("床前明月光", "疑是地上霜", "举头望明月", "低头思故乡").
                subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        result.append("执行观察者中的onCompleted()...\n");
                        result.append("订阅完毕，结果观察...\n");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        result.append("执行onNext()方法...\n");
                        result.append(s + "...\n");
                    }
                });
    }

}
