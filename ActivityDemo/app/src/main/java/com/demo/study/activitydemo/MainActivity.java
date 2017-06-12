package com.demo.study.activitydemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button button;
    public Button button1;
    public Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.dialog);
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

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(intent);
            }
        });
        if (savedInstanceState != null) {
            Log.e("回复的内容", savedInstanceState.getString("key"));
        }
        Log.e("Main1", "onCreate执行了");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("Main1", "onRestore执行了");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key","value");
        Log.e("Main1", "onSave执行了");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Main1", "onStart执行了");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Main1", "onResume执行了");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Main1", "onPause执行了");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Main1", "onStop执行了");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Main1", "onRestart执行了");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Main1","onDestroy执行了");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("Main1", "onNewIntent执行了");
    }
}
