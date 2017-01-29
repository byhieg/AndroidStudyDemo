package com.demo.study.fragmentdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment implements View.OnClickListener{
    public static final String TAG = "com.demo.study.fragmentdemo.DataFragment";
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    private CallBack callBack;

    public String result = "按钮还没有点击";


    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        initView(view);
        return view;
    }


    public void initView(View view) {
        button1 = (Button)view.findViewById(R.id.button_1);
        button2 = (Button)view.findViewById(R.id.button_2);
        button3 = (Button)view.findViewById(R.id.button_3);
        button4 = (Button)view.findViewById(R.id.button_4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }




    public void setCallBack(CallBack callBack){
        this.callBack = callBack;
    }

    private void notifyData(String result){
        callBack.onResponse(result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_1:
                notifyData("按钮一的内容");
                break;
            case R.id.button_2:
                notifyData("按钮二的内容");
                break;
            case R.id.button_3:
                notifyData("按钮三的内容");
                break;
            case R.id.button_4:
                notifyData("按钮四的内容");
                break;
        }
    }


    public interface CallBack{
        void onResponse(String result);
    }
}
