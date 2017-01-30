package com.demo.study.rxdemo.school;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byhieg on 17/1/30.
 */

public class SchoolClass {

    public Student[] students = new Student[5];

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
