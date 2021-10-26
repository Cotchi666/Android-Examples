package com.example.intentdataresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    final int CODE = 113;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button_main);
        textView = findViewById(R.id.text_noidung);
        button.setOnClickListener(view -> startActivityForResult(new Intent(this, EditActivity.class), CODE));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CODE && resultCode == RESULT_OK && data != null) {
            textView.setText(data.getStringExtra("tenMoi"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}