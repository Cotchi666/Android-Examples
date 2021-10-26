package com.example.quanlinhansu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import entity.Person;

public class UpdateNhanVienActivity extends AppCompatActivity {
    EditText editText_ma, editText_ten;
    Button button_luu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_nhan_vien);
        anhxa();
        Person person = (Person) getIntent().getBundleExtra("data").getSerializable("person");
        editText_ma.setText(person.getId() + "");
        editText_ten.setText(person.getName());
        button_luu.setOnClickListener(view -> {
            result();
        });
    }


    private void result() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("person", new Person(editText_ten.getText().toString().trim(), Integer.parseInt(editText_ma.getText().toString().trim())));
        setResult(RESULT_OK, new Intent().putExtra("data", bundle));
        finish();

    }


    private void anhxa() {
        editText_ma = findViewById(R.id.edit_idUpdate);
        editText_ten = findViewById(R.id.edit_tenUpdate);
        button_luu = findViewById(R.id.button_add_Update);
    }
}