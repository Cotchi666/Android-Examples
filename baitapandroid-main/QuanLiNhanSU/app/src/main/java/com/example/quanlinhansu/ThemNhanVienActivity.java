package com.example.quanlinhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import entity.Person;

public class ThemNhanVienActivity extends AppCompatActivity {

    EditText editText_ma, editText_ten;
    Button button_luu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhan_vien);
        anhxa();
        button_luu.setOnClickListener(view -> {
            result();
        });
    }

    private void anhxa() {
        editText_ma = findViewById(R.id.edit_id);
        editText_ten = findViewById(R.id.edit_ten);
        button_luu = findViewById(R.id.button_add);
    }

    private void result() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("person", new Person(editText_ten.getText().toString().trim(), Integer.parseInt(editText_ma.getText().toString().trim())));
        setResult(RESULT_OK, new Intent().putExtra("data", bundle));
        finish();

    }


}