package com.example.kevin.fitbuddy;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView speed = (TextView) findViewById(R.id.textView);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        final ArrayList locations = new ArrayList();
        final ArrayList latLngs = new ArrayList();
        //initialize location listener
            LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                locations.add(location);
                for (Object loc :  locations){
                    latLngs.add(new LatLng(location.getLatitude(),location.getLongitude()));
                }

                Double dist = SphericalUtil.computeLength(latLngs);
                speed.setText(dist.toString());
            }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }


            };
}}
