package com.example.intentcamera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    final int CODE = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView_anh);
        button = findViewById(R.id.button_anh);

        button.setOnClickListener(view -> {
            startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CODE && resultCode == RESULT_OK && data != null) {
            imageView.setImageBitmap((Bitmap) data.getExtras().get("data"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}