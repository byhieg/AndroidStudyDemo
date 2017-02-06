package com.demo.study.eventbusdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.demo.study.eventbusdemo.event.ObjectEvent;

import org.greenrobot.eventbus.EventBus;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ExampleJavaBean exampleJavaBean = new ExampleJavaBean();
        exampleJavaBean.setName("byhieg");
        exampleJavaBean.setAge("24");
        ObjectEvent objectEvent = new ObjectEvent();
        objectEvent.setExampleJavaBean(exampleJavaBean);
        objectEvent.setMessage("来自Service的消息");
        EventBus.getDefault().post(objectEvent);
        return super.onStartCommand(intent, flags, startId);

    }
}
