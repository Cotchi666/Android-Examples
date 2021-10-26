package com.example.listnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List list;
    TraiCayAdapter traiCayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        traiCayAdapter = new TraiCayAdapter(this, R.layout.dong, list);
        listView.setAdapter(traiCayAdapter);
    }

    private void anhxa() {
        listView = findViewById(R.id.listTraiCay);
        list = new ArrayList<TraiCay>();
        list.add(new TraiCay("Buoi", "Buoi dao", R.drawable.buoi));
        list.add(new TraiCay("Mit", "mit thai", R.drawable.mit));
        list.add(new TraiCay("Cam", "cam tranh", R.drawable.cam));
        list.add(new TraiCay("Tao", "tao mi", R.drawable.tao));
        list.add(new TraiCay("Hong xiem", "hong xiem khong hat", R.drawable.hongxiem));
        list.add(new TraiCay("Dao", "dao my ngon lam", R.drawable.dao));
        list.add(new TraiCay("doremon", "doremon1", R.drawable.drm1));
        list.add(new TraiCay("Doremon", "doremon2", R.drawable.drm2));
        list.add(new TraiCay("doremon", "doremon3", R.drawable.drm3));
        list.add(new TraiCay("Doremon", "doremon4", R.drawable.drm4));
        list.add(new TraiCay("doremon", "doremon6", R.drawable.drm6));


    }
}