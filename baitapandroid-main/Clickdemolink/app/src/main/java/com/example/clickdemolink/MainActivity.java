package com.example.clickdemolink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView chorme, mess, call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chorme = findViewById(R.id.imageView);
        mess = findViewById(R.id.icon_mes);
        call = findViewById(R.id.icon_call);

        chorme.setOnClickListener(view -> startActivity(new Intent().setData(Uri.parse("https://www.youtube.com/watch?v=c0C8-s1K0qg&list=PL5uqQAwS_KDjAgLGiaCakwJV1f4vRnTLS&index=82"))));
        mess.setOnClickListener(view -> startActivity(new Intent().putExtra("sms_body", "Hello...").setData(Uri.parse("sms: 0868905021"))));
        call.setOnClickListener(view -> startActivity(new Intent().setAction(Intent.ACTION_CALL).setData(Uri.parse("tel:0868905021"))));

    }
}