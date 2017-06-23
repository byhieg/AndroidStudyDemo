package cn.byhieg.slideconflict;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by byhieg on 17/6/23.
 * Contact with byhieg@gmail.com
 */

public class SlideScollView extends ScrollView {


    public int lastInterceptX;
    public int lastInterceptY;

    public SlideScollView(Context context) {
        super(context);
    }

    public SlideScollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideScollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int)ev.getY();
        boolean isIntercept = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastInterceptX = x;
                lastInterceptY = y;
                isIntercept = false;
                break;
            case MotionEvent.ACTION_MOVE:
                int delx = x - lastInterceptX;
                int dely = y - lastInterceptY;
                if (y > 100){
                    isIntercept = true;
                }
                if (Math.abs(dely) > Math.abs(delx)) {
                    isIntercept = true;
                }
                break;
            case MotionEvent.ACTION_UP:


                break;
        }
        return isIntercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }




}
