package com.example.ungdungdocbaorss;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        webView = findViewById(R.id.web_view);

        String link = getIntent().getStringExtra("link");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());

    }
}
