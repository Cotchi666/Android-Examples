package com.example.giaodiendangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textview_title, textview_user, textview_pass;
    Button button_login, button_exit;
    CheckBox checkBox_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // loadTabs();
        anhxa();
        button_login.setOnClickListener(view -> {
            if (checkBox_save.isChecked()) {
                Toast.makeText(this, "Welcome to system, you have saved information", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Welcome to system, you don't save info", Toast.LENGTH_SHORT).show();
            }
            startActivity(new Intent(this,QuanLiBaiHatActivity.class));
        });
        button_exit.setOnClickListener(view -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Question?");
            dialog.setMessage("Are you sure you want exit?");
            dialog.setNegativeButton("No", (dialogInterface, i) -> {
                dialogInterface.cancel();
            });
            dialog.setPositiveButton("Yes", (dialogInterface, i) -> {
                Intent statMain = new Intent(Intent.ACTION_MAIN);
                statMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(statMain);
                finish();
            });
            dialog.show();
        });
    }

    private void anhxa() {
        textview_pass = findViewById(R.id.textView_pass);
        textview_title = findViewById(R.id.textView_tittle);
        textview_user = findViewById(R.id.textView_user);
        button_exit = findViewById(R.id.button_exit);
        button_login = findViewById(R.id.button_login);
        checkBox_save = findViewById(R.id.checkBox_sasve);

    }
   /*public void loadTabs()
   {
       //L???y Tabhost id ra tr?????c (c??i n??y c???a built - in android
       final TabHost tab=(TabHost) findViewById
               (android.R.id.tabhost);
       //g???i l???nh setup
       tab.setup();
       TabHost.TabSpec spec;
       //T???o tab1
       spec=tab.newTabSpec("t1");
       spec.setContent(R.id.tab1);
       spec.setIndicator("1-Calculator");
       tab.addTab(spec);
       //T???o tab2
       spec=tab.newTabSpec("t2");
       spec.setContent(R.id.tab2);
       spec.setIndicator("2-History");
       tab.addTab(spec);
       //Thi???t l???p tab m???c ?????nh ???????c ch???n ban ?????u l?? tab 0
       tab.setCurrentTab(1);
       //??? ????y T??i ????? s??? ki???n n??y ????? c??c b???n t??y x??? l??
       //V?? d??? tab1 ch??a nh???p th??ng tin xong m?? l???i qua tab 2 th?? b??o...
       tab.setOnTabChangedListener(arg0 -> {
           String s="Tab tag ="+arg0 +"; index ="+
                   tab.getCurrentTab();
           Toast.makeText(getApplicationContext(),
                   s, Toast.LENGTH_LONG).show();});
   }*/
}