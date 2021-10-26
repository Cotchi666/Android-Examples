package com.example.mediaappmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView_ten, textView_00, textView_01;
    SeekBar seekBar_tg;
    ImageButton button_prv, button_play, button_pause, button_next;
    List<Song> list;
    int index = 0;
    MediaPlayer mediaPlayer;
    Animation animation;
    ImageView imageView_cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        addSong();
        khoiTaoMediaPlayer();
        button();
        seekBar_tg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        upDateTime();

    }

    private void anhxa() {
        textView_ten = findViewById(R.id.textView_tenbaihat);
        textView_00 = findViewById(R.id.textView_00);
        textView_01 = findViewById(R.id.textView_01);
        seekBar_tg = findViewById(R.id.seekBar_tg);
        button_prv = findViewById(R.id.imageButton_prev);
        button_play = findViewById(R.id.imageButton_play);
        button_pause = findViewById(R.id.imageButton_pause);
        button_next = findViewById(R.id.imageButton_next);
        imageView_cd = findViewById(R.id.imageView_cd);
        animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.test);

    }

    private void addSong() {
        list = new ArrayList<>();
        list.add(new Song("Cuoi thoi", R.raw.cuoi_thoi));
        list.add(new Song("Doc toc 2", R.raw.dotoc_2));
        list.add(new Song("Lailisa", R.raw.lisa));
        list.add(new Song("Thuc giac", R.raw.thucgiac));
        list.add(new Song("Yeu la cuoi", R.raw.yeu_la_cuoi));
    }

    private void khoiTaoMediaPlayer() {
        mediaPlayer = MediaPlayer.create(MainActivity.this, list.get(index).getFile());
        textView_ten.setText(list.get(index).getTenBaiHat());
        getTimeTotal();

    }

    private void button() {
        button_play.setOnClickListener(view -> {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                button_play.setImageResource(R.drawable.ic_pause);
                imageView_cd.setAnimation(animation);
            } else {
                mediaPlayer.pause();
                button_play.setImageResource(R.drawable.icon_play);
            }
        });
        button_pause.setOnClickListener(view -> {
            mediaPlayer.stop();
            mediaPlayer.release();
            button_play.setImageResource(R.drawable.icon_play);
            khoiTaoMediaPlayer();
        });
        button_prv.setOnClickListener(view -> {
            index--;
            if (index < 1) {
                index = list.size() - 1;
            }
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            khoiTaoMediaPlayer();
            mediaPlayer.start();
            button_play.setImageResource(R.drawable.ic_pause);
        });
        button_next.setOnClickListener(view -> {
            nextSong();
        });
    }

    private void nextSong() {
        index++;
        if (index > list.size() - 1) {
            index = 0;
        }
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        khoiTaoMediaPlayer();
        mediaPlayer.start();
        button_play.setImageResource(R.drawable.ic_pause);
    }

    private void getTimeTotal() {
        textView_01.setText(new SimpleDateFormat("mm:ss").format(mediaPlayer.getDuration()));
        seekBar_tg.setMax(mediaPlayer.getDuration());
    }

    private void upDateTime() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    textView_00.setText(new SimpleDateFormat("mm:ss").format(mediaPlayer.getCurrentPosition()));
                                    seekBar_tg.setProgress(mediaPlayer.getCurrentPosition());
                                    mediaPlayer.setOnCompletionListener(mediaPlayer1 -> {
                                        nextSong();
                                    });
                                    handler.postDelayed(this, 500);
                                }
                            }
                , 100);

    }
}