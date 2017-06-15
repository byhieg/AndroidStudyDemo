package com.byhieg.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class SecondeService extends Service {

    private final IBinder mBinder = new MyBinder();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("SecondService", "onCreate已经启动");
    }


    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Log.e("SecondService", "onStartCommand已经启动");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e("SecondService", "onBind已经启动");
        return mBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.e("SecondService", "onRebind被调用");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("SecondService", "onDestroy被调用");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return false;
    }

    class MyBinder extends Binder{

        public String getServiceInfo(){
            return "这是BindService";
        }

        public SecondeService getService(){
            return SecondeService.this;
        }
    }
}
