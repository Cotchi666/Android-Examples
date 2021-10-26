package com.example.demolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<String> list;
    Button button1,button2,button3;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        listView = findViewById(R.id.lisview);
        list = new ArrayList<>();

        list.add("Java");
        list.add("C++");
        list.add("PHP");
        list.add("html");

        ArrayAdapter listAdapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1, list);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText.setText(list.get(i));
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        list.set(i,editText.getText().toString());
                        listAdapter.notifyDataSetChanged();
                    }
                });
            }
        });


        button1.setOnClickListener(view -> {
            list.add(editText.getText().toString());
            listAdapter.notifyDataSetChanged();
        });
        button2.setOnClickListener(view -> {
            list.remove(editText.getText().toString());
            listAdapter.notifyDataSetChanged();
        });

    }
    private void anhXa(){
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        editText = findViewById(R.id.editText);
    }
}