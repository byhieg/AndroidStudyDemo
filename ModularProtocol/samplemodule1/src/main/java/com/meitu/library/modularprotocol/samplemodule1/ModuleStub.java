package com.meitu.library.modularprotocol.samplemodule1;

import android.content.Context;
import android.widget.TextView;

import com.meitu.library.modularprotocol.ProtocolShadow;


/**
 * Created by hxd on 16/3/28.
 */
@ProtocolShadow("ModuleBarStub")
public interface ModuleStub {

    public void testMethod(String msg, Context context, TextView textView);
}
