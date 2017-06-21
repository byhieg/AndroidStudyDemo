package com.byhieg.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FirstService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("FirstService","onCreate被调用了");
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        Log.e("FirstService","onStartCommand被调用");
        Log.e("FirstService", "这次的startId" + startId);
        stopService(intent);
        return super.onStartCommand(intent, flags, startId);
    }


    public FirstService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("FirstService","onDestroy被调用");
    }
}
