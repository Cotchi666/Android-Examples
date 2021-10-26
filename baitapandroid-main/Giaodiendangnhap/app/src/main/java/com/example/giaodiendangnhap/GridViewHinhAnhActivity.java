package com.example.giaodiendangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adapter.HinhAnhAdapter;

public class GridViewHinhAnhActivity extends AppCompatActivity {

    List<Integer> listHinhAnh;
    GridView gridView;
    HinhAnhAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_hinh_anh);
        gridView = findViewById(R.id.gridView_ha);
        khoiTaoDS();
        adapter = new HinhAnhAdapter(listHinhAnh, this, R.layout.dong_hinhanh);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
         //       Bundle bundle = new Bundle();
                Intent intent= new Intent(GridViewHinhAnhActivity.this,PhongToAnhActivity.class);
                intent.putExtra("a",listHinhAnh.get(i));
                startActivity(intent);

            }
        });
    }

    private void khoiTaoDS() {
        listHinhAnh = Arrays.asList(R.drawable.drm1,
                R.drawable.drm2,
                R.drawable.drm3,
                R.drawable.drm4,
                R.drawable.drm15,
                R.drawable.drm6,
                R.drawable.drm7,
                R.drawable.drm8,
                R.drawable.drm9,
                R.drawable.drm10,
                R.drawable.drm11,
                R.drawable.drm12,
                R.drawable.drm13,
                R.drawable.drm14
        );
    }
}