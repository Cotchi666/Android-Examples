package com.example.maytinhbotuimini;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText editText_title;
    Button button_0, button_1, button_2, button_3, button_4,
            button_5, button_6, button_7, button_8, button_9,
            button_cong, button_tru, button_nhan, button_chia, button_phay,
            button_delete, button_bang;
    String str = "";
    double number1 = 0;
    String[] dau = new String[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        button_delete.setOnClickListener(view -> {
            str = "";
            number1 = 0;
            editText_title.setText(str);
        });
        button_0.setOnClickListener(view -> {
            str += "0";
            editText_title.setText(str);

        });
        button_1.setOnClickListener(view -> {
            str += "1";
            editText_title.setText(str);

        });
        button_2.setOnClickListener(view -> {
            str += "2";
            editText_title.setText(str);

        });
        button_3.setOnClickListener(view -> {
            str += "3";
            editText_title.setText(str);

        });
        button_4.setOnClickListener(view -> {
            str += "4";
            editText_title.setText(str);

        });
        button_5.setOnClickListener(view -> {
            str += "5";
            editText_title.setText(str);

        });
        button_6.setOnClickListener(view -> {
            str += "6";
            editText_title.setText(str);

        });
        button_7.setOnClickListener(view -> {
            str += "7";
            editText_title.setText(str);

        });
        button_8.setOnClickListener(view -> {
            str += "8";
            editText_title.setText(str);

        });
        button_9.setOnClickListener(view -> {
            str += "9";
            editText_title.setText(str);

        });

        button_cong.setOnClickListener(view -> {
            str += "+";
            editText_title.setText(str);


        });
        button_tru.setOnClickListener(view -> {
            str += "-";
            editText_title.setText(str);


        });
        button_chia.setOnClickListener(view -> {
            str += "/";
            editText_title.setText(str);


        });
        button_phay.setOnClickListener(view -> {
            str += ".";
            editText_title.setText(str);

        });
        button_bang.setOnClickListener(view -> {
            number1 = tinh(editText_title.getText().toString().trim());
            str = number1 + "";
            editText_title.setText(str);


        });
        button_nhan.setOnClickListener(view -> {
            str += "x";
            editText_title.setText(str);


        });
    }

    private double tinh(final String str) {

        return new Object() {
            int pos = -1, ch;

            private void getChar() {
                ch = (++pos < str.length() ? str.charAt(pos) : -1);
            }

            private boolean check(int index) {
                while (ch == ' ') {
                    getChar();
                }
                if (ch == index) {
                    getChar();
                    return true;
                }
                return false;
            }

            private double congTru() {
                double number = nhanChia();
                for (; ; ) {
                    if (check('+')) {
                        number += nhanChia();
                    } else if (check('-')) {
                        number -= nhanChia();
                    } else {
                        return number;
                    }

                }
            }

            private double nhanChia() {
                double number = tinhtoan();
                for (; ; ) {
                    if (check('x')) {
                        number *= tinhtoan();
                    } else if (check('/')) {
                        number /= tinhtoan();
                    } else {
                        return number;
                    }
                }
            }

            private double tinhtoan() {
                int startPost = this.pos;
                double ketqua;
                    while (ch >= '0' && ch <= '9'|| ch == '.') {
                        getChar();
                    }
                    ketqua = Double.parseDouble(str.substring(startPost, this.pos));
                return ketqua;
            }

            private double ketqua() {
                getChar();
                return congTru();
            }
        }.ketqua();
    }
    private double tinh2(final String str){
        String[] mangStr = str.split("");
        return 0;
    }



    private void anhxa() {
        editText_title = findViewById(R.id.edit_ht);
        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        button_chia = findViewById(R.id.button_chia);
        button_cong = findViewById(R.id.button_cong);
        button_bang = findViewById(R.id.button_bang);
        button_phay = findViewById(R.id.button_phay);
        button_tru = findViewById(R.id.button_tru);
        button_nhan = findViewById(R.id.button_nhan);
        button_delete = findViewById(R.id.button_delete);


    }
}