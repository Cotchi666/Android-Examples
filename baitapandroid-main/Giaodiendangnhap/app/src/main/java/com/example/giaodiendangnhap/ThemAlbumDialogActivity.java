package com.example.giaodiendangnhap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.DialogCompat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThemAlbumDialogActivity extends AppCompatActivity {

    TextView textView_tittle, textView_maAlbum, textView_tenAblum;
    EditText editText_maAlbum, editText_tenAlbum;
    Button button_xoa, button_luu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_them_album_dialog);

        anhxa();
        button_luu.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("maAlbum", editText_maAlbum.getText().toString());
            bundle.putString("tenAlbum", editText_tenAlbum.getText().toString());
            setResult(RESULT_OK, new Intent().putExtra("data", bundle));
            finish();
        });
        button_xoa.setOnClickListener(view -> {
            editText_maAlbum.setText("");
            editText_tenAlbum.setText("");
        });
    }


    protected void anhxa() {
        textView_tittle = findViewById(R.id.textView_titleTemAlbum);
        textView_maAlbum = findViewById(R.id.textView_maAlbum);
        editText_tenAlbum = findViewById(R.id.edit_tenAlbum);
        textView_tenAblum = findViewById(R.id.textView_tenAlbum);
        editText_maAlbum = findViewById(R.id.edit_maAlbum);
        button_luu = findViewById(R.id.button_LuuAlbum);
        button_xoa = findViewById(R.id.button_xoaTrang);
    }
}