package com.example.giaodiendangnhap;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entity.Album;

public class QuanLiBaiHatActivity extends AppCompatActivity {

    TextView textView_title;
    Button button_add, button_xem, button_quanli;
    final int CODEADD = 123;
   public static List<Album> listAlbum;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_bai_hat);
        anhxa();
        button_add.setOnClickListener(view -> {
            startActivityForResult(new Intent(this, ThemAlbumDialogActivity.class), CODEADD);
        });
        button_xem.setOnClickListener(view -> {
            startActivity(new Intent(this,DanhSachAlbumActivity.class));
        });
        button_quanli.setOnClickListener(view -> {
            startActivity(new Intent(this,QuanlyAlbumActivity.class));
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODEADD && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras().getBundle("data");
           listAlbum.add(new Album( bundle.getString("maAlbum"), bundle.getString("tenAlbum")));
            Toast.makeText(this, "Them thanh cong!", Toast.LENGTH_SHORT).show();
        }
    }

    private void anhxa() {
        listAlbum = new ArrayList<>();
        textView_title = findViewById(R.id.textView_titleQLBaiHat);
        button_add = findViewById(R.id.button_themBaiHat);
        button_xem = findViewById(R.id.button_xemDS);
        button_quanli = findViewById(R.id.button_quanliBH);

    }
}