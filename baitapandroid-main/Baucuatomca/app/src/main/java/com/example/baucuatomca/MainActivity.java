package com.example.baucuatomca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Integer> listAnh;
    List<ImageView> imageViewList;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView.setImageResource();
        gridView.addView();
    }

    private void addMageVIewList() {
        for (Integer i : listAnh) {
            ImageView imageView = new ImageView(this);
            imageViewList.add(imageView.setImageResource(i));
            imageView.setImageResource(getResources().getIdentifier(MainActivity.list.get(index), "drawable", getPackageName()));
        }
    }

    private void khoiTaoGT() {
        imageViewList = new ArrayList<>();

        listAnh = new ArrayList<>();
        listAnh.add(R.drawable.bau);
        listAnh.add(R.drawable.cua);
        listAnh.add(R.drawable.tom);
        listAnh.add(R.drawable.ca);
        listAnh.add(R.drawable.nai);
        listAnh.add(R.drawable.ga);
    }
}