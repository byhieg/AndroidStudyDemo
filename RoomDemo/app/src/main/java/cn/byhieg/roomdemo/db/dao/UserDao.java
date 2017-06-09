package cn.byhieg.roomdemo.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import cn.byhieg.roomdemo.db.entity.UserEntity;

/**
 * Created by byhieg on 17/5/20.
 * Contact with byhieg@gmail.com
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<UserEntity> loadAllUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<UserEntity> users);

    @Query("SELECT * FROM user where age = :age")
    List<UserEntity> loadUser(int age);

}


