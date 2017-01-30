package com.demo.study.rxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

public class SortActivity extends AppCompatActivity {

    @BindView(R.id.result)
    public TextView result;

    private Integer[] integers = {1, 3, 5, 2, 24, 7, 5, 86, 23, 43};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start)
    public void start() {
        Observable.from(integers).
                toSortedList().
                flatMap(new Func1<List<Integer>, Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call(List<Integer> integers) {
                        return Observable.from(integers);
                    }
                }).subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                    result.append(integer + "\n");
                    }
        });

    }
}
