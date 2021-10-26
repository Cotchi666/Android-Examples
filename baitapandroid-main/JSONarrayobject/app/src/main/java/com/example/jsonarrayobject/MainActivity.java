package com.example.jsonarrayobject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<KhoaHoc> list;
    ListView listView;
    KhoaHocAdapter arrayAdapter;
    ImageView imageView;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

      //  new ReadJSON().execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo5.json");
     //   new LoadAnh().execute("https://khoapham.vn/public/images/logo/android.png");
        LoadAnh loadAnh = new LoadAnh();
        loadAnh.execute("https://khoapham.vn/public/images/logo/ioscoban.png");

        listView.setAdapter(arrayAdapter);
    }

    private void anhxa() {
        list = new ArrayList<>();
        listView = findViewById(R.id.list_view);
        arrayAdapter = new KhoaHocAdapter(this, list, R.layout.khoa_hoc);
        imageView = findViewById(R.id.imageView_anh);
    }

    private class ReadJSON extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(new URL(strings[0]).openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while (null != (line = bufferedReader.readLine())) {
                    stringBuilder.append(line);
                }
                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {

            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String hinhanh = jsonObject.getString("hinhanh");
//                    LoadAnh loadAnh = new LoadAnh();
//                    loadAnh.execute(hinhanh);
//                    Bitmap bitmap = loadAnh.bitmap;
                    new LoadAnh().execute(hinhanh);

                    //   Toast.makeText(MainActivity.this, hinhanh, Toast.LENGTH_SHORT).show();
                    //   if (bitmap != null) {
                    list.add(new KhoaHoc(jsonObject.getString("khoahoc") + " - " + hinhanh, jsonObject.getString("hocphi"), null));
                    // }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            super.onPostExecute(s);
        }
    }


    private class LoadAnh extends AsyncTask<String, Void, Bitmap> {
        Bitmap bitmap = null;

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            list.add(new KhoaHoc("","",bitmap));
        }
    }
}