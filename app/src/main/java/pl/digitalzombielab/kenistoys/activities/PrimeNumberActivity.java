package pl.digitalzombielab.kenistoys.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.concurrent.ExecutionException;

import pl.digitalzombielab.kenistoys.BackgroundOperation;
import pl.digitalzombielab.kenistoys.CommonColors;
import pl.digitalzombielab.kenistoys.R;

public class PrimeNumberActivity extends AppCompatActivity implements CommonColors {

    //EditText whichPrime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_number);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setNaviBarColor();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //whichPrime = (EditText) findViewById(R.id.primeNumET);
    }
    public void primeNumClick(View view) {
        new BackgroundOperation(this).execute();
    }

    @Override
    public void setNaviBarColor()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
            getWindow().setNavigationBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
    }
}
