package cn.byhieg.roomdemo.db;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import cn.byhieg.roomdemo.db.dao.UserDao;
import cn.byhieg.roomdemo.db.entity.UserEntity;

/**
 * Created by byhieg on 17/5/20.
 * Contact with byhieg@gmail.com
 */
@Database(entities = {UserEntity.class},version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase{

    public static final String DATABASE_NAME = "room-demo-db";

    public abstract UserDao userDao();


}
