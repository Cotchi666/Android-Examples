package com.example.giaodiendangnhap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import adapter.AlbumAdapter;
import entity.Album;

public class DanhSachAlbumActivity extends AppCompatActivity {


    TextView textView_title;
    ListView listView;
    public static AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_album);
        anhxa();
        albumAdapter = new AlbumAdapter(QuanLiBaiHatActivity.listAlbum, this, R.layout.dong_album);
        listView.setAdapter(albumAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            startActivity(new Intent(this, UpdateAlbumDialogActivity.class).putExtra("int", i));
        });
        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            xoa(i);

            return true;
        });
    }


    private void xoa(final int number) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo!");
        builder.setTitle("Bạn chắc chắn muốn xóa?");
        builder.setPositiveButton("Có", (dialogInterface, i) -> {
            QuanLiBaiHatActivity.listAlbum.remove(number);
            albumAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Xóa thành công!", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("Không", (dialogInterface, i) -> {
        });
        builder.show();
    }

    private void anhxa() {
        textView_title = findViewById(R.id.textView_titleDS);
        listView = findViewById(R.id.listView_Album);
    }
}