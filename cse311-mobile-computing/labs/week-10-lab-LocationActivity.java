package cn.edu.xjtlu.sensortest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class LocationActivity extends AppCompatActivity {
    LocationListener listener = new LocationListener() {
        public void onLocationChanged(Location location) {
            TextView tv = (TextView) findViewById(R.id.locationLabel);
            tv.setText("location=" + location.getLatitude() + "; " +
                    "time=" + location.getTime() + "; " +
                    "Accuracy=" + location.getAccuracy() + "\n");
        }
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.i("LocationTester", "provider status is changed");
        }
        public void onProviderEnabled(String provider) {
            Log.i("LocationTester", "provider is enabled");
        }
        public void onProviderDisabled(String provider) {
            Log.i("LocationTester", "provider is closed");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        RadioGroup methodChoice = findViewById(R.id.locationMethod);
        final RadioButton radio1 = findViewById(R.id.nwBasedBtn);
        final RadioButton radio2 = findViewById(R.id.gpsBasedBtn);
        final LocationManager locationManager = (LocationManager) LocationActivity.this.getSystemService(Context.LOCATION_SERVICE);
        methodChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == radio1.getId()) {
                    //locationManager.removeUpdates(listener);
                    try {
                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
                    } catch (SecurityException e) {
                        Toast.makeText(LocationActivity.this, "Permission not granted", Toast.LENGTH_SHORT).show();
                    }
                } else if (i == radio2.getId()) {
                    try {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
                    } catch (SecurityException e) {
                        Toast.makeText(LocationActivity.this, "Permission not granted", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    locationManager.removeUpdates(listener);
                    TextView tv = (TextView) findViewById(R.id.locationLabel);
                    tv.setText("Location Service OFF");
                }
            }
        });
    }

//    public void displayOldLocation() {
//        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
//        try {
//            Location lastLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//            if (lastLocation != null) {
//                TextView tv = (TextView) findViewById(R.id.locationLabel);
//                tv.setText("location=" + lastLocation.getLatitude() + "; " +
//                           "time=" + lastLocation.getTime() + ": " +
//                           "Accuracy=" + lastLocation.getAccuracy() + "\n");
//            }
//        } catch (SecurityException e) {
//            Toast.makeText(this, "gps sensor error", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public void displayNewLocation() {
//        LocationManager locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
//        LocationListener locationListener = new LocationListener() {
//            public void onLocationChanged(Location location) {
//                double dNewLoca = location.getLatitude();
//                double lNewTime = location.getTime();
//                double fNewAccu = location.getAccuracy();
//                TextView tv = (TextView) findViewById(R.id.locationLabel);
//                tv.append("location=" + dNewLoca + "; time=" + lNewTime + "; Accuracy=" + fNewAccu + "\n");
//            }
//            public void onStatusChanged(String provider, int status, Bundle extras) {}
//            public void onProviderEnabled(String provider) {}
//            public void onProviderDisabled(String provider) {}
//        }; // Register the listener with the Location Manager to receive location updates
//        try {
//            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
//        } catch (SecurityException e) {
//            Toast.makeText(this, "gps sensor error", Toast.LENGTH_SHORT).show();
//        }
//    }
}
