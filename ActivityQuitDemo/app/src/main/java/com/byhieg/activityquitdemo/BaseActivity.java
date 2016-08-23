package com.byhieg.activityquitdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    protected static final String EXITACTION = "action.exit";

    private ExitReceiver mExitReceiver = new ExitReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActivityContainer.getInstance().addActivity(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(EXITACTION);
        registerReceiver(mExitReceiver, intentFilter);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
//        ActivityContainer.getInstance().removeActivity(this);
        unregisterReceiver(mExitReceiver);
    }

    class ExitReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            BaseActivity.this.finish();
        }
    }

}

class ActivityContainer {
    private ActivityContainer(){

    }

    private static ActivityContainer instance = new ActivityContainer();
    private static List<AppCompatActivity> activityStack = new LinkedList<>();


    public static ActivityContainer getInstance(){
        return instance;
    }

    public void addActivity(AppCompatActivity aty) {
        activityStack.add(aty);
    }

    public void removeActivity(AppCompatActivity aty) {
        activityStack.remove(aty);
    }


    /**
     * 结束所有的Activity
     */
    public void finishAllActivity(){
        for (int i = 0 , size = activityStack.size(); i < size;i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }
}


