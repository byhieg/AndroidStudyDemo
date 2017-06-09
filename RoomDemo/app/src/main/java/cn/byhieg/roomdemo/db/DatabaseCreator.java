package cn.byhieg.roomdemo.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ExpandableListView;

import java.util.concurrent.atomic.AtomicBoolean;

import static cn.byhieg.roomdemo.db.AppDataBase.DATABASE_NAME;

/**
 * Created by byhieg on 17/5/20.
 * Contact with byhieg@gmail.com
 */

public class DatabaseCreator {

    private static DatabaseCreator sInstance;

    private static  AppDataBase mDb;

    private final AtomicBoolean mInitializing = new AtomicBoolean(true);


    private static final Object LOCK = new Object();

    public synchronized static DatabaseCreator getInstance(){
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new DatabaseCreator();
                }
            }
        }

        return sInstance;
    }

    @Nullable
    public AppDataBase getDatabase(){
        return mDb;
    }


    public void createDb(Context context){
        //真牛逼
        if (!mInitializing.compareAndSet(true, false)) {
            return;
        }

        new MyAsyncTask<Context,Void,Void>().execute(context.getApplicationContext());


    }

    static class MyAsyncTask<T extends Context,M,N> extends AsyncTask<T,M,N>{

        @Override
        protected N doInBackground(T[] ts) {
            Context context = ts[0].getApplicationContext();
            context.deleteDatabase(DATABASE_NAME);
            AppDataBase db = Room.databaseBuilder(context, AppDataBase.class, DATABASE_NAME).build();

            DatabaseInitUtil.initDb(db);
            mDb = db;
            return null;
        }

    }


}
