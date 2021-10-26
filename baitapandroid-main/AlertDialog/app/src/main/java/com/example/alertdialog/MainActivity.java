package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> danhsach;
    ArrayAdapter arrayAdapter;
    ListView listManHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        listManHinh.setAdapter(arrayAdapter);
        listManHinh.setOnItemClickListener((adapterView, view, i, l) -> {
            xacNhanXoa(i);

        });


    }
    private  void xacNhanXoa(final int index){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Thong bao!!!");
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
        alertDialogBuilder.setMessage("Ban chac chan muon xoa");
        alertDialogBuilder.setPositiveButton("Khong", (dialogInterface, i) -> {


        });
        alertDialogBuilder.setNegativeButton("Co", (dialogInterface, i) -> {
            danhsach.remove(index);
            arrayAdapter.notifyDataSetChanged();
        });

        alertDialogBuilder.show();
    }
    private void anhxa(){
        danhsach  = new ArrayList<>();
        listManHinh = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,danhsach);
        danhsach.add("Java");
        danhsach.add("C++");
        danhsach.add("C");
        danhsach.add("C#");
        danhsach.add("PHP");
        danhsach.add("Python");
        danhsach.add("HTML");
        danhsach.add("JS");

    }
}