package com.example.riyaz.googlemapsretrofit;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.riyaz.googlemapsretrofit.POJO.Example;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static android.R.attr.data;

/**
 * Created by Riyaz on 8/1/2017.
 */

public class DisplayLocActivity extends AppCompatActivity{

    String[] country = {"India", "USA", "Pakistan", "China", "Egypt", "Canada", "Malysia", "UAE", "UK",
                "France", "Poland", "Greece", "Mexico", "Spain", "Australia"};
    RecyclerView recyclerView;
    LocationAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    double latitude;
    double longitude;
    private int PROXIMITY_RADIUS = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1);

        build_retrofit_and_get_response("bank");

//        View view = inflater.inflate(R.layout.tab1, container, false);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new LocationAdapter(country);
        recyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void build_retrofit_and_get_response(String type) {
        String url = "https://maps.googleapis.com/maps/";
//        String url = "https://maps.googleapis.com/maps/place/textsearch/json?query=BBVA+Compass&location="+latitude+","+longitude+"&radius=10000";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitMaps service = retrofit.create(RetrofitMaps.class);
        Call<Example> call = service.getNearbyPlaces(type, latitude + "," + longitude, PROXIMITY_RADIUS);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Response<Example> response, Retrofit retrofit) {

                try {

//                        mMap.clear();
//                        // This loop will go through all the results and add marker on each location.
//                        for (int i = 0; i < response.body().getResults().size(); i++) {
//                            Double lat = response.body().getResults().get(i).getGeometry().getLocation().getLat();
//                            Double lng = response.body().getResults().get(i).getGeometry().getLocation().getLng();
//                            String placeName = response.body().getResults().get(i).getName();
////                        if (placeName.contains("BBVA")) {
//                            String vicinity = response.body().getResults().get(i).getVicinity();
//                            MarkerOptions markerOptions = new MarkerOptions();
//                            LatLng latLng = new LatLng(lat, lng);
//                            // Position of Marker on Map
//                            markerOptions.position(latLng);
//                            // Adding Title to the Marker
//                            markerOptions.title(placeName + " : " + vicinity);
//                            // Adding Marker to the Camera.
//                            Marker m = mMap.addMarker(markerOptions);
//                            // Adding colour to the marker
//                            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
//                            // move map camera
//                            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//                            mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
//                        }


                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });

    }

}
