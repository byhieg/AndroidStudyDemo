package cn.byhieg.slideconflict;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public ListView listView1;
    public ListView listView2;
    public ListView listView3;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1 = (ListView) findViewById(R.id.listView1);
        listView2 = (ListView) findViewById(R.id.listView2);
        listView3 = (ListView) findViewById(R.id.listView3);
        button = (Button) findViewById(R.id.button);


        listView1.setAdapter(new ArrayAdapter<>(this, android.R.layout
                .simple_expandable_list_item_1,getData1()));

        listView2.setAdapter(new ArrayAdapter<>(this, android.R.layout
                .simple_expandable_list_item_1,getData2()));

        listView3.setAdapter(new ArrayAdapter<>(this, android.R.layout
                .simple_expandable_list_item_1,getData3()));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public List<String> getData1() {
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

    public List<String> getData2() {
        List<String> list = new ArrayList<>();
        list.add("200");
        list.add("210");
        list.add("220");
        list.add("230");
        list.add("240");
        list.add("250");
        list.add("260");
        list.add("270");
        list.add("280");
        list.add("290");
        list.add("300");
        list.add("310");
        return list;
    }

    public List<String> getData3() {
        List<String> list = new ArrayList<>();
        list.add("300");
        list.add("310");
        list.add("320");
        list.add("330");
        list.add("340");
        list.add("350");
        list.add("360");
        list.add("370");
        list.add("380");
        list.add("390");
        list.add("400");
        list.add("410");
        return list;
    }
}
