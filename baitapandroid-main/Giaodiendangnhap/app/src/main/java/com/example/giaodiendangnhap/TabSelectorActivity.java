package com.example.giaodiendangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.net.CaptivePortal;
import android.os.Bundle;
import android.widget.TabHost;

public class TabSelectorActivity  extends SaveInfoActivity {

    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_selector);
        tabHost =findViewById(R.id.tabhost_test);
        tabHost.setup();
        TabHost.TabSpec tabSpec ;
        tabSpec = tabHost.newTabSpec("1");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Tinh tien ban sach");
        tabHost.addTab(tabSpec);
        tabSpec = tabHost.newTabSpec("2");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Luu thong tin");
        tabHost.addTab(tabSpec);




    }
}