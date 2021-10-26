package com.example.giaodiendangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class SpinnerListViewActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    ListView listView;
    Spinner spinner;
    TextView textView;
    GridView gridView;
    List<String> listSpinner, listDienThoai, listMayTinh, listDongHo;
    ArrayAdapter adapter, adapterDienThoai, adapterAutoCompleteTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_list_view);
        anhxa();
        khoitaoDS();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listSpinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (listSpinner.get(i).equals("Dien thoai")) {
                    khoitaoAdapter(listDienThoai);
                } else if (listSpinner.get(i).equals("May tinh")) {
                    khoitaoAdapter(listMayTinh);
                } else {
                    khoitaoAdapter(listDongHo);
                }
                //  adapterDienThoai.notifyDataSetChanged();
                gridView.setAdapter(adapterDienThoai);
                autoCompleteTextView.setThreshold(1);
                autoCompleteTextView.setAdapter(adapterAutoCompleteTextView);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void anhxa() {
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView_spinner);
        gridView = findViewById(R.id.gridView_spinner);
        spinner = findViewById(R.id.spinner_listview);
        textView = findViewById(R.id.textView_spin);
    }

    private void khoitaoDS() {
        listSpinner = Arrays.asList("Dien thoai", "May tinh", "Dong ho");
        listDienThoai = Arrays.asList("iphone", "xiaomi", "samsung", "oppo", "nokia", "macos", "windows");
        listMayTinh = Arrays.asList("laptop", "asus", "dell", "php", "acer");
        listDongHo = Arrays.asList("casio", "tay", "ta", "co", "1", "2", "2");
    }

    private void khoitaoAdapter(List<String> list) {

        adapterDienThoai = new ArrayAdapter(SpinnerListViewActivity.this, android.R.layout.simple_list_item_1, list);
        adapterAutoCompleteTextView = new ArrayAdapter(SpinnerListViewActivity.this, android.R.layout.simple_list_item_1, list);
    }

}