package com.demo.study.rxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.demo.study.rxdemo.school.SchoolClass;
import com.demo.study.rxdemo.school.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class FlatMapActivity extends AppCompatActivity {

    @BindView(R.id.result)
    public TextView result;

    private SchoolClass[] schoolClasses = new SchoolClass[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flat_map);
        ButterKnife.bind(this);

        for (int i = 0; i < 3; i++) {
            SchoolClass schoolClass = new SchoolClass();
            Student[] students = new Student[5];
            for (int j = 0; j < 5; j++) {
                Student student = new Student();
                student.setName(new Random().nextInt(100) + " ");
                student.setAge(new Random().nextInt(20));
                students[j] = student;
            }
            schoolClass.setStudents(students);
            schoolClasses[i] = schoolClass;
        }
    }


    @OnClick(R.id.start)
    public void submit() {
        Observable.from(schoolClasses).
                flatMap(new Func1<SchoolClass, Observable<? extends Student>>() {
                    @Override
                    public Observable<? extends Student> call(SchoolClass schoolClass) {
                        return Observable.from(schoolClass.getStudents());
                    }
                }).
                subscribe(new Action1<Student>() {
                    @Override
                    public void call(Student student) {
                        result.append("打印单个学生信息：\n");
                        result.append("name:"+student.name+"    age: "+student.age+"\n");
                    }
                });
    }
}
