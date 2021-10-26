package com.example.context_menu;

import static com.example.context_menu.R.color.purple_700;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button chonmau;
    ConstraintLayout manhinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        registerForContextMenu(chonmau);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
        menu.setHeaderTitle("Chon mau");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_Vang:
                manhinh.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.menu_Do:
                manhinh.setBackgroundColor(Color.RED);
                break;
            case R.id.menu_Xanh:
                manhinh.setBackgroundColor(Color.GREEN);
                break;
        }

        return super.onContextItemSelected(item);
    }

    private void anhxa() {
        chonmau = findViewById(R.id.button_Menu);
        manhinh = findViewById(R.id.manhinh);
    }
}