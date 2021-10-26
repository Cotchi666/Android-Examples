package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    String[] mang = {"java", "C++", "JS", "C#", "Html", "PHP"};
    Bundle bundle = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);

        bundle.putStringArray("mang", mang);
        bundle.putString("string", "Huong dep trai");
        bundle.putInt("int", 2001);
        bundle.putSerializable("hocsinh", new HocSinh("huong", 2001));
        button.setOnClickListener(view -> startActivity(

                new Intent(MainActivity.this, MainActivity2.class).
                        putExtra("dulieu", bundle)));

    }
}