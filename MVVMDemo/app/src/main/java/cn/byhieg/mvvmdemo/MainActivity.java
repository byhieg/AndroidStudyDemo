package cn.byhieg.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.byhieg.mvvmdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout
                .activity_main);
        final User user = new User();
        activityMainBinding.setUser(user);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                user.name = new ObservableField<String>("byhieg");
                activityMainBinding.setUser(user);
            }
        },3000);
    }
}
