package com.byhieg.activityquitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {


    public Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mButton = (Button) findViewById(R.id.button3);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                intent.putExtra(MainActivity.ACTION, true);
                startActivity(intent);
//                Intent intent1 = new Intent();
//                intent1.setAction(MainActivity.ACTION);
//                sendBroadcast(intent1);

            }
        });
    }

    @Override
    protected void onDestroy() {
        Log.e("quit", "ThirdActivity退出");
        super.onDestroy();
    }
}
