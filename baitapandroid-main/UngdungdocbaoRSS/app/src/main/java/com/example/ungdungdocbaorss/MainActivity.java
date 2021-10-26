package com.example.ungdungdocbaorss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<String> list, list1;
    ListView listView;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        new ReadRSS().execute("https://vnexpress.net/rss/the-thao.rss");
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            intent.putExtra("link", list1.get(i));
            startActivity(intent);
        });

    }

    private void anhxa() {
        listView = findViewById(R.id.listview_title);
        list = new ArrayList<>();
        list1 = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
    }

    private class ReadRSS extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                URL url = new URL(strings[0]);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
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
            super.onPostExecute(s);
            String tieude = "";
            XMLDOMParser parser = new XMLDOMParser();

            NodeList nodeList = parser.getDocument(s).getElementsByTagName("item");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                tieude = parser.getValue(element, "title");
                Element element_link = (Element) nodeList.item(i);
                list.add(tieude);
                list1.add(parser.getValue(element_link, "link"));
            }
            arrayAdapter.notifyDataSetChanged();

        }
    }
}