package cn.edu.xjtlu.sensortest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class LightSensorTest extends AppCompatActivity {
    SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float lux = sensorEvent.values[0];
            TextView tv= (TextView) findViewById(R.id.luxIndicator);
            tv.setText(String.valueOf(lux));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
            // Do something here if sensor accuracy changes.
        }
    };

    private SensorManager sensorManager;
    private Sensor sensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor_test);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(listener);
    }
}
