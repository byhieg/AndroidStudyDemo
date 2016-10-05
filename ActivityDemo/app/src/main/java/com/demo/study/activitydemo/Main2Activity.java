package com.demo.study.activitydemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Log.e("Main2", "onCreate执行了");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("Main2", "onRestore执行了");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("Main2","onSave执行了");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Main2","onStart执行了");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Main2","onResume执行了");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Main2","onPause执行了");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Main2","onStop执行了");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Main2", "onDestroy执行了");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("Main2", "onChange执行了");
    }
}
