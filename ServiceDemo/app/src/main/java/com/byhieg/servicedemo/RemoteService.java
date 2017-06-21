package com.byhieg.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

public class RemoteService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("RemoteService", "已经启动");
    }

    public RemoteService() {
    }

    private static class MessengerHandler extends Handler {


        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100:
                    Log.e("RemoteService", msg.getData().getString("msg").toString());
                    break;
            }

        }
    }

    private final Messenger mMessenger = new Messenger(new MessengerHandler());
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mMessenger.getBinder();
    }
}
