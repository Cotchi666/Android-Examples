package com.example.giaodiendangnhap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class QuanLiCongViecActivity extends AppCompatActivity {

    TextView textView_title, textView_cv, textView_nd, textView_ngayHT, textView_ngay, textView_gioHT, textView_Gio,
            textView_DS;
    EditText editText_cv, editText_nd;
    Button button_DATE, button_Time, button_addCV;
    ListView listView_cv;
    Calendar calendar;
    String congviec = "";
    Dialog dialog;
    ArrayAdapter adapter;
    List<String> list;
    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_cong_viec);
        anhxa();
        list = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        calendar = Calendar.getInstance();
        button_DATE.setOnClickListener(view -> {
            date();
        });
        button_Time.setOnClickListener(view -> {
            time();
        });
        button_addCV.setOnClickListener(view -> {
            add();
            adapter.notifyDataSetChanged();

        });

        listView_cv.setAdapter(adapter);
        listView_cv.setOnItemClickListener((adapterView, view, i, l) -> {
            number = i;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_select, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.count:
                Toast.makeText(this, "Số lượng công việc là: " + list.size(), Toast.LENGTH_LONG).show();
                break;
            case R.id.xoa:
                list.remove(number);
                Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
                break;
            case R.id.sua:
                congviec = "Cong viec: " + editText_cv.getText().toString() + " - Noi dung: " + editText_nd.getText().toString() + " - Date: " + textView_ngay.getText().toString() + " - Time: " + textView_Gio.getText().toString();
                list.set(number, congviec);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private void anhxa() {
        textView_cv = findViewById(R.id.textView_congviec);
        textView_title = findViewById(R.id.textView_titleQL);
        textView_nd = findViewById(R.id.textView_noidung);
        textView_ngay = findViewById(R.id.textView_ngay);
        textView_ngayHT = findViewById(R.id.textView_ngayHT);
        textView_gioHT = findViewById(R.id.textView_gioHT);
        textView_Gio = findViewById(R.id.textView_gio);
        textView_DS = findViewById(R.id.textView_gio);
        editText_cv = findViewById(R.id.edit_congviec);
        editText_nd = findViewById(R.id.edit_noidung);
        button_addCV = findViewById(R.id.button_themcv);
        button_DATE = findViewById(R.id.button_Date);
        button_Time = findViewById(R.id.button_time);
        listView_cv = findViewById(R.id.list_view_QLCV);
    }

    private void add() {
        congviec = "Cong viec: " + editText_cv.getText().toString() + " - Noi dung: " + editText_nd.getText().toString() + " - Date: " + textView_ngay.getText().toString() + " - Time: " + textView_Gio.getText().toString();
        if (!editText_cv.getText().toString().trim().equals("") && !editText_nd.getText().toString().trim().equals("") && !textView_ngay.getText().toString().equals("") && !textView_Gio.getText().toString().equals("")) {
            list.add(congviec);
            editText_nd.setText("");
            editText_cv.setText("");
            textView_Gio.setText("");
            textView_ngay.setText("");
        }

    }

    private void date() {

        dialog = new DatePickerDialog(this, (datePicker, i, i1, i2) -> {
            calendar.set(i, i1, i2);
            textView_ngay.setText(new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    private void time() {
        dialog = new TimePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar, (timePicker, i, i1) -> {
            calendar.set(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, i, i1);
            textView_Gio.setText(new SimpleDateFormat("HH:mm").format(calendar.getTime()));
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        dialog.show();
    }

}