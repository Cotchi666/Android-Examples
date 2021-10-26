package com.example.demowebserver;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UpdateActivity extends AppCompatActivity {
    EditText editText_ten, editText_ns, editText_dc;
    Button button_xn, button_huy;
    TextView textView_title;
    int id1 = 0;
    SinhVien sinhVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        anhxa();

        editText_ten.setText(sinhVien.getHoten());
        editText_ns.setText(sinhVien.getNamsinh() + "");
        editText_dc.setText(sinhVien.getDiachi());

        button_huy.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));
        button_xn.setOnClickListener(view -> {

            if (editText_ten.getText().toString().trim().equals("") ||
                    editText_ns.getText().toString().trim().equals("") ||
                    editText_dc.getText().toString().trim().equals("")) {
                Toast.makeText(this, "Vui long nhap day du thong tin!!!", Toast.LENGTH_SHORT).show();
            } else {
                updateSinhVien("http://tpqseven.atwebpages.com/update.php");
            }
        });


    }

    private void anhxa() {
        editText_ten = findViewById(R.id.edit_ten);
        editText_ns = findViewById(R.id.edit_ns);
        editText_dc = findViewById(R.id.edit_dc);
        button_huy = findViewById(R.id.button_huy);
        button_xn = findViewById(R.id.button_xn);
        textView_title = findViewById(R.id.textView_tiltle);
        sinhVien = (SinhVien) getIntent().getSerializableExtra("dataSV");
    }

    private void updateSinhVien(String urlStr) {


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlStr,
                response -> {
                    if (response.trim().equals("success")) {
                        Toast.makeText(this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "That bai", Toast.LENGTH_SHORT).show();
                    }
                }, error -> {
            Toast.makeText(this, "Loi he thong", Toast.LENGTH_SHORT).show();

        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                id1 = sinhVien.getId();
                params.put("idSV", String.valueOf(id1));
                params.put("hotenSV", editText_ten.getText().toString().trim());
                params.put("namsinhSV", editText_ns.getText().toString().trim());
                params.put("diachiSV", editText_dc.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
        startActivity(new Intent(this, MainActivity.class));
    }
}