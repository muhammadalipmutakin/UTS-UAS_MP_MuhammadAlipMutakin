package com.example.mp_muhammadalipmutakin;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mp_muhammadalipmutakin.databinding.ActivityMapsBinding;

public class maps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMapsBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng unpam = new LatLng(-6.345965506120672, 106.69162610990126);
        mMap.addMarker(new MarkerOptions().position(unpam).title("Universitas Pamulang, Viktor"));
        mMap.setMaxZoomPreference(1000);
        mMap.setMinZoomPreference(10);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(unpam));

    }
    public void onBackPressed() {
        Intent intent1 = new Intent(getApplicationContext(), MenuUtama.class);
        startActivity(intent1);
    }
}