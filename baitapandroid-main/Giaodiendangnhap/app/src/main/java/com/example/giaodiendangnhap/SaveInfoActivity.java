package com.example.giaodiendangnhap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SaveInfoActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView textView_title, textView_degree, textView_inter, textView_addInfo, textView_fullname, textView_CMND;
    EditText editText_fullname, editText_cmnd, editText_addInfo;
    Button button_sendInfo;
    CheckBox checkBox_paper, checkBox_book, checkBox_coding;
    RadioButton radioButton_Uni, radioButton_coll, radioButton_inter;
    String info = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savae_info_layout);
        anhxa();
        button_sendInfo.setOnClickListener(view -> {

            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Infomation personal");
            if (!xuly().equals("error")) {
                dialog.setMessage(xuly());
                dialog.show();
            }


        });
    }

    private void anhxa() {
        textView_addInfo = findViewById(R.id.textView_addInfo);
        textView_CMND = findViewById(R.id.textView_CMND);
        textView_degree = findViewById(R.id.textView_degree);
        textView_title = findViewById(R.id.textView_title_saveInfo);
        textView_inter = findViewById(R.id.textView_interes);
        textView_fullname = findViewById(R.id.textView_fullname);
        editText_addInfo = findViewById(R.id.edit_info);
        editText_cmnd = findViewById(R.id.edit_cmnd);
        editText_fullname = findViewById(R.id.edit_fullname);
        button_sendInfo = findViewById(R.id.button_senInfo);
        checkBox_coding = findViewById(R.id.checkBox_code);
        checkBox_paper = findViewById(R.id.checkBox_par);
        checkBox_book = findViewById(R.id.checkBox_book);
        radioButton_coll = findViewById(R.id.radioButton_coll);
        radioButton_inter = findViewById(R.id.radioButton_inter);
        radioButton_Uni = findViewById(R.id.radioButton_uni);
        radioGroup = findViewById(R.id.radio_group);

    }

    private String xuly() {
        info = "";
        String str = editText_fullname.getText().toString().trim();
        if (str.length() < 3 || str.equals("")) {
            Toast.makeText(this, "Không được để trống và có ít nhất 3 ký tự.", Toast.LENGTH_SHORT).show();
            return "error";
        } else {
            info += "Full name: " + str + "\n";
        }
        str = editText_cmnd.getText().toString().trim();
        if (str.length() == 9) {
            info += "CMND: " + str + "\n";

        } else {

            Toast.makeText(this, "CMND chi co 9 chu so", Toast.LENGTH_SHORT).show();
            return "error";
        }
        if (radioButton_Uni.isChecked()) {
            info += "Degree: University" + "\n";
        } else if (radioButton_inter.isChecked()) {
            info += "Degree: Intermediate" + "\n";
        } else {
            info += "Degree: College" + "\n";
        }
        if (!checkBox().equals("Interest: ")) {
            info += checkBox()+ "\n";
        } else {
            Toast.makeText(this, "You must chose interest", Toast.LENGTH_SHORT).show();
            return "error";
        }
        info += "Info add: " + editText_addInfo.getText().toString().trim();
        return info;
    }

    String checkBox() {
        String checkbox = "Interest: ";
        if (checkBox_book.isChecked()) {
            checkbox += "Read book, ";
        }
        if (checkBox_paper.isChecked()) {
            checkbox += "Read paper, ";
        }
        if (checkBox_coding.isChecked()) {
            checkbox += "Read coding, ";
        }
        return checkbox ;
    }

}