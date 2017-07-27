package cn.byhieg.mvvmdemo;

/**
 * Created by byhieg on 2017/7/27.
 * Contact with byhieg@gmail.com
 */

public class ViewModel {

    private ActivityMainBinding activityMainBinding;
    private ContentMainBinding contentMainBinding;
    private AppCompatActivity activity;

    private UserBean user;

    public ViewModel(AppCompatActivity activity, ActivityMainBinding activityMainBinding){
        this.activity = activity;
        this.activityMainBinding = activityMainBinding;
        this.contentMainBinding = activityMainBinding.contentMain;
        init();
    }

    public void init(){
        activity.setSupportActionBar(activityMainBinding.toolbar);
        activityMainBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        user = new UserBean();
        contentMainBinding.setViewModel(this);

    }

    public void applyUser(View v){
        Snackbar.make(v,"提交成功",Snackbar.LENGTH_SHORT).setAction("Action",null).show();
        user.name.set(contentMainBinding.name.getText().toString());
        user.sex.set(contentMainBinding.sex.getText().toString());
        user.age.set(Integer.valueOf(contentMainBinding.age.getText().toString()));
    }
}
