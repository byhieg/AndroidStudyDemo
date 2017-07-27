package com.meitu.library.modularprotocol.sampleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meitu.library.modularprotocol.ProtocolInterpreter;
import com.meitu.library.modularprotocol.samplemodule1.Module1Activity;

/**
 * container  module
 * Created by hxd on 16/3/24.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ProtocolInterpreter.getDefault().init(this);
        final TextView textView = (TextView) findViewById(R.id.text_test_shadow);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Module1Activity.class));
            }
        });
    }

}
