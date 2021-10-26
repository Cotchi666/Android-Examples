package com.example.apptoancau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView, textView2;
    Button button;
    EditText editText1, editText2, editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        button.setOnClickListener(view -> {
            String hello = getResources().getString(R.string.text_chaoban);
            String phone = getResources().getString(R.string.text_Phone);
            textView2.setText(hello + editText1.getText().toString() + "\nemail: " + editText2.getText().toString() + "\n" + phone + editText3.getText().toString());
        });
    }

    private void anhXa() {
        textView = findViewById(R.id.textview);
        textView2 = findViewById(R.id.textView2);
        editText1 = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.editTextTextPersonName2);
        editText3 = findViewById(R.id.editTextTextPersonName3);
        button = findViewById(R.id.button);
    }
}