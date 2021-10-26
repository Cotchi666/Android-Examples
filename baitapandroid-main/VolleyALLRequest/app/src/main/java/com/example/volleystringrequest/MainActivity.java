package com.example.volleystringrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, "https://khoapham.vn/KhoaPhamTraining/json/tien/demo4.json", null,
                response -> {
                    Toast.makeText(this, response.toString(), Toast.LENGTH_LONG).show();
                    try {
                        Toast.makeText(this, response.get(1).toString(), Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error ->
        {
            Toast.makeText(this, "loi", Toast.LENGTH_SHORT).show();
            Log.d("AAA", "loi: \n" + error);
        });
        /*JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json", null,
                response -> {
                    Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show();
                }, error -> {
            Toast.makeText(this, "loi", Toast.LENGTH_SHORT).show();
            Log.d("AAA", "Loi: \n" + error);
        });*/
        /*StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://developer.android.com/training/volley/simple",
                response -> {
                    Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
                }, error -> {
            Toast.makeText(this, "loi: ", Toast.LENGTH_SHORT).show();
            Log.d("AAA", "Loi: \n" + error.toString());
        });*/
        requestQueue.add(jsonObjectRequest);
    }
}