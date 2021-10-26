package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button button_load;
    ImageView imageView_load;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_load = findViewById(R.id.button_load);
        imageView_load = findViewById(R.id.imageView_load);


        button_load.setOnClickListener(view ->
                new LoadAnh().execute("https://thegioibantin.com/wp-content/uploads/2020/11/Android-main.jpg")
        );


    }

    private class LoadAnh extends AsyncTask<String, Void, Bitmap> {
        Bitmap bitmap = null;

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap != null)
                imageView_load.setImageBitmap(bitmap);
        }
    }
}