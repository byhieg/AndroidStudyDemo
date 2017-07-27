package com.meitu.library.modularprotocol.samplemodule1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meitu.library.modularprotocol.ProtocolInterpreter;

/**
 * Created by yangsq on 2017/6/9.
 */

public class Module1Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module1_activity);
        final TextView textView = (TextView) findViewById(R.id.text_test_shadow);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProtocolInterpreter.getDefault()
                        .create(ModuleStub.class)
                        .testMethod("from module2!", getApplicationContext(), textView);
            }
        });
    }
}
