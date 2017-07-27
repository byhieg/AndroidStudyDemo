package com.meitu.library.modularprotocol.samplemodule2;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.meitu.library.modularprotocol.Protocol;


/**
 * Created by hxd on 16/6/20.
 */
@Protocol("ModuleBarStub")
public class TestForServer {

    public void testMethod(String msg, Context context,
                           TextView textView) {
        Log.e("ProtocolInterpreter", "startEnd:"+System.currentTimeMillis());
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}

