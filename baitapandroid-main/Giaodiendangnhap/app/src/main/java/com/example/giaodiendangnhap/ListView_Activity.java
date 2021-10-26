package com.example.giaodiendangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class ListView_Activity extends AppCompatActivity {

    ListView listView_l;
    TextView textView_list;
    ArrayAdapter adapter;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        listView_l = findViewById(R.id.list_View);
        textView_list = findViewById(R.id.textView_list);
        list = Arrays.asList(getResources().getStringArray(R.array.list));
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView_l.setAdapter(adapter);
        listView_l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView_list.setText("position: " + i + " ;value: " + list.get(i));
            }
        });

    }
}