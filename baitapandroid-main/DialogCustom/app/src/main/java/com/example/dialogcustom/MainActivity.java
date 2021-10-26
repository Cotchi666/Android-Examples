package com.example.dialogcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_click = findViewById(R.id.textView_click);
        txt_click.setOnClickListener(view -> {
            dialogLogin();
        });
    }

    private void dialogLogin() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dangnhap);
        dialog.setCanceledOnTouchOutside(false);
        final EditText user_name = dialog.findViewById(R.id.edit_taikhoan);
        EditText password = dialog.findViewById(R.id.edit_matkhau);
        Button button_dongy = dialog.findViewById(R.id.button_dongY);
        Button button_huy = dialog.findViewById(R.id.button_Huy);
        button_dongy.setOnClickListener(view -> {
            if (user_name.getText().toString().equals("admin") && password.getText().toString().equals("123")) {
                Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Tai khoan hoac mat khau khong chinh xac", Toast.LENGTH_SHORT).show();
            }
        });
        button_huy.setOnClickListener(view -> dialog.cancel());
        dialog.show();
    }
}