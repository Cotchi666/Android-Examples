package com.example.quanlinhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DocGhiCaheActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    Button btncreatecache, btnreadcache;
    EditText editdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_ghi_cahe);
        anhxa();
        btncreatecache.setOnClickListener(view -> {
            createCache();
            editdata.setText("");
            Toast.makeText(this, "Successfully", Toast.LENGTH_SHORT).show();

        });
        btnreadcache.setOnClickListener(view -> {
            readCache(getIntent().getStringExtra("data"));
        });
     //   loadAllCache();
       /* File file = getFilesDir();
        File[] files = file.listFiles();
        listView = findViewById(R.id.listView_cache);
        for (File filesss : files) {
            System.out.println(filesss.toString());
        }
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, files);
        listView.setAdapter(adapter);*/
    }

    private void anhxa() {
        btncreatecache = (Button) findViewById(R.id.btncreatecache);
        btnreadcache = (Button) findViewById(R.id.btnreadcache);
        editdata = (EditText) findViewById(R.id.editdata);
    }


    /**
     * Lấy toàn bộ file cache
     */
    public void loadAllCache() {
        File pathCacheDir = getCacheDir();
        File[] listCache = pathCacheDir.listFiles();
        for (File f : listCache) {
            //process f here
            f.delete();

        }
      //  Toast.makeText(this, "file ne: " + listCache[0].getName(), Toast.LENGTH_LONG).show();

    }

    /**
     * đọc cache file
     * getCacheDir() trả về đúng thư mục cache*/

    public void readCache(String strCacheFileName) {
        try {
            File pathCacheDir = getCacheDir();

            File newCacheFile = new
                    File(pathCacheDir, strCacheFileName);
            Scanner sc = new Scanner(newCacheFile);
            String data = "";
            while (sc.hasNext()) {
                data += sc.nextLine() + "\n";
            }
            editdata.setText(data);
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

   /* *
     * Lưu cache file*/

    public void createCache() {
        try {
            File pathCacheDir = getCacheDir();
            String strFileContents = editdata.getText() + "";
            File newCacheFile = new
                    File(pathCacheDir, "employee.html");
            newCacheFile.createNewFile();
            FileOutputStream foCache =
                    new FileOutputStream(
                            newCacheFile.getAbsolutePath());
            foCache.write(strFileContents.getBytes());
            foCache.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}