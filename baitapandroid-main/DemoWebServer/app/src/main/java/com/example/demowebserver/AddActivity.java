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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    EditText editText_ten, editText_ns, editText_dc;
    Button button_them, button_huy;
    TextView textView_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_sv);
        anhxa();
        button_huy.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));
        button_them.setOnClickListener(view -> {
            if (editText_ten.getText().toString().trim().equals("") ||
                    editText_ns.getText().toString().trim().equals("") ||
                    editText_dc.getText().toString().trim().equals("")) {
                Toast.makeText(this, "Vui long nhap day du thong tin!!!", Toast.LENGTH_SHORT).show();
            } else {
                addSinhVien("http://tpqseven.atwebpages.com/insert.php");
            }
        });

    }

    private void anhxa() {
        editText_ten = findViewById(R.id.edit_ten);
        editText_ns = findViewById(R.id.edit_ns);
        editText_dc = findViewById(R.id.edit_dc);
        button_huy = findViewById(R.id.button_huy);
        button_them = findViewById(R.id.button_them);
        textView_title = findViewById(R.id.textView_tiltle);
    }

    private void addSinhVien(String urlStr) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlStr,
                response -> {
                    if (response.trim().equals("thanh cong")) {
                        Toast.makeText(this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "That bai", Toast.LENGTH_SHORT).show();
                    }
                }, error -> {
            Toast.makeText(this, "Loi he thong", Toast.LENGTH_SHORT).show();

        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
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