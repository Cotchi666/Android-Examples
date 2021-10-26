package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_tk, editText_mk;
    CheckBox checkBox_luu;
    Button button_login;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        editText_tk.setText(sharedPreferences.getString("tk", ""));
        editText_mk.setText(sharedPreferences.getString("mk", ""));
        checkBox_luu.setChecked(sharedPreferences.getBoolean("check_box", false));
        button_login.setOnClickListener(view -> {
            if (editText_tk.getText().toString().equals("admin") && editText_mk.getText().toString().equals("123")) {
                Toast.makeText(this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (checkBox_luu.isChecked()) {
                    editor.putString("tk", editText_tk.getText().toString());
                    editor.putString("mk", editText_mk.getText().toString());
                    editor.putBoolean("check_box", true);
                    editor.commit();
                } else {
//                    editor.remove("tk");
//                    editor.remove("mk");
//                    editor.remove("check_box");
                    editor.clear();
                    editor.commit();
                }
            } else {
                Toast.makeText(this, "Tai khoan hoac mat khau khong chinh xac", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void anhxa() {
        editText_tk = findViewById(R.id.edit_taikhoan);
        editText_mk = findViewById(R.id.edit_matkhau);
        checkBox_luu = findViewById(R.id.checkBox_luu);
        button_login = findViewById(R.id.button_login);
    }
}