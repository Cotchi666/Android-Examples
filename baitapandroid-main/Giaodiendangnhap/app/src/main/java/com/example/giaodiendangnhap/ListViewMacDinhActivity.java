package com.example.giaodiendangnhap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewMacDinhActivity extends ListActivity {

    TextView textView;
    String[] mang = {"huong", "dep trai", "samsung", "xiaomi", "apple", "nokia", "window", "mac os"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_mac_dinh);
        setListAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, mang));
        textView = findViewById(R.id.textView_macdinh);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        textView.setText("positi: " + position + ", value: " + mang[position]);
    }
}