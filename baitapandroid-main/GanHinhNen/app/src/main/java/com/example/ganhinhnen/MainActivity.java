package com.example.ganhinhnen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List< Integer> list;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.manhinh);

        list = new ArrayList<>();
        list.add(R.drawable.hinhen);
        list.add(R.drawable.shaw);
        list.add(R.drawable.xi);
        list.add(R.drawable.sancho);
        list.add(R.drawable.pog2);



       relativeLayout.setBackgroundResource(list.get(new Random().nextInt(list.size())));
       // relativeLayout.setBackgroundResource(R.drawable.sancho1);


    }

}