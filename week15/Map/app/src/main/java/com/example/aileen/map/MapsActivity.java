package com.example.aileen.map;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    //Google map object
    private GoogleMap mMap;

    // A request object to store parameters for requests to the FusedLocationProviderApi
    private LocationRequest mLocationRequest;

    // location where the device is currently located
    private Location mCurrentLocation;

    //// marker for current location
    private Marker mCurrentLocationMarker;

    // The entry point to Google Play services, used by the Places API and Fused Location Provider.
    private GoogleApiClient mGoogleApiClient;

    //can be any value >0
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        checkLocationPermission();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        //sets a callback object which will be triggered when the GoogleMap instance is ready to be used
        mapFragment.getMapAsync(this);
        buildGoogleApiClient();
    }

    /*
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

        //set map type
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        //check for permission
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            //enables location layer
            mMap.setMyLocationEnabled(true);
        }
        /*
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
    }

    private synchronized void buildGoogleApiClient() {
        //The GoogleApiClient class is the main entry point for integrating with Google Play Services
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this) //connection callbacks are called when the client is connected or disconnected
                .addOnConnectionFailedListener(this) //handles failed attempt of connect client to service
                .addApi(LocationServices.API) //adds the Google Play Service LocationServices API
                .build(); //builds the GoogleApiClient object
        mGoogleApiClient.connect(); //connect client
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000); //set the desired interval for active location updates, in milliseconds
        mLocationRequest.setFastestInterval(1000); //set the fastest interval for location updates, in milliseconds
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY); //set priority of the request

        //check permission
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            //request location updates
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        //set current location to the new location
        mCurrentLocation = location;

        //define an object of the Google LatLng class with location coordinates
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        //check to see if there's a current marker
        if (mCurrentLocationMarker == null) {
            //define an object of the Google MarkerOptions class
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title("Current Position");

            //place current location marker
            mCurrentLocationMarker = mMap.addMarker(markerOptions);

        } else{
            //set position of existing marker
            mCurrentLocationMarker.setPosition(latLng);
        }

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    public void checkLocationPermission(){
        //check for permission
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                // returns true if the app has requested this permission previously and the user denied the request

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //request permission once explanation has been shown
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);

                // returns false if user has chosen Don’t ask again option when it previously asked for permission
            } else {
                //no explanation needed, request permissions
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled the result arrays are empty
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // Permission was granted
                    if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                        Toast.makeText(this, "permission granted", Toast.LENGTH_LONG).show();
                    }
                } else { // Permission denied
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
            }
            // add other 'case' lines to check for other permissions your app might request
        }
    }
}
