package com.example.baihocdautien;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        Button button = new Button(this);
        button.setText("click");
        relativeLayout.setBackgroundColor(Color.RED);
        relativeLayout.addView(button);
        setContentView(relativeLayout);
        Log.d("AAA","onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("AAA","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AAA","onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AAA","onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AAA","onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("AAA","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AAA","onResume");
    }

}