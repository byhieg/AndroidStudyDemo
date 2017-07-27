package com.meitu.library.modularprotocol;

import android.widget.Toast;
import android.content.Context;

/**
 * 检查不到类和方式时的默认处理方式
 * Created by yangsq on 2017/5/31.
 */

public class DefaultCheckClassMethodImpl implements ICheckClassMethodCallback {
    private Context mContext;

    public DefaultCheckClassMethodImpl(Context context) {
        mContext = context;
    }


    @Override
    public void onCheckClassFail(String targetClassName, String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckMethodFail(String targetMethodName, String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
