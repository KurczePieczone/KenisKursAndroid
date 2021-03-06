package pl.digitalzombielab.kenistoys.activities;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import pl.digitalzombielab.kenistoys.CommonColors;
import pl.digitalzombielab.kenistoys.R;

public class NoteActivity extends AppCompatActivity implements CommonColors {

    EditText et;
    Bundle bundle = new Bundle();
    private String path = Environment.getExternalStorageDirectory() + "/Digital Zombie Lab/Kenis Toys";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("aktywność", "onCreate");
        setContentView(R.layout.activity_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setNaviBarColor();
        et = (EditText) findViewById(R.id.editText);
        et.setText(bundle.getString("et"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_save)
        {
            createDir();
            createFile();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void createDir()
    {
        File folder = new File(path);
        if(!folder.exists())
        {
            try
            {
                folder.mkdirs();
            }
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }

    public void createFile()
    {
        File file = new File(path+"/"+System.currentTimeMillis()+".txt");
        FileOutputStream fOut;
        OutputStreamWriter myOutWriter;
        try
        {
            fOut = new FileOutputStream(file);
            myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(et.getText());
            myOutWriter.close();
            fOut.close();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void setNaviBarColor()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
            getWindow().setNavigationBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
    }

    @Override
    protected void onStart() {
        Log.d("aktywność", "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("aktywność", "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("aktywność", "onPause");
        bundle.putString("et", et.getText().toString());
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.d("aktywność", "onRestart");
        super.onRestart();
    }

    @Override
    protected void onStop() {
        Log.d("aktywność", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("aktywność", "onDestroy");
        super.onDestroy();
    }

}
