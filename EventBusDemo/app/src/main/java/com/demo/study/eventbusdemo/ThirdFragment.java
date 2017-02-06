package com.demo.study.eventbusdemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.demo.study.eventbusdemo.event.BackGroundEvent;
import com.demo.study.eventbusdemo.event.ObjectEvent;

import org.greenrobot.eventbus.EventBus;


public class ThirdFragment extends Fragment {

    private View view;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_third, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        Button button = (Button) view.findViewById(R.id.button);
        final TextView text = (TextView) view.findViewById(R.id.text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MainActivity.class));
                ObjectEvent oe = new ObjectEvent();
                oe.setMessage(text.getText().toString());
                oe.setExampleJavaBean(new ExampleJavaBean());
                EventBus.getDefault().post(oe);
                BackGroundEvent backGroundEvent = new BackGroundEvent();
                backGroundEvent.setMessage("byhiegaaa");
                EventBus.getDefault().post(backGroundEvent);


            }
        });
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
