package cn.byhieg.roomdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import cn.byhieg.roomdemo.db.DatabaseCreator;
import cn.byhieg.roomdemo.db.entity.UserEntity;
import cn.byhieg.roomdemo.model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView query;
    public TextView result;
    public TextView queryName;
    private DatabaseCreator mDatabaseCreator;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        query = (TextView) findViewById(R.id.query);
        result = (TextView) findViewById(R.id.query_result);
        queryName = (TextView) findViewById(R.id.queryName);

        mDatabaseCreator = DatabaseCreator.getInstance();
        mDatabaseCreator.createDb(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        query.setOnClickListener(this);
        queryName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.query:
                if (mDatabaseCreator.getDatabase() != null) {
                    final CharSequence name = queryName.getText();
                    new Thread(new Runnable() {
                        List<UserEntity> users;
                        @Override
                        public void run() {
                            if (name.toString().equals("")) {
                                users = mDatabaseCreator.getDatabase().userDao()
                                        .loadAllUser();
                            }else{
                                users = mDatabaseCreator.getDatabase().userDao().
                                        loadUser(Integer.valueOf(name.toString()));
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    result.setText("");
                                    for (UserEntity user : users) {
                                        result.append(user.getFirstName() + " " + user.getLastName() + " " +
                                                user.getAge() + "\n");
                                    }
                                }
                            });
                        }
                    }).start();
                }
                break;

        }
    }
}
