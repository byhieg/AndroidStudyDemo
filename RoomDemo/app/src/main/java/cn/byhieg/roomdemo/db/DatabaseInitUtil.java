package cn.byhieg.roomdemo.db;

import java.util.ArrayList;
import java.util.List;

import cn.byhieg.roomdemo.db.dao.UserDao;
import cn.byhieg.roomdemo.db.entity.UserEntity;

/**
 * Created by byhieg on 17/5/20.
 * Contact with byhieg@gmail.com
 */

public class DatabaseInitUtil {

    private static final String[] firstNames = new String[]{
            "琦峰","盗号"
    };

    private static final String[] lastNames = new String[]{
            "石","刘"
    };

    private static final int[] age = new int[]{
            24,25
    };


    static void initDb(AppDataBase db) {
        List<UserEntity> users = new ArrayList<>();
        generateData(users);
        insertData(db,users);
    }

    private static void generateData(List<UserEntity> userDaos) {
        for (int i = 0; i < 2; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setFirstName(firstNames[i]);
            userEntity.setLastName(lastNames[i]);
            userEntity.setAge(age[i]);
            userEntity.setId(i + 1);
            userDaos.add(userEntity);
        }

    }


    private static void insertData(AppDataBase db, List<UserEntity> userEntities) {
        db.beginTransaction();
        try{
            db.userDao().insertAll(userEntities);
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }

}
