package com.example.intentdataresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        button = findViewById(R.id.button_edit);
        editText = findViewById(R.id.edittext);
        button.setOnClickListener(view -> {
            String tenmoi = editText.getText().toString();
            setResult(RESULT_OK,new Intent().putExtra("tenMoi",tenmoi));
            finish();
        });
    }
}