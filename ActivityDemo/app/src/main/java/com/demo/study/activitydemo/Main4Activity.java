package com.demo.study.activitydemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Main4Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Log.d("Main4","onCreate执行了");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main4","onStart执行了");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main4","onResume执行了");
    }


}
