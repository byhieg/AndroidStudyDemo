package cn.byhieg.vieweventdemo;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by byhieg on 17/6/21.
 * Contact with byhieg@gmail.com
 */

public class MyButtonView extends AppCompatButton {

    public final String TAG = "MyButtonView";

    public MyButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "Down");
                return false;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "Move");
                return false;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "CANCEL");
                return true;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "Up");
                return true;
        }
        return super.onTouchEvent(event);
    }
}
