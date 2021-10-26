package com.example.progessbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.button2);

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new CountDownTimer(10000,1000){

                    @Override
                    public void onTick(long l) {
                        if (progressBar.getMax() <= progressBar.getProgress()) {
                            progressBar.setProgress(0);
                        } else {
                            progressBar.setProgress(progressBar.getProgress() + 10);

                        }
                    }

                    @Override
                    public void onFinish() {
                        this.start();
                        Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                    }
                }.start();

            }
        });
    }
}