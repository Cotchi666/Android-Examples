package com.example.quanlinhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LoadvaXoaCacheActivity extends AppCompatActivity {
    TextView textView;
    private Button button_xoa1, button_xoaAll;
    private ListView listView_Cache;
    private ArrayAdapter adapter;
    private List<String> list;
    int index = 0;
    File file;
    File[] files;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadva_xoa_cache);


    }

    @Override
    protected void onResume() {
        super.onResume();
        anhxa();
        khoitaoDS();
        loadCache(files);
        listView_Cache.setAdapter(adapter);
        listView_Cache.setOnItemClickListener((adapterView, view, i, l) -> {
            index = i;
            Toast.makeText(this, index + "", Toast.LENGTH_SHORT).show();
        });
        button_xoa1.setOnClickListener(view -> {
            files[index].delete();
            list.remove(index);
            adapter.notifyDataSetChanged();
        });
        button_xoaAll.setOnClickListener(view -> {
            xoaAll(files);
        });
        textView.setOnClickListener(view -> {
            startActivity(new Intent(this, DocGhiCaheActivity.class));
        });
        Toast.makeText(this, "lenght: " + files.length + " onResume", Toast.LENGTH_SHORT).show();
        listView_Cache.setOnItemLongClickListener((adapterView, view, i, l) -> {
            startActivity(new Intent(LoadvaXoaCacheActivity.this, DocGhiCaheActivity.class).putExtra("data", list.get(i)));
            return false;
        });
    }

    private void loadCache(File[] files) {
        list.clear();
        // File file = getFilesDir();
        for (File f : files) {
            list.add(f.getName());

        }
        adapter.notifyDataSetChanged();
    }

    private void khoitaoDS() {
        file = getCacheDir();
        files = file.listFiles();
        list = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
    }

    private void xoaAll(File[] files) {
        list.clear();
        // File file = getFilesDir();
        for (File f : files) {
            f.delete();
        }
        adapter.notifyDataSetChanged();
    }

    private void anhxa() {

        button_xoa1 = findViewById(R.id.button_xoa1);
        button_xoaAll = findViewById(R.id.button_xoaAll);
        listView_Cache = findViewById(R.id.list_ViewCache);
        textView = findViewById(R.id.textView_titles);
    }
}