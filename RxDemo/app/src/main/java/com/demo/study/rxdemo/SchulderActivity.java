package com.demo.study.rxdemo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class SchulderActivity extends AppCompatActivity {

    @BindView(R.id.result)
    public TextView result;

    @BindView(R.id.LinearLayout)
    public LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_schulder);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start)
    public void submit() {
        final StringBuffer sb = new StringBuffer();
        Observable.
                create(new Observable.OnSubscribe<Drawable>() {
                    @Override
                    public void call(Subscriber<? super Drawable> subscriber) {
                        sb.append(" Observable.create(): 线程: " + Thread.currentThread().getName() + "\n");
                        Drawable drawable = getDrawable(R.mipmap.ic_launcher);
                        subscriber.onNext(drawable);
                        subscriber.onCompleted();
                    }
                }).subscribeOn(Schedulers.io()).
                observeOn(Schedulers.newThread()).
                map(new Func1<Drawable, ImageView>() {
                    @Override
                    public ImageView call(Drawable drawable) {
                        sb.append("map():  drawable -->imageview 的线程: " + Thread.currentThread().getName() + "\n");
                        ImageView iv = new ImageView(SchulderActivity.this);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams
                                .WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                        iv.setLayoutParams(params);
                        iv.setImageDrawable(drawable);
                        return iv;
                    }
                }).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Action1<ImageView>() {
                    @Override
                    public void call(ImageView imageView) {
                        sb.append("call(): 线程: " + Thread.currentThread().getName() + "\n");
                        result.append(sb);
                        linearLayout.addView(imageView);
                    }
                });

    }
}
