package com.example.gamechonanh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collections;

public class MainActivity2 extends Activity {

    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tableLayout = findViewById(R.id.table_layout);
        tableAnh();


    }

    private void tableAnh() {
        Collections.shuffle(MainActivity.list);
        for (int i = 1; i <= 4; i++) {
            // so dong
            TableRow tableRow = new TableRow(this);

            for (int j = 1; j <= 4; j++) {
                //so cot
                Resources r = getResources();
                int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, r.getDisplayMetrics()
                );
                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(new TableRow.LayoutParams(px, px));
                int index = 4 * (i - 1) + j - 1;
                //4*(4-1)+4-1
                // if (index < 16) {
                imageView.setImageResource(getResources().getIdentifier(MainActivity.list.get(index), "drawable", getPackageName()));
                //   }
                tableRow.addView(imageView);
                imageView.setOnClickListener(view -> {
                    setResult(RESULT_OK, new Intent().putExtra("anh", MainActivity.list.get(index)));
                    finish();
                });
            }
            tableLayout.addView(tableRow);
        }
    }
}