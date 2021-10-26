package com.example.menukhoitao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu1) {
        getMenuInflater().inflate(R.menu.menu, menu1);
        return super.onCreateOptionsMenu(menu1);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuSetting:
                Toast.makeText(MainActivity.this, "Sting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSearch:
                Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuShare:
                Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuContact:
                Toast.makeText(MainActivity.this, "Contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuEmail:
                Toast.makeText(MainActivity.this, "Email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuPhone:
                Toast.makeText(MainActivity.this, "Phone", Toast.LENGTH_SHORT).show();
                break;
                
        }
        return super.onOptionsItemSelected(item);
    }
}