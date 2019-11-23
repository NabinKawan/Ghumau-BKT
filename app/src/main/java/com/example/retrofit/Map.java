package com.example.retrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

public class Map extends AppCompatActivity implements View.OnClickListener{
    private MapView mapView;
    TextView map;
    ImageView home,favourite,chat,menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //map=findViewById(R.id.map);
        home=findViewById(R.id.home1);
        favourite=findViewById(R.id.fav);
        chat=findViewById(R.id.chat);
        menu=findViewById(R.id.menu);
        Mapbox.getInstance(this,"pk.eyJ1Ijoia25lZXJvc2UiLCJhIjoiY2syaDA3aTgyMDE2czNib2VmNnBzenkzdyJ9.-jlrGU2AdXa4uePjJxaBkg");
        setContentView(R.layout.activity_map);
        mapView = findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {
                mapboxMap.setStyle(Style.TRAFFIC_DAY,new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

// Map is set up and the style has loaded. Now you can add data or make other map adjustments.


                    }
                });
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.home1:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.fav:
                startActivity(new Intent(this,Favourite.class));
                break;
            case R.id.chat:
                startActivity(new Intent(this,Chat.class));
                break;
            case R.id.mapp:
                startActivity(new Intent(this,Map.class));
                break;
            case R.id.menu:
                startActivity(new Intent(this,Menu.class));
                break;

        }

    }
}
