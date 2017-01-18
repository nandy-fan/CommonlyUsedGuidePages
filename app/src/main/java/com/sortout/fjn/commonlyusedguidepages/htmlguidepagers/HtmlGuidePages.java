package com.sortout.fjn.commonlyusedguidepages.htmlguidepagers;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.sortout.fjn.commonlyusedguidepages.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HtmlGuidePages extends AppCompatActivity {

    private String url;
    @BindView(R.id.webview)
    WebView mWebview;
    @BindView(R.id.activity_html_guide_pages)
    RelativeLayout mActivityHtmlGuidePages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_html_guide_pages);
        ButterKnife.bind(this);
        url = "file:///android_asset/guide/index.html";
        loadLocalHtml(url);
    }

    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    private void loadLocalHtml(String url) {
        WebSettings webSettings = mWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if ("http://start/".equals(url)) {
//                    Intent intent = new Intent(Html5ForWelActivity.this, MainActivity.class);
//                    startActivity(intent);
                    finish();
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }
        });
        mWebview.loadUrl(url);
    }
}
