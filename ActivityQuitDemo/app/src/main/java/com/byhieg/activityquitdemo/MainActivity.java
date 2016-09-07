package com.byhieg.activityquitdemo;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    public Button mButton1;

    public Button quitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = (Button) findViewById(R.id.button1);
        quitButton = (Button) findViewById(R.id.button5);
        mButton1.setOnClickListener(this);
        quitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;

            case R.id.button5:
//                ActivityContainer.getInstance().finishAllActivity();
//                Intent intent1 = new Intent();
//                intent1.setAction(EXITACTION);
//                sendBroadcast(intent1);
//                break;
//                android.os.Process.killProcess(android.os.Process.myPid());
//                System.exit(0);
                ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                manager.killBackgroundProcesses(getPackageName());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        Log.e("quit", "MainActivity退出");
        super.onDestroy();
    }
}
