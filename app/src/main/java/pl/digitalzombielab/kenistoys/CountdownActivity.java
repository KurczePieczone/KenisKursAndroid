package pl.digitalzombielab.kenistoys;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CountdownActivity extends AppCompatActivity implements CommonColors {

    private EditText title, body, value;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setNaviBarColor();
        title = (EditText) findViewById(R.id.notifyTitleET);
        body = (EditText) findViewById(R.id.notifyBodyET);
        value = (EditText) findViewById(R.id.notifyValueET);
        start = (Button) findViewById(R.id.countdownStartBtn);
    }

    public void countdownClick(View view) {
        createNotifi();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void createNotifi()
    {
        Notification notifi = new Notification.Builder(this).
                setContentTitle(title.getText())
                .setContentText(body.getText())
                .setSmallIcon(R.drawable.ico)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notifi);


    }

    @Override
    public void setNaviBarColor() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
            getWindow().setNavigationBarColor(getApplicationContext().getColor(R.color.colorPrimaryDark));
    }
}