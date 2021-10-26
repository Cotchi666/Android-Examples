package com.example.gitdviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    List<HinhAnh> list;
    HinhAnhAdapter hinhAnhAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        hinhAnhAdapter = new HinhAnhAdapter(list,this,R.layout.dong_hinh_anh);
        gridView.setAdapter(hinhAnhAdapter);
        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(MainActivity.this, list.get(i).getName(), Toast.LENGTH_SHORT).show();
        });

    }

    private void anhXa() {
        gridView = findViewById(R.id.gridView);
        list = new ArrayList<>();
        list.add(new HinhAnh("hinh 1", R.drawable.a1));
        list.add(new HinhAnh("hinh 2", R.drawable.a2));
        list.add(new HinhAnh("hinh 3", R.drawable.a3));
        list.add(new HinhAnh("hinh 4", R.drawable.mu));

    }
}