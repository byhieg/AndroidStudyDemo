package com.demo.study.rxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MergeActivity extends AppCompatActivity {

    @BindView(R.id.result)
    public TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start)
    public void start() {
        if (result.getText().toString().length() > 0) {
            result.setText("");
        }

        Observable ob1 = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    Thread.sleep(100 * 5);
                    subscriber.onNext("aaaaaa");
                    subscriber.onCompleted();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).subscribeOn(Schedulers.newThread());

        Observable ob2 = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    Thread.sleep(100 * 10);
                    subscriber.onNext("bbbbb");
                    subscriber.onCompleted();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).subscribeOn(Schedulers.newThread());


        Observable.merge(ob1,ob2).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Subscriber<String>() {
                    StringBuffer sb = new StringBuffer();
                    @Override
                    public void onCompleted() {
                        result.append("两个任务都处理完毕\n");
                        result.append("更新数据：" + sb + "\n");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String o) {
                        sb.append(o + ",");
                        result.append("得到一个数据" + sb + "\n");
                    }
                });
    }
}
