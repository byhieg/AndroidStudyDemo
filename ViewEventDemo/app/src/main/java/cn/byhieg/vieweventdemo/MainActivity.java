package cn.byhieg.vieweventdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    public MyScollerView mScrollView;
    public MyButtonView mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScrollView = (MyScollerView) findViewById(R.id.scrollView);
        mButton = (MyButtonView) findViewById(R.id.button);
    }
}
