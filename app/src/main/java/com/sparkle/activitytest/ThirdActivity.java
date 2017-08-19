package com.sparkle.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        Button btn4 = (Button) findViewById(R.id.button_4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:15710862580"));
                startActivity(intent);
            }
        });

        Intent intentget = getIntent();
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        if (intentget.getData() != null) {
            Log.d("打开地址", intentget.getData().toString());
            webView.loadUrl(intentget.getData().toString());
        }
        webView.requestFocus();


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("ret","lalalalalalalalalallalalalalalalala");
        setResult(666, intent);
        finish();
    }
}
