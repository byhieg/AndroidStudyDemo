package com.demo.study.fragmentdemo;

import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView textView;
    public FragmentManager fragmentManager;
    public DataFragment dataFragement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        dataFragement = new DataFragment();
        fragmentManager.beginTransaction().add(R.id.fragment_container,dataFragement,DataFragment.TAG).commit();

        textView = (TextView)findViewById(R.id.text);
        dataFragement.setCallBack(new DataFragment.CallBack() {
            @Override
            public void onResponse(String result) {
                textView.setText(result);
            }
        });
    }
}
