package cn.byhieg.messengerdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class MessengerService extends Service {

    public static final String TAG = "MessengerService";

    public MessengerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e(TAG,"已经收到");
        return mMessenger.getBinder();
    }

    private static class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 101:
                    Log.i(TAG,"收到消息从客户端" + msg.getData().getString("msg"));
                    Messenger client = msg.replyTo;
                    Message relpyMessage = Message.obtain(null,102);
                    Bundle bundle = new Bundle();
                    bundle.putString("reply","恩，你的消息我已经收到，稍后会回复你");
                    relpyMessage.setData(bundle);
                    try{
                        client.send(relpyMessage);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    Log.e(TAG,"没有收到");
                    super.handleMessage(msg);
            }
        }
    }

    private final Messenger mMessenger = new Messenger(new MessengerHandler());

}
