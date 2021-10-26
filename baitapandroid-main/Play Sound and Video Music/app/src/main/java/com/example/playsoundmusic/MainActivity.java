package com.example.playsoundmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button button, btn4;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        button.setOnClickListener(view -> {
            MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.dotoc_2);
            mediaPlayer.start();
        });
        btn4.setOnClickListener(view -> {
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.dotoc2_mp4));
            videoView.start();
        });


    }

    private void anhxa() {
        button = findViewById(R.id.button_play);
        btn4 = findViewById(R.id.button_mp4);
        videoView = findViewById(R.id.videoView_mp4);

    }
}