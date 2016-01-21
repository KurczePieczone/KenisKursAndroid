package pl.digitalzombielab.kenistoys;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class LevelActivity extends AppCompatActivity implements SensorEventListener {

    Context context = this;
    MediaPlayer mediaPlayer;
    private TextView level;
    private SensorManager sensorManager;
    private Sensor accelerometerSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mediaPlayer = MediaPlayer.create(context, R.raw.piano);
        level = (TextView) findViewById(R.id.levelTV);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        level.setText(event.values[0] +"\n"+ event.values[1] +"\n"+ event.values[2]);

        if(event.values[0]>0&&event.values[0]<2)
            if(!mediaPlayer.isPlaying())
                mediaPlayer.start();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
