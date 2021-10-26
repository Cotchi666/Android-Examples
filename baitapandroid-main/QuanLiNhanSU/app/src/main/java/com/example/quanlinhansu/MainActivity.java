package com.example.quanlinhansu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import entity.Person;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter adapter;
    ListView listView;
    List<Person> list;
    int number = 0;
    public static final int CODE_ADD = 1111;
    final int CODE_UPDATE = 1121;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, ParseXMLActivity.class));
        listView = findViewById(R.id.listView_DS);
        khoiTaoDS();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            number = i;
            return false;
        });
        registerForContextMenu(listView);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_ds, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addNew:
                startActivityForResult(new Intent(this, LoadvaXoaCacheActivity.class), CODE_ADD);
                break;
            case R.id.updtae:
                update();
                break;
            case R.id.removed:
                remove();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE_ADD && resultCode == RESULT_OK && data != null) {
            list.add((Person) data.getBundleExtra("data").getSerializable("person"));
        }
        if (requestCode == CODE_UPDATE && resultCode == RESULT_OK && data != null) {
            list.set(number, (Person) data.getBundleExtra("data").getSerializable("person"));
        }
    }
    /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ds,menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    private void khoiTaoDS() {
        list = new ArrayList<>();
        list.add(new Person("Tý", 1));
        list.add(new Person("Tèo", 2));
    }

    private void remove() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo!");
        builder.setMessage("Chắc chắn bạn muốn xóa???");
        builder.setNegativeButton("Không", (dialogInterface, i) -> {
        });
        builder.setPositiveButton("Có", (dialogInterface, i) -> {
            list.remove(number);
            adapter.notifyDataSetChanged();
        });
        builder.show();
    }

    private void update() {
        Intent intent = new Intent(this, UpdateNhanVienActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("person", new Person(list.get(number).getName(), list.get(number).getId()));
        intent.putExtra("data", bundle);
        startActivityForResult(intent, CODE_UPDATE);
    }
}