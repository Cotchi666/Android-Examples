package com.example.menupopup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        button.setOnClickListener(view -> {
            showMenu();
        });
    }


    private void anhXa() {
        button = findViewById(R.id.button_Menu);
    }

    private void showMenu() {
        PopupMenu popupMenu = new PopupMenu(this, button);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.menu_Them:
                    button.setText("menu them");
                    break;
                case R.id.menu_Sua:
                    button.setText("menu sua");
                    break;
                case R.id.menu_Xoa:
                    button.setText("menu xoa");
                    break;
            }
            return false;
        });
        popupMenu.show();


    }
}