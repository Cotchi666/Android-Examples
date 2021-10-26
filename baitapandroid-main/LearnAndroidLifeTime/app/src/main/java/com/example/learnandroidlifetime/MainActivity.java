package com.example.learnandroidlifetime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button_C, button_F, button_clear;
    EditText editText_C, editText_F;
    TextView textView_C, textView_F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        s
//        button1.setOnClickListener(view ->startActivity(new Intent(this,SubActivity1.class)) );
        //  button2.setOnClickListener(view -> startActivity(new Intent(this,SubActivity2.class)));

        anhxa();

        button_F.setOnClickListener(view -> {
            double C = Double.parseDouble(editText_C.getText().toString().trim());
            editText_F.setText((1.8 * C) + 32 + "");
        });
        button_C.setOnClickListener(view -> {
            double F = Double.parseDouble(editText_F.getText().toString().trim());
            editText_C.setText(((F - 32) / 1.8) + "");
        });
        button_clear.setOnClickListener(view -> {
            editText_F.setText("");
            editText_C.setText("");
        });
    }


    private void anhxa() {
        button_C = findViewById(R.id.button_C);
        button_clear = findViewById(R.id.button_clear);
        button_F = findViewById(R.id.button_F);
        editText_C = findViewById(R.id.edit_C);
        editText_F = findViewById(R.id.edit_F);
        textView_C = findViewById(R.id.textView_C);
        textView_F = findViewById(R.id.textView_F);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }
}