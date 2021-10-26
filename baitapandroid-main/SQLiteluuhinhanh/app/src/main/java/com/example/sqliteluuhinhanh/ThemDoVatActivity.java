package com.example.sqliteluuhinhanh;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ThemDoVatActivity extends AppCompatActivity {

    ImageButton button_camera, button_folder;
    ImageView imageView_anh;
    TextView textView_title;
    EditText editText_ten, editText_mota;
    final int CODE_CAMERA = 111;
    final int CODE_FOLDER = 112;
    Button button_Add, button_Huy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_do_vat);
        anhxa();
        button_camera.setOnClickListener(view -> {
           /* Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CODE_CAMERA);*/
            ActivityCompat.requestPermissions(ThemDoVatActivity.this, new String[]{
                    Manifest.permission.CAMERA}, CODE_CAMERA);
        });
        button_folder.setOnClickListener(view -> {
            //startActivityForResult(new Intent(Intent.ACTION_PICK).setType("image/*"), CODE_FOLDER);
            ActivityCompat.requestPermissions(ThemDoVatActivity.this, new String[]{
                    Manifest.permission.CAMERA
            }, CODE_FOLDER);

        });
        button_Add.setOnClickListener(view -> {
            MainActivity.database.insert_dovat(editText_ten.getText().toString().trim(),
                    editText_mota.getText().toString().trim(), chuyeDoiHinhAnh());
            Toast.makeText(ThemDoVatActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ThemDoVatActivity.this, MainActivity.class));
            MainActivity.list.add(new DoVat("a", "b", 0, null));
        });

        button_Huy.setOnClickListener(view -> {
            startActivity(new Intent(ThemDoVatActivity.this, MainActivity.class));
        });
    }

    //chuyen data imageview sang byte[]
    private byte[] chuyeDoiHinhAnh() {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView_anh.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CODE_CAMERA && resultCode == RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView_anh.setImageBitmap(bitmap);
        }
        if (requestCode == CODE_FOLDER && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView_anh.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void anhxa() {
        button_camera = findViewById(R.id.imageButton_camera);
        button_folder = findViewById(R.id.imageButton_folder);
        imageView_anh = findViewById(R.id.imageView_anh);
        textView_title = findViewById(R.id.textView_tittle);
        editText_ten = findViewById(R.id.edit_ten);
        editText_mota = findViewById(R.id.edit_mota);
        button_Add = findViewById(R.id.button_adddv);
        button_Huy = findViewById(R.id.button_huy);
    }
}