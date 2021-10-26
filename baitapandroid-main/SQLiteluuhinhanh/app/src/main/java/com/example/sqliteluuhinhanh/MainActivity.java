package com.example.sqliteluuhinhanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button_add;
    public static Database database;
    ListView listView;
    public static List<DoVat> list;
    DoVatAdapter doVatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        listView.setAdapter(doVatAdapter);

        database = new Database(this, "ql.DoVat", null, 1);
        database.queryData("CREATE TABLE IF NOT EXISTS DoVat(Id INTEGER PRIMARY KEY AUTOINCREMENT,ten VARCHAR(150),moTa VARCHAR(250),hinhAnh BLOB)");

        layDoVatTrongDatabase();

        button_add.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ThemDoVatActivity.class));
        });
    }

    private void anhxa() {
        button_add = findViewById(R.id.button_add);
        list = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listview_cv);
        doVatAdapter = new DoVatAdapter(list, this, R.layout.dong_do_vat);


    }

    private void layDoVatTrongDatabase() {
        Cursor cursor = database.getData("SELECT * FROM DoVat");
        while (cursor.moveToNext()) {
            list.add(new DoVat(cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(0),
                    cursor.getBlob(3)));
        }
        doVatAdapter.notifyDataSetChanged();
    }
}