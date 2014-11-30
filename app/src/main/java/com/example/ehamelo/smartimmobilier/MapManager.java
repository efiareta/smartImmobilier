package com.example.ehamelo.smartimmobilier;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehamelo on 27/11/2014.
 */
public class MapManager {
    /** Local variables **/
    GoogleMap googleMap;
    Context context;

    public MapManager(Activity a,int MapFragmentId){
        this.googleMap=((MapFragment)a.getFragmentManager().findFragmentById(MapFragmentId)).getMap();
        createMapView();
        this.context=a.getApplicationContext();
    }

    /**
     * Initialises the mapview
     */
    public void createMapView(){

        try {

                googleMap.setMapType(googleMap.MAP_TYPE_SATELLITE);
                googleMap.setMyLocationEnabled(true);
                googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        } catch (NullPointerException exception){
            Log.e("mapApp", exception.toString());
        }
    }

    /**
     * Adds a marker to the map
     */
    public void addMarker(double longitude, double latitude){
        /** Make sure that the map has been initialised **/
        if(null != googleMap){
            googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(longitude,latitude))
                            .title("ici")
                            .draggable(true)
            );
        }
    }

    public ArrayList<Double> AdresseToMarker(String adresse) throws IOException {
        ArrayList<Double> coord=new ArrayList<Double>();
        Geocoder gc = new Geocoder(context);

        List<Address> list = gc.getFromLocationName(adresse, 1);

        Address address = list.get(0);

        coord.add(address.getLatitude());
        coord.add(address.getLongitude());

        return coord;
    }
}
