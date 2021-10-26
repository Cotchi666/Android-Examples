package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.button2);
        button.setOnClickListener(view -> startActivity(new Intent(MainActivity2.this, MainActivity.class)));
//        for (String str : getIntent().getStringArrayExtra("dulieu")) {
//            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
//        }
//        HocSinh hocSinh = (HocSinh) getIntent().getSerializableExtra("dulieu");
//        Toast.makeText(this, hocSinh.getName() + " - " + hocSinh.getAge(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, getIntent().getBundleExtra("dulieu").getString("string") + "", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, getIntent().getBundleExtra("dulieu").getInt("int") + "", Toast.LENGTH_SHORT).show();
        HocSinh hocSinh = (HocSinh) getIntent().getBundleExtra("dulieu").getSerializable("hocsinh");
        Toast.makeText(this, hocSinh.getName() + " - " + hocSinh.getAge(), Toast.LENGTH_SHORT).show();
        for (String str : getIntent().getBundleExtra("dulieu").getStringArray("mang")) {
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }


    }
}