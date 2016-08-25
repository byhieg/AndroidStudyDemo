package com.byhieg.activityquitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AtyContainer.getInstance().addActivity(this);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        AtyContainer.getInstance().removeActivity(this);
    }
}

class AtyContainer{
    private AtyContainer(){

    }

    private static AtyContainer instance = new AtyContainer();
    private static List<AppCompatActivity> activityStack = new ArrayList<>();


    public static AtyContainer getInstance(){
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
