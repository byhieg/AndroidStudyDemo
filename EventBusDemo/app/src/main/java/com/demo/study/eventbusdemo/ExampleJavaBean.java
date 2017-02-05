package com.demo.study.eventbusdemo;

import java.io.Serializable;

/**
 * Created by byhieg on 17/2/5.
 * Contact with byhieg@gmail.com
 */

public class ExampleJavaBean implements Serializable{

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
