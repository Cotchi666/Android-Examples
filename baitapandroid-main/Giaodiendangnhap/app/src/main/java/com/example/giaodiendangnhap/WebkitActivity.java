package com.example.giaodiendangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import entity.MyLocation;

public class WebkitActivity extends AppCompatActivity {

    MyLocation myLocation = null;
    @SuppressLint("SetJavaScriptEnabled")
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webkit);
        webView = findViewById(R.id.webview_id);
        myLocation = new MyLocation(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(myLocation,"location");
       webView.loadUrl("a");

    }
}