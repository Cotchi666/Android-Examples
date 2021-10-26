package com.example.giaodiendangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import entity.Album;

public class UpdateAlbumDialogActivity extends AppCompatActivity {
    TextView textView_tittle, textView_maAlbum, textView_tenAblum;
    EditText editText_maAlbum, editText_tenAlbum;
    Button button_xoa, button_update;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_album_dialog);
        anhxa();
        i = getIntent().getIntExtra("int", 0);
        button_update.setOnClickListener(view -> {
            QuanLiBaiHatActivity.listAlbum.set(i, new Album(editText_maAlbum.getText().toString(), editText_tenAlbum.getText().toString()));
            DanhSachAlbumActivity.albumAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Update thành công!", Toast.LENGTH_SHORT).show();
            finish();
        });
        button_xoa.setOnClickListener(view -> {
            editText_maAlbum.setText("");
            editText_tenAlbum.setText("");
        });


    }

    protected void anhxa() {
        textView_tittle = findViewById(R.id.textView_titleUpdateAlbum);
        textView_maAlbum = findViewById(R.id.textView_maAlbumUpdate);
        editText_tenAlbum = findViewById(R.id.edit_tenAlbumUpdate);
        textView_tenAblum = findViewById(R.id.textView_tenAlbumUpdate);
        editText_maAlbum = findViewById(R.id.edit_maAlbumUpdate);
        button_update = findViewById(R.id.button_Update);
        button_xoa = findViewById(R.id.button_xoaTrangUpdate);
    }
}