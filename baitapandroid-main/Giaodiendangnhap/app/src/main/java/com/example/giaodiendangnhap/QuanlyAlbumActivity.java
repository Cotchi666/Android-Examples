package com.example.giaodiendangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import entity.Album;

public class QuanlyAlbumActivity extends AppCompatActivity {

    TextView textView_title, textView_tenBH, textView_ngay;
    Spinner spinner;
    EditText editText_ten, editText_ngay;
    Button button_chonngay, button_addBH;
    ListView listView;
    ArrayAdapter adapterSpinner, adapterListVIew;
    List<String> list, listViewDS;
    String str = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanly_album);
        anhxa();
        khoiTaoDS();
        adapterSpinner = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        spinner.setAdapter(adapterSpinner);
        adapterListVIew = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listViewDS);
        listView.setAdapter(adapterListVIew);
        button_chonngay.setOnClickListener(view -> {
            date();
        });
        button_addBH.setOnClickListener(view -> {
            addBH();
        });
    }

    private void anhxa() {
        textView_ngay = findViewById(R.id.textView_ngay);
        textView_tenBH = findViewById(R.id.textView_tenBaiHat);
        textView_title = findViewById(R.id.textView_Album);
        spinner = findViewById(R.id.spinner_album);
        editText_ngay = findViewById(R.id.edit_ngayRa);
        editText_ten = findViewById(R.id.edit_tenBH);
        button_addBH = findViewById(R.id.button_addBH);
        button_chonngay = findViewById(R.id.button_chonNgay);
        listView = findViewById(R.id.listView_BH);
    }

    private void khoiTaoDS() {

        list = new ArrayList<>();
        listViewDS = new ArrayList<>();
        for (Album a : QuanLiBaiHatActivity.listAlbum) {
            str = a.getMaAblum() + " - " + a.getTenAlbum();
            list.add(str);
        }
    }

    private void addBH() {
        str = "Tên bài hát: " + editText_ten.getText().toString() + " - Ngày ra: " + editText_ngay.getText().toString();
        listViewDS.add(str);
        adapterListVIew.notifyDataSetChanged();
        editText_ten.setText("");
        editText_ngay.setText("");


    }

    private void date() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(this, (datePicker, i, i1, i2) -> {
            calendar.set(i, i1, i2);
            editText_ngay.setText(new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }
}