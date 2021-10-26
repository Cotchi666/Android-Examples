package com.example.giaodiendangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ConvertYearActivity extends AppCompatActivity {

    TextView textView_title, textView_duong, textView_am;
    EditText editText_duong, editText_am;
    Button button_convert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_year);
        anhxa();
        button_convert.setOnClickListener(view -> {
            int i = Integer.parseInt(editText_duong.getText().toString().trim());
            if (i < 1900){
                Toast.makeText(ConvertYearActivity.this, "Please enter a number greater than 1900!!!", Toast.LENGTH_SHORT).show();
            }else {
                editText_am.setText(convertDuongAm(i));
            }
        });
    }

    private void anhxa() {
        textView_am = findViewById(R.id.textView_am);
        textView_title = findViewById(R.id.textView_titleCovert);
        textView_duong = findViewById(R.id.textView_duong);
        editText_am = findViewById(R.id.edit_am);
        editText_duong = findViewById(R.id.edittext_duong);
        button_convert = findViewById(R.id.button_convert);

    }

    private String convertDuongAm(int i) {
        String can = "";
        String chi = "";
        switch (i % 10) {
            case 0:
                can = "Canh";
                break;
            case 1:
                can = "Tan";
                break;
            case 2:
                can = "Nham";
                break;
            case 3:
                can = "Quy";
                break;
            case 4:
                can = "Giap";
                break;
            case 5:
                can = "At";
                break;
            case 6:
                can = "Binh";
                break;
            case 7:
                can = "Dinh";
                break;
            case 8:
                can = "Mau";
                break;
            case 9:
                can = "Ky";
                break;
        }
        switch (i % 12) {
            case 0:
                chi = "Than";
                break;
            case 1:
                chi = "Dau";
                break;
            case 2:
                chi = "Tuat";
                break;
            case 3:
                chi = "Hoi";
                break;
            case 4:
                chi = "Ty";
                break;
            case 5:
                chi = "Suu";
                break;
            case 6:
                chi = "Dan";
                break;
            case 7:
                chi = "Meo";
                break;
            case 8:
                chi = "Thin";
                break;
            case 9:
                chi = "Ty";
                break;
            case 10:
                chi = "Ngo";
                break;
            case 11:
                chi = "Mui";
                break;
        }

        return can + " " + chi;
    }
}