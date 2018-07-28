package org.robertlyon.newsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

public class webView extends AppCompatActivity {

    public static ArrayList<String> urlList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView aWebView = findViewById(R.id.webView);
        aWebView.getSettings().setJavaScriptEnabled(true);
        aWebView.setWebViewClient(new WebViewClient());






    }
}
