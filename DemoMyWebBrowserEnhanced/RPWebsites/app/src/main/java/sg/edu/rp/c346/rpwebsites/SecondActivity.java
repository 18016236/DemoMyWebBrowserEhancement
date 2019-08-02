package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {
    WebView wvMyPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        wvMyPage = findViewById(R.id.webViewMyPage);
        Intent intentReceived = getIntent();
        String value = intentReceived.getStringExtra("value");
        wvMyPage = findViewById(R.id.webViewMyPage);
        wvMyPage.setWebViewClient(new WebViewClient());
        wvMyPage.getSettings().setJavaScriptEnabled(true);
        wvMyPage.getSettings().setAllowFileAccess(false);
        wvMyPage.getSettings().setBuiltInZoomControls(true);
        wvMyPage.loadUrl(value);


    }
}
