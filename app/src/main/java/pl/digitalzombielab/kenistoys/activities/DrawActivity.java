package pl.digitalzombielab.kenistoys.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pl.digitalzombielab.kenistoys.CommonColors;
import pl.digitalzombielab.kenistoys.DrawView;
import pl.digitalzombielab.kenistoys.R;

public class DrawActivity extends AppCompatActivity implements CommonColors {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setNaviBarColor();
        DrawView view = new DrawView(this);
        setContentView(view);
        addContentView(view.cleanScreenBtn, view.params);

    }

    @Override
    public void setNaviBarColor()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
            getWindow().setNavigationBarColor(getApplicationContext().getColor(R.color.colorPrimaryDark));
    }

}
