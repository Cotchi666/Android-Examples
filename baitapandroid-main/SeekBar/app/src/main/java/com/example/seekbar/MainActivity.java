package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox1, checkBox2, checkBox3;
    SeekBar seekBar1, seekBar2, seekBar3;
    ImageButton buttonClick;
    CountDownTimer countDownTimer;
    TextView textView;
    int soDiem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        clickButton();

    }

    private void anhxa() {
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        seekBar1 = findViewById(R.id.seekBar1);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar3 = findViewById(R.id.seekBar3);
        textView = findViewById(R.id.textView);
        buttonClick = findViewById(R.id.imageButtonPlay);
        seekBar1.setEnabled(false);
        seekBar2.setEnabled(false);
        seekBar3.setEnabled(false);
        countDownTimer = new CountDownTimer(60000, 300) {

            @Override
            public void onTick(long l) {
                check();
                Random random = new Random();
                int number1 = random.nextInt(10);
                int number2 = random.nextInt(10);
                int number3 = random.nextInt(10);
                seekBar1.setProgress(seekBar1.getProgress() + number1);
                seekBar2.setProgress(seekBar2.getProgress() + number2);
                seekBar3.setProgress(seekBar3.getProgress() + number3);
            }

            @Override
            public void onFinish() {

            }
        };
    }

    private void clickButton() {
        buttonClick.setOnClickListener(view -> {
            if (!clickCheckBox()) {
                Toast.makeText(MainActivity.this, "Vui long chon nguoi chien thang!!!", Toast.LENGTH_SHORT).show();
            } else {
                seekBar1.setProgress(0);
                seekBar2.setProgress(0);
                seekBar3.setProgress(0);
                buttonClick.setVisibility(View.INVISIBLE);
                countDownTimer.start();
                disEnableCheckBox();

            }
        });
    }

    private void check() {
        if (seekBar1.getProgress() >= seekBar1.getMax()) {
            countDownTimer.cancel();
            Toast.makeText(MainActivity.this, "One win", Toast.LENGTH_SHORT).show();

            if (checkBox1.isChecked()) {
                soDiem += 100;
                Toast.makeText(MainActivity.this, "Ban nhan duoc 100 diem", Toast.LENGTH_SHORT).show();

            }
            buttonClick.setVisibility(View.VISIBLE);
            enableCheckBox();
        }
        if (seekBar2.getProgress() >= seekBar2.getMax()) {
            countDownTimer.cancel();
            Toast.makeText(MainActivity.this, "Two win", Toast.LENGTH_SHORT).show();

            if (checkBox2.isChecked()) {
                soDiem += 100;
                Toast.makeText(MainActivity.this, "Ban nhan duoc 100 diem", Toast.LENGTH_SHORT).show();

            }
            buttonClick.setVisibility(View.VISIBLE);
            enableCheckBox();
        }
        if (seekBar3.getProgress() >= seekBar3.getMax()) {
            countDownTimer.cancel();
            Toast.makeText(MainActivity.this, "Three win", Toast.LENGTH_SHORT).show();

            if (checkBox3.isChecked()) {
                soDiem += 100;
                Toast.makeText(MainActivity.this, "Ban nhan duoc 100 diem", Toast.LENGTH_SHORT).show();

            }
            buttonClick.setVisibility(View.VISIBLE);
            enableCheckBox();
        }
        textView.setText(soDiem + "");


    }

    private boolean clickCheckBox() {
        checkBox1.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
            }
        });
        checkBox2.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                checkBox1.setChecked(false);
                checkBox3.setChecked(false);
            }
        });
        checkBox3.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                checkBox2.setChecked(false);
                checkBox1.setChecked(false);

            }
        });
        return checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked();
    }

    private void enableCheckBox() {
        checkBox1.setEnabled(true);
        checkBox2.setEnabled(true);
        checkBox3.setEnabled(true);
    }

    private void disEnableCheckBox() {
        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);
    }
}