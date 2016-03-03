package pl.digitalzombielab.kenistoys.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import pl.digitalzombielab.kenistoys.CommonColors;
import pl.digitalzombielab.kenistoys.R;

public class MainActivity extends AppCompatActivity implements CommonColors {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setNaviBarColor();
    }

    public void click(View view) {
        Intent intent = null;
        switch (view.getId())
        {
            case R.id.kenisBtn:
                intent = new Intent(MainActivity.this, KenisActivity.class);
                break;
            case R.id.toysBtn:
                intent = new Intent(MainActivity.this, ToysActivity.class);
                break;
        }
        startActivity(intent);
    }

    @Override
    public void setNaviBarColor()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
            getWindow().setNavigationBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
    }
}