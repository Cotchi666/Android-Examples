package com.example.demowebserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<SinhVien> list;
    SinhVienAdapter sinhVienAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        listView.setAdapter(sinhVienAdapter);

        readJSON("http://tpqseven.atwebpages.com/getData.php");
    }

    private void readJSON(String urlStr) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlStr,
                null, response -> {

            addList(response);

        },
                error -> {

                    Toast.makeText(MainActivity.this, "loi: " + error.toString(), Toast.LENGTH_LONG).show();
                    Log.d("AAA", "loi: \n" + error);
                });
        requestQueue.add(jsonArrayRequest);
    }

    private void anhxa() {
        listView = findViewById(R.id.listview_sv);
        list = new ArrayList<>();
        sinhVienAdapter = new SinhVienAdapter(this, list, R.layout.dong_sinhvien);
    }

    private void addList(JSONArray response) {
        list.clear();
        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject jsonObject = response.getJSONObject(i);
                list.add(new SinhVien(jsonObject.getInt("Id"),
                        jsonObject.getString("HoTen"),
                        jsonObject.getInt("NamSinh"),
                        jsonObject.getString("DiaChi")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        sinhVienAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.them_sv) {
            startActivity(new Intent(this, AddActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void removeSinhVien(String urlStr, final int id) {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlStr,
                response -> {
                    if (response.trim().equals("success")) {
                        Toast.makeText(this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();

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
                params.put("idSV", String.valueOf(id));

                return params;
            }
        };
        requestQueue.add(stringRequest);
        sinhVienAdapter.notifyDataSetChanged();
        startActivity(new Intent(this,MainActivity.class));
    }
}