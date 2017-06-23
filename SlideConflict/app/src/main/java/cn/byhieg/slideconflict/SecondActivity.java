package cn.byhieg.slideconflict;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {


    public ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        listView = (ListView) findViewById(R.id.listView4);

        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout
                .simple_expandable_list_item_1,getData4()));
    }

    public List<String> getData4() {
        List<String> list = new ArrayList<>();
        list.add("10");
        list.add("20");
        list.add("30");
        list.add("40");
        list.add("50");
        list.add("60");
        list.add("70");
        list.add("80");
        list.add("90");
        list.add("100");
        list.add("110");
        list.add("120");
        return list;
    }
}
