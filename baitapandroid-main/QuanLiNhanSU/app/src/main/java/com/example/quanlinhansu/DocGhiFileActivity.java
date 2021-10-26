package com.example.quanlinhansu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DocGhiFileActivity extends AppCompatActivity {

    Button button_Read, button_Write;
    EditText editText_ndfile;
    private String simpleFileName = "testFile.cache";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_ghi_file);
        anhxa();
        button_Read.setOnClickListener(view -> {
            readFile();
        });
        button_Write.setOnClickListener(view -> {
            writeFile();
            editText_ndfile.setText("");
        });

    }

    private void anhxa() {
        button_Read = findViewById(R.id.button_Read);
        button_Write = findViewById(R.id.button_Write);
        editText_ndfile = findViewById(R.id.edit_noidungFile);
    }

    private void readFile() {
        try {
            FileInputStream fileInputStream = openFileInput(simpleFileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String data;
            StringBuilder stringBuilder = new StringBuilder();
            while ((data = bufferedReader.readLine()) != null) {
                stringBuilder.append(data);
                stringBuilder.append("\n");
            }
            fileInputStream.close();
            editText_ndfile.setText(stringBuilder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeFile() {
        try {
            FileOutputStream fileOutputStream = openFileOutput("employee.html", 0);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(editText_ndfile.getText().toString());
            outputStreamWriter.close();
            Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}