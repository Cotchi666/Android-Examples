package com.example.sqltodolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database database;
    ListView listView_cv;
    ArrayList<CongViec> list_cv;
    CongViecAdapter congViecAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView_cv = findViewById(R.id.listview_congviec);
        list_cv = new ArrayList<>();
        congViecAdapter = new CongViecAdapter(this, list_cv, R.layout.congviec);
        listView_cv.setAdapter(congViecAdapter);

        //tao ghi chu
        database = new Database(this, "ghichu.sqlite", null, 1);
        //tao bang
        database.queryData("CREATE TABLE IF NOT EXISTS Congviec(Id INTEGER PRIMARY KEY AUTOINCREMENT, Tencv VARCHAR(200))");
        //  database.queryData("INSERT INTO Congviec VALUES(null,'Lap trinh mobile')");
        inThongTin();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_add) {
            dialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private void dialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add);

        Button button_add, button_xoa;
        TextView textView_title = dialog.findViewById(R.id.textView_tittleUpdate);
        EditText editText_nhap = dialog.findViewById(R.id.edit_nhapUpdtae);
        button_add = dialog.findViewById(R.id.button_add);
        button_xoa = dialog.findViewById(R.id.button_huy);

        button_xoa.setOnClickListener(view -> dialog.dismiss());
        button_add.setOnClickListener(view -> {
            String tenvc = editText_nhap.getText().toString().trim();
            if (tenvc.equals("")) {
                Toast.makeText(this, "Vui long nhap ten cong viec", Toast.LENGTH_SHORT).show();
            } else {
                database.queryData("INSERT INTO Congviec VALUES(null,'" + tenvc + "')");
                Toast.makeText(this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                inThongTin();
            }
        });
        dialog.show();
    }

    private void inThongTin() {
        list_cv.clear();
        Cursor cursorDataCongviec = database.getData("SELECT * FROM Congviec");
        while (cursorDataCongviec.moveToNext()) {
            list_cv.add(new CongViec(cursorDataCongviec.getString(1), cursorDataCongviec.getInt(0)));
        }
        congViecAdapter.notifyDataSetChanged();
    }

    public void dialogSua(String ten, int id) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sua);

        Button button_xn, button_huy;
        TextView textView_title = dialog.findViewById(R.id.textView_tittleUpdate);
        EditText editText_nhap = dialog.findViewById(R.id.edit_nhapUpdtae);
        button_xn = dialog.findViewById(R.id.button_add);
        button_huy = dialog.findViewById(R.id.button_huy);

        editText_nhap.setText(ten);
        button_huy.setOnClickListener(view -> dialog.dismiss());
        button_xn.setOnClickListener(view -> {
            String tenvc = editText_nhap.getText().toString().trim();
            if (tenvc.equals("")) {
                Toast.makeText(this, "Vui long nhap ten cong viec", Toast.LENGTH_SHORT).show();
            } else {
                database.queryData("UPDATE Congviec SET Tencv ='" + tenvc + "' WHERE Id='" + id + "'");
                Toast.makeText(this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                inThongTin();
            }
        });
        dialog.show();
    }

    public void dialogRemove(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Ban co muon xoa?");
        builder.setNegativeButton("Khong", (dialogInterface, i) -> {

        });
        builder.setPositiveButton("Co", (dialogInterface, i) -> {
            database.queryData("DELETE FROM Congviec WHERE Id='" + id + "'");
            Toast.makeText(MainActivity.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
            inThongTin();
        });
        builder.show();

    }
}