package com.demo.study.activitydemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Button button;
    public Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("提示"); //设置标题
                builder.setMessage("是否确认退出?"); //设置内容
                builder.setIcon(R.mipmap.ic_launcher);//设置图标，图片id即可
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { //设置确定按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); //关闭dialog
                        Toast.makeText(MainActivity.this, "确认" + which, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { //设置取消按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "取消" + which, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });
        Log.e("onCreate", "执行了");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("onRestore", "执行了");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("key","value");
        Log.e("onSave", "执行了");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "执行了");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "执行了");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "执行了");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "执行了");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "执行了");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestory","执行了");
    }
}
