package com.example.vebuttonvertical;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout1, linearLayout2;
    ScrollView scrollView1;
    Button button;
    EditText editText;
    AtomicBoolean atomicBoolean;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        handlder();
        button.setOnClickListener(view -> {
            doStart();
        });


    }

    private void anhxa() {
        linearLayout1 = findViewById(R.id.linnerLayout);
        linearLayout2 = findViewById(R.id.liner_layout2);
        scrollView1 = findViewById(R.id.scrollView);
        button = findViewById(R.id.button_1);
        editText = findViewById(R.id.edit1);
    }

    private void doStart() {
        linearLayout2.removeAllViews();
        atomicBoolean = new AtomicBoolean(false);
        final int index = Integer.parseInt(editText.getText().toString().trim());
        Thread thread = new Thread(() -> {
            for (int i = 0; i < index && atomicBoolean.get(); i++) {

                SystemClock.sleep(200);
                Message message = handler.obtainMessage();

                message.arg1 = i;
                handler.sendMessage(message);
            }
        });
        atomicBoolean.set(true);
        thread.start();
    }

    private void handlder() {
        Random rd = new Random();
        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                View view ;
                int i = rd.nextInt(100);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                if (msg.arg1 % 2 == 0) {
                    view = new Button(MainActivity.this);
                    ((Button) view).setText(i + "");
                } else {
                    view = new EditText(MainActivity.this);
                    ((EditText) view).setText(i + "");
                }
                view.setLayoutParams(layoutParams);
                linearLayout2.addView(view);
            }
        };
    }
}