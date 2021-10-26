package com.example.giaodiendangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class PhongToAnhActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_to_anh);
        imageView = findViewById(R.id.imageView_thongtin);
        button= findViewById(R.id.button_quaylai);
        imageView.setImageResource( getIntent().getIntExtra("a",R.drawable.drm1));
        button.setOnClickListener(view -> {
            finish();
        });


    }
}