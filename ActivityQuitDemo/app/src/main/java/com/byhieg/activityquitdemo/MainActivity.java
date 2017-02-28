package com.byhieg.activityquitdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    public Button mButton1;
    public static final String ACTION = "action.exit.main";
    public Button quitButton;
    private MainExitReceiver registerReceiver = new MainExitReceiver();
    private boolean isExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = (Button) findViewById(R.id.button1);
        quitButton = (Button) findViewById(R.id.button5);
        mButton1.setOnClickListener(this);
        quitButton.setOnClickListener(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION);
        registerReceiver(registerReceiver, intentFilter);
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
//                ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
//                manager.killBackgroundProcesses(getPackageName());

                break;
        }
    }

    @Override
    protected void onDestroy() {
        Log.e("quit", "MainActivity退出");
        super.onDestroy();
        unregisterReceiver(registerReceiver);
    }

    class MainExitReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
//            MainActivity.this.finish();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
//        Log.e("main", "onNewIntent调用");
//        if (intent != null) {
//            boolean isExit = intent.getBooleanExtra(ACTION, false);
//            if (isExit) {
//                this.finish();
//            }
//        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.e("main", "触发了嘛");
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isExit) {
                this.finish();
            }else {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                isExit = true;
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        isExit = false;
//                    }
//                },2000);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                      isExit = false;
                    }
                },2000);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
