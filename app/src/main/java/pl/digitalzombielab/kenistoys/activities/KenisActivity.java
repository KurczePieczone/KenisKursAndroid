package pl.digitalzombielab.kenistoys.activities;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import pl.digitalzombielab.kenistoys.CommonColors;
import pl.digitalzombielab.kenistoys.R;

public class KenisActivity extends AppCompatActivity implements CommonColors {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kenis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setNaviBarColor();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        final Activity activity = this;
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                Toast.makeText(activity, description, Toast.LENGTH_LONG).show();
            }
        });
        webView.loadUrl("http://www.kenis.pl");
        setContentView(webView);
    }

    @Override
    public void setNaviBarColor()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
            getWindow().setNavigationBarColor(getApplicationContext().getColor(R.color.colorPrimaryDark));
    }

}
