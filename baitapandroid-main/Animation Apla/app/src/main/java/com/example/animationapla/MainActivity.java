package com.example.animationapla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView, imageView_2, imageView_3, imageView_4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        imageView_2 = findViewById(R.id.imageView2);
        imageView_3 = findViewById(R.id.imageView3);
        imageView_4 = findViewById(R.id.imageView4);
        button = findViewById(R.id.button2);
        final Animation animation_rotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_apla);
        final Animation animation_scale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        final Animation animation_tranplate = AnimationUtils.loadAnimation(this, R.anim.anim_tranplate);
        imageView.setOnClickListener(view -> view.startAnimation(animation));
        imageView_2.setOnClickListener(view -> view.startAnimation(animation_rotate));
        imageView_3.setOnClickListener(view -> view.startAnimation(animation_scale));
        imageView_4.setOnClickListener(view -> view.startAnimation(animation_tranplate));
        button.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
            overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
        });
    }
}