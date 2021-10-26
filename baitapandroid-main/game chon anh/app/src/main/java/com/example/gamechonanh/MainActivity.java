package com.example.gamechonanh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ImageView imageView_tren, imageView_duoi;
    TextView textView, text_diem;
    final int CODE = 1111;
    final int CODE_A = 113;
    String tenHinh = "";
    public static List<String> list;
    int diem = 100;
    SharedPreferences luuDiemSo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setContentView(R.menu.menu_anh);
        anhxa();
        setImageView_tren();
        imageView_duoi.setOnClickListener(view -> {
            startActivityForResult(new Intent(this, MainActivity2.class), CODE);
        });

        diem = luuDiemSo.getInt("diem", 100);
        text_diem.setText("Diem: " + diem);

    }


    private void anhxa() {
        list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.list_anh)));
        luuDiemSo = getSharedPreferences("luudiemso", MODE_PRIVATE);
        imageView_duoi = findViewById(R.id.imageView_duoi);
        imageView_tren = findViewById(R.id.imageView_tren);
        textView = findViewById(R.id.textView);
        text_diem = findViewById(R.id.text_diem);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == CODE && resultCode == RESULT_OK && data != null) {
            imageView_duoi.setImageResource(getResources().getIdentifier(data.getStringExtra("anh"), "drawable", getPackageName()));
            soSanh(data.getStringExtra("anh"));
        } else {
            diem = data.getIntExtra("so", 100);
            text_diem.setText("Diem: " + diem);

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_anh, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.icon_doi) {
            setImageView_tren();
        }
        return super.onOptionsItemSelected(item);
    }

    private void soSanh(String tenHinhNhan) {

        if (tenHinh.equals(tenHinhNhan)) {
            Toast.makeText(MainActivity.this, "Chinh Xac Ban Nhan Duoc 20 diem", Toast.LENGTH_SHORT).show();
            diem += 20;
            luuDiem();
            new CountDownTimer(2000, 100) {

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    setImageView_tren();
                }
            }.start();

        } else {
            Toast.makeText(MainActivity.this, "Sai rui!! Ban bi tru 20 diem.", Toast.LENGTH_SHORT).show();
            diem -= 20;
            luuDiem();
            if (diem <= 0) {
                startActivityForResult(new Intent(this, ActivityDialogGameOver.class), CODE_A);
            }
        }
        text_diem.setText("Diem: " + diem);

    }

    private void setImageView_tren() {
        Collections.shuffle(list);
        tenHinh = list.get(5);
        imageView_tren.setImageResource(getResources().getIdentifier(list.get(5), "drawable", getPackageName()));
    }

    private void luuDiem() {
        SharedPreferences.Editor editor = luuDiemSo.edit();
        editor.putInt("diem", diem);
        editor.commit();
    }
}