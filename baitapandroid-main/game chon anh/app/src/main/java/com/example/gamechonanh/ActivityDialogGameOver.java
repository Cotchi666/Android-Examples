package com.example.gamechonanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ActivityDialogGameOver extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog_game_over);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView2);
        button.setOnClickListener(view -> {
            setResult(RESULT_OK, new Intent().putExtra("so", 100));
            finish();
        });


    }
}