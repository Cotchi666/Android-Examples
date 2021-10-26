package com.example.giaodiendangnhap;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListViewNhapActivity extends AppCompatActivity {
    TextView textView_nhap, textView_ketqua;
    EditText editText_nhap;
    Button button_nhap;
    ListView listView;
    List<String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_nhap);
        anhxa();
        list = new ArrayList<>();
        listView.setAdapter(adapter);
        nhannut();
        clickItem();
    }

    private void anhxa() {
        textView_ketqua = findViewById(R.id.textView_ketqua);
        textView_nhap = findViewById(R.id.textView_nhap);
        editText_nhap = findViewById(R.id.edit_nhap);
        button_nhap = findViewById(R.id.button_nhap);
        listView = findViewById(R.id.listView_ketqua);
    }

    private void nhannut() {
        button_nhap.setOnClickListener(view -> {
            list.add(editText_nhap.getText().toString().trim());
            editText_nhap.setText("");
            adapter.notifyDataSetChanged();
        });
    }

    private void clickItem() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView_ketqua.setText("position: " + i + ", value = " + list.get(i));
            }
        });
    }
}
