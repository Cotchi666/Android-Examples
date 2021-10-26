package com.example.demngayxaemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textView, textView2;
    EditText ngay1, ngay2;
    Button xacNhan;
    Calendar calendar1, calendar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        ngay1.setOnClickListener(view -> {
            chonNgay1();
        });
        ngay2.setOnClickListener(view -> {
            chonNgay2();
        });
        xacNhan.setOnClickListener(view -> {
            int songay = (int) ((calendar2.getTimeInMillis() - calendar1.getTimeInMillis())/(1000*60*60*24));
            textView2.setText("So ngay xa em la: " + songay);
        });

    }

    private void anhXa() {
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        ngay1 = findViewById(R.id.ngay1);
        ngay2 = findViewById(R.id.ngay2);
        xacNhan = findViewById(R.id.xacnhan);
    }

    private void chonNgay1() {
        calendar1 = Calendar.getInstance();
        new DatePickerDialog(this, (datePicker, i, i1, i2) -> {
            calendar1.set(i, i1, i2);
            ngay1.setText(new SimpleDateFormat("dd/MM/yyyy").format(calendar1.getTime()));
        }, calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void chonNgay2() {
        calendar2 = Calendar.getInstance();
        new DatePickerDialog(this, (datePicker, i, i1, i2) -> {
            calendar2.set(i, i1, i2);
            ngay2.setText(new SimpleDateFormat("dd/MM/yyyy").format(calendar2.getTime()));
        }, calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH), calendar2.get(Calendar.DAY_OF_MONTH)).show();
    }
}