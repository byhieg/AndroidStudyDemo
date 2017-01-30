package com.demo.study.rxdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.normal_rx)
    public void submitNormalActivity(){
        Intent intent = new Intent(this,NormalRxActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.filter_rx)
    public void submitFilterActivity(){
        Intent intent = new Intent(this, FilterActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.map_rx)
    public void submitMapActivity(){
        Intent intent = new Intent(this,MapActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.schulder_rx)
    public void submitSchulderActivity(){
        Intent intent = new Intent(this,SchulderActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.flatMap_rx)
    public void submitFlatMapActivity(){
        Intent intent = new Intent(this, FlatMapActivity.class);
        startActivity(intent);
    }

}
