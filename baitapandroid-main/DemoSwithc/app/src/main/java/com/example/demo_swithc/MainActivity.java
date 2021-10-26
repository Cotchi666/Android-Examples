package com.example.demo_swithc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   Switch sSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sSwitch = findViewById(R.id.switch1);
        sSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Toast.makeText(MainActivity.this, "wifi turn on", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "wifi turn off", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}