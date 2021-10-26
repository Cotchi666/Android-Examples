package com.example.animationapla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.button_2);
        button.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
            overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
        });
    }
}