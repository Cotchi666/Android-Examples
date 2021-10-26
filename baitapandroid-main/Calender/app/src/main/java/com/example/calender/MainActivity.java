package com.example.calender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        Calendar calendar = Calendar.getInstance();
        textView.append(calendar.getTime() + "\n");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
        textView.append(simpleDateFormat.format(calendar.getTime()) + "\n");
        textView.append(calendar.get(Calendar.HOUR) + "\n");
        textView.append(calendar.get(Calendar.HOUR_OF_DAY) + "\n");
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        textView.append(simpleDateFormat.format(calendar.getTime()) + "");
    }
}