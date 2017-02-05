package com.demo.study.eventbusdemo.event;

import com.demo.study.eventbusdemo.ExampleJavaBean;

/**
 * Created by byhieg on 17/2/5.
 * Contact with byhieg@gmail.com
 */

public class ObjectEvent {
    public String message;
    public ExampleJavaBean exampleJavaBean;


    public ExampleJavaBean getExampleJavaBean() {
        return exampleJavaBean;
    }

    public void setExampleJavaBean(ExampleJavaBean exampleJavaBean) {
        this.exampleJavaBean = exampleJavaBean;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
