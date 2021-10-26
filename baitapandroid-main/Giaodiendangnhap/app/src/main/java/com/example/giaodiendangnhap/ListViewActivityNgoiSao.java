package com.example.giaodiendangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.DongListViewAdapter;
import entity.Dong_Listview;

public class ListViewActivityNgoiSao extends AppCompatActivity {

    ListView listView;
    TextView textView;
    DongListViewAdapter adapter;
    List<Dong_Listview> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_ngoi_sao);
        anhxa();
        khoiTaoGtri();
        adapter = new DongListViewAdapter(list,this,R.layout.dong_listview);
        if (adapter == null){
            System.out.println("loi");
        }
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((adapterView, view, i, l) ->
        {
            textView.setText("position: " + i + ", value: " + list.get(i).getTen());
        });

    }
    private void anhxa(){
        listView =(ListView) findViewById(R.id.List_VIEW);
        textView = findViewById(R.id.textView_hienthi);
    }
    private void khoiTaoGtri(){
        list = new ArrayList<>();
        list.add(new Dong_Listview("huong"));
        list.add(new Dong_Listview("cho"));
        list.add(new Dong_Listview("meo"));
        list.add(new Dong_Listview("ga"));
        list.add(new Dong_Listview("heo"));
        list.add(new Dong_Listview("chim"));
        list.add(new Dong_Listview("con trau"));
        list.add(new Dong_Listview("ngoi sao"));
        list.add(new Dong_Listview("tu"));
        list.add(new Dong_Listview("ca"));
        list.add(new Dong_Listview("con ca xau"));
    }
}