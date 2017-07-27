package cn.byhieg.mvvmdemo;

import android.databinding.ObservableField;

/**
 * Created by byhieg on 2017/7/27.
 * Contact with byhieg@gmail.com
 */

public class User {

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> sex = new ObservableField<>();
    public ObservableField<Integer> age = new ObservableField<>() ;

    public User(){
        name.set("shiqifeng");
        sex.set("男");
        age.set(19);
    }
}
