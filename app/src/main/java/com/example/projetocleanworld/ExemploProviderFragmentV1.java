package com.example.projetocleanworld;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ExemploProviderFragmentV1 extends SupportMapFragment implements OnMapReadyCallback
        , GoogleMap.OnMapClickListener{

    private GoogleMap mMap;

    private LocationManager locationManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
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


        locationManager = (LocationManager ) getActivity().getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();

        String provider = locationManager.getBestProvider(criteria, true);

        Toast.makeText(getActivity(), "Provider Exemplo" + provider , Toast.LENGTH_LONG).show();

        mMap = googleMap;

        mMap.setOnMapClickListener(this);

        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setMyLocationEnabled(true);



        // Marcador de Santana
        LatLng santana = new LatLng(-23.502625, -46.625080);
        MarkerOptions marker = new MarkerOptions();
        marker.position(santana);
        marker.title("Marcador de Santana");
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(santana));
    }

    @Override
    public void onMapClick(LatLng latLng) {

        Toast.makeText(getContext(),"Coordenadas sao : " + latLng  , Toast.LENGTH_SHORT ).show();

    }
}

