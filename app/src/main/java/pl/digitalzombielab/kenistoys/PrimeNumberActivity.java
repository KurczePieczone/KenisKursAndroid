package pl.digitalzombielab.kenistoys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.concurrent.ExecutionException;

public class PrimeNumberActivity extends AppCompatActivity {

    //EditText whichPrime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_number);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //whichPrime = (EditText) findViewById(R.id.primeNumET);
    }
    public void primeNumClick(View view) {
        new BackgroundOperation(this).execute();
    }
}
