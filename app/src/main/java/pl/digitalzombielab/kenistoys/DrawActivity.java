package pl.digitalzombielab.kenistoys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawView view = new DrawView(this);
        setContentView(view);
        addContentView(view.cleanScreenBtn, view.params);

    }

}
