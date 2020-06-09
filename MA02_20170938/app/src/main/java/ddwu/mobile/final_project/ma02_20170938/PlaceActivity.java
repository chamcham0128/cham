package ddwu.mobile.final_project.ma02_20170938;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import noman.googleplaces.NRPlaces;
import noman.googleplaces.PlaceType;
import noman.googleplaces.PlacesException;
import noman.googleplaces.PlacesListener;

public class PlaceActivity extends AppCompatActivity implements OnMapReadyCallback {

    final static String TAG = "PlaceActivity";
    final static int PERMISSION_REQ_CODE = 100;

    private GoogleMap mGoogleMap;
    private MarkerOptions markerOptions;
    private Location lastlocation;
    private LatLng currentLoc;
    private LocationManager locManager;
    private PlacesClient placesClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (checkPermission()) {
            mapLoad();
        }
        lastlocation = locManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

        Places.initialize(getApplicationContext(), getString(R.string.googleapi_key));
        placesClient = Places.createClient(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_search:
                if (checkPermission()) {
                    locManager.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 5000, 0, locationListener);
                }
                break;
            case R.id.btn_home:
                Intent intent = new Intent(PlaceActivity.this, MainActivity.class);
                startActivity(intent);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        if (lastlocation == null) {
            currentLoc = new LatLng(37.606320, 127.041822);

        } else {
            currentLoc = new LatLng(lastlocation.getLatitude(), lastlocation.getLongitude());

        }
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLoc, 17));
        searchStart(currentLoc);

        markerOptions = new MarkerOptions();


        mGoogleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(final Marker marker) {
                String placeId = marker.getTag().toString();

                List<Place.Field> placeFields
                        = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.PHONE_NUMBER, Place.Field.ADDRESS);

                FetchPlaceRequest request = FetchPlaceRequest.builder(placeId, placeFields).build();

                placesClient.fetchPlace(request).addOnSuccessListener(new OnSuccessListener<FetchPlaceResponse>() {
                    @Override                    // 요청 성공 시 처리 리스너 연결
                    public void onSuccess(FetchPlaceResponse fetchPlaceResponse) {
                        Place place = fetchPlaceResponse.getPlace();
                        Log.i(TAG, "Place found: " + place.getName());
                        Log.i(TAG, "Phone: " + place.getPhoneNumber());
                        Log.i(TAG, "Address: " + place.getAddress());

                        Intent intent = new Intent(PlaceActivity.this, DetailActivity.class);
                        intent.putExtra("name", place.getName());
                        intent.putExtra("phone", place.getPhoneNumber());
                        intent.putExtra("address", place.getAddress());
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {   // 요청 실패 시 처리 리스너 연결
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        if (exception instanceof ApiException) {
                            ApiException apiException = (ApiException) exception;
                            int statusCode = apiException.getStatusCode();
                            Log.e(TAG, "Place not found: " + exception.getMessage());
                        }
                    }
                });
            }
        });
    }

    private void searchStart(LatLng location) {
        new NRPlaces.Builder().listener(placesListener)
                .key(getString(R.string.googleapi_key))
                .latlng(location.latitude, location.longitude)
                .radius(100)
                .type(PlaceType.RESTAURANT)
                .build()
                .execute();
    }

    PlacesListener placesListener = new PlacesListener() {
        @Override
        public void onPlacesSuccess(final List<noman.googleplaces.Place> places) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mGoogleMap.clear();

                    for (noman.googleplaces.Place place : places) {
                        markerOptions.title(place.getName());
                        markerOptions.position(new LatLng(place.getLatitude(), place.getLongitude()));
                        Marker newMarker = mGoogleMap.addMarker(markerOptions);
                        newMarker.setTag(place.getPlaceId());
                        Log.d(TAG, "ID: " + place.getPlaceId());
                    }
                }
            });
        }

        @Override
        public void onPlacesFailure(PlacesException e) {
        }

        @Override
        public void onPlacesStart() {
        }

        @Override
        public void onPlacesFinished() {
        }
    };

    private void mapLoad() {
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);      // 매배변수 this: MainActivity 가 OnMapReadyCallback 을 구현하므로
    }


    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        PERMISSION_REQ_CODE);
                return false;
            }
        }
        return true;
    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

            currentLoc = new LatLng(location.getLatitude(), location.getLongitude());
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLoc, 17));
            searchStart(currentLoc);

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


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQ_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                mapLoad();
            }
        }
    }
}
