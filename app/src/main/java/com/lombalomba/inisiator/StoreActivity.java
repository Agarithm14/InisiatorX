package com.lombalomba.inisiator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class StoreActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    return true;
                case R.id.nav_explore:
                    startActivity(new Intent(getApplication(), ExploreActivity.class));
                    finish();
                    return true;
                case R.id.nav_order:
                    startActivity(new Intent(getApplication(), OrderActivity.class));
                    finish();
                    return true;
                case R.id.nav_profile:
                    startActivity(new Intent(getApplication(), ProfileActivity.class));
                    finish();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        WebView mWebView = findViewById(R.id.webStore);
        mWebView.setWebViewClient(new AppWebViewClients());
        mWebView.loadUrl("https://www.google.com/");
        WebSettings wVSettings = mWebView.getSettings();
        wVSettings.setJavaScriptEnabled(true);
        wVSettings.setLoadWithOverviewMode(true);
        wVSettings.setUseWideViewPort(true);
        wVSettings.setBuiltInZoomControls(true);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.nav_home);
    }

    public class AppWebViewClients extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            findViewById(R.id.loading).setVisibility(View.GONE);
        }
    }

}
