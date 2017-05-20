package cn.byhieg.roomdemo.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import cn.byhieg.roomdemo.model.User;

/**
 * Created by byhieg on 17/5/20.
 * Contact with byhieg@gmail.com
 */

@Entity(tableName = "user")
public class UserEntity implements User{

    @PrimaryKey
    private int id;
    private String firstName;
    private String lastName;
    private int age;


    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
