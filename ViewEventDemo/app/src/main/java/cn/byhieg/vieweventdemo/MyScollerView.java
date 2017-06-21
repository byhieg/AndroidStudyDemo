package cn.byhieg.vieweventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by byhieg on 17/6/21.
 * Contact with byhieg@gmail.com
 */

public class MyScollerView extends ScrollView {
    private final String TAG = "MyScrollerView";

    public MyScollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onInterceptTouch Down");
                return false;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onInterceptTouch Move");
                return true;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onInterceptTouch Up");
                return false;
        }
        return super.onInterceptHoverEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "OnTouchEvent Down");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "OnTouchEvent Move");
                return true;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "OnTouchEvent Up");
                return false;
        }
        return super.onTouchEvent(ev);
    }
}
