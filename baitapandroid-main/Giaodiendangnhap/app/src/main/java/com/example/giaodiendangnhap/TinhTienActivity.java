package com.example.giaodiendangnhap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class TinhTienActivity extends AppCompatActivity {

    TextView textView_title, textView_ttHoaDon, textView_tenKH, textView_slSach, textView_thanhTien,
            textView_TTThongKe, textView_tongKH, textView_tongKHVIP, textView_tongDoanhThu, textView_null, textView_tien;
    EditText editText_tenKH, editText_SLBook, editText_tongKH, editText_tongKHVIP,
            editText_tongDoanhThu;
    CheckBox checkBox_vip;
    Button button_thanhTien, button_Tiep, button_ThongKe;
    int tongKH, tongKHVip;
    double tongTien;
    ImageButton imageButton_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tinhtien_bansach);
        anhxa();
        button_thanhTien.setOnClickListener(view -> {
            textView_tien.setText(tinhTien() + "");
        });
        button_Tiep.setOnClickListener(view -> {
            if (!editText_tenKH.getText().toString().equals("") || !editText_SLBook.getText().toString().equals("")) {
                luuTT();
            }
        });
        button_ThongKe.setOnClickListener(view -> {
            thongKe();
        });
        imageButton_out.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Thong bao");
            builder.setMessage("Chac chan ban muon thoat?");
            builder.setNegativeButton("No", (dialogInterface, i) -> {
            });
            builder.setPositiveButton("Yes", (dialogInterface, i) -> {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                finish();
            });
            builder.show();
        });

    }

    private void anhxa() {
        textView_null = findViewById(R.id.textView_null);
        textView_slSach = findViewById(R.id.textView_slBook);
        textView_title = findViewById(R.id.textView_title_tinhtien);
        textView_tenKH = findViewById(R.id.textView_tenKh);
        textView_tongDoanhThu = findViewById(R.id.textView_tongDT);
        textView_ttHoaDon = findViewById(R.id.textview_ttHoaDon);
        textView_thanhTien = findViewById(R.id.textView_thanhTien);
        textView_TTThongKe = findViewById(R.id.textview_ttThongKe);
        textView_tongKH = findViewById(R.id.textView_tongKH);
        textView_tongKHVIP = findViewById(R.id.textView_tongKHVIp);
        editText_SLBook = findViewById(R.id.edit_slBook);
        editText_tenKH = findViewById(R.id.edit_tenKh);
        textView_tien = findViewById(R.id.textView_tien);
        editText_tongDoanhThu = findViewById(R.id.edit_tongDT);
        editText_tongKH = findViewById(R.id.edit_tongKH);
        editText_tongKHVIP = findViewById(R.id.edit_tongKHVIP);
        checkBox_vip = findViewById(R.id.checkBox_vip);
        button_thanhTien = findViewById(R.id.button_tinhTT);
        button_ThongKe = findViewById(R.id.button_thongke);
        button_Tiep = findViewById(R.id.button_tiep);
        imageButton_out = findViewById(R.id.imageButton_out);
    }

    private double tinhTien() {
        double tongTien;
        if (checkBox_vip.isChecked()) {
            tongTien = Integer.parseInt(editText_SLBook.getText().toString().trim()) * 18000;
        } else {
            tongTien = Integer.parseInt(editText_SLBook.getText().toString().trim()) * 20000;
        }
        return tongTien;
    }

    private void luuTT() {
        tongKH += 1;
        if (checkBox_vip.isChecked()) {
            tongKHVip += 1;
        }
        tongTien += tinhTien();
        editText_SLBook.setText("");
        editText_tenKH.setText("");
        textView_tien.setText("");
        checkBox_vip.setChecked(false);
    }

    private void thongKe() {
        editText_tongKH.setText(tongKH + "");
        editText_tongKHVIP.setText(tongKHVip + "");
        editText_tongDoanhThu.setText(tongTien + "");
    }

}