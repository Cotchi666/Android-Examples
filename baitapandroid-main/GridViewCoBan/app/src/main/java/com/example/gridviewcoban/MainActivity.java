package com.example.gridviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    String[] mang = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "H", "L", "M", "N", "O", "P", "Q", "R", "S",
            "T", "U", "V", "A", "W", "X", "Y", "Z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, mang);
        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, mang[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}