package com.byhieg.servicedemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SecondeService mService;
    private Messenger mMessenger;
    public TextView mTextView;

    public ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            SecondeService.MyBinder myBinder = (SecondeService.MyBinder) iBinder;
            String info = myBinder.getServiceInfo();
            Log.e("MainActivity", info);
            mService = myBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    public ServiceConnection remoteConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mMessenger = new Messenger(iBinder);
            Message mMsg = Message.obtain(null,100);
            Bundle data = new Bundle();
            data.putString("msg","远程Service");
            mMsg.setData(data);
            try {
                mMessenger.send(mMsg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(this, FirstService.class);
//        startService(intent);
//        startService(intent);

        final Intent intent = new Intent(this, SecondeService.class);
        startService(intent);
        Intent remoteIntent = new Intent(this, RemoteService.class);
        bindService(intent, conn, Service.BIND_AUTO_CREATE);
        bindService(remoteIntent, remoteConn, Service.BIND_AUTO_CREATE);
        mTextView = (TextView) findViewById(R.id.text);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(conn);
                bindService(intent, conn, Context.BIND_AUTO_CREATE);
                Log.e("MainActivity", mService.toString());
            }
        });
//        Log.e("MainActivity", info);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
