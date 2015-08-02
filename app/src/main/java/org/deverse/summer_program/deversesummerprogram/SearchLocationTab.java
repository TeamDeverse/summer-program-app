package org.deverse.summer_program.deversesummerprogram;

import android.app.Activity;
import android.app.FragmentManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * Created by aluh on 8/2/2015.
 */
public class SearchLocationTab extends Fragment {

    private static GoogleMap mMap; // Might be null if Google Play services APK is not available.

    private static Double latitude, longitude;

    private double mlatitude, mlongitude; // to store user picked coordinates
    private String coordinateText;

    EditText addrText;
    Button mapSearchButton;

    TextView locationData;

    private final String TAG = "MapLocation";
    final Activity self = this.getActivity();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(container == null){
            return null;
        }
        View rootView = inflater.inflate(R.layout.search_location_tab, container, false);

        addrText = (EditText) rootView.findViewById(R.id.enter_location);
        mapSearchButton = (Button) rootView.findViewById(R.id.mapButton);

        locationData = (TextView) rootView.findViewById(R.id.coordinates);

        mapSearchButton.setOnClickListener(new View.OnClickListener() {

            // Called when user clicks the Show Map button
            public void onClick(View v) {
                try {

                    // Process text for network transmission
                    String address = addrText.getText().toString();
                    address = address.replace(' ', '+');

                    // Create Intent object for starting Google Maps application
//                    Intent geoIntent = new Intent(
//                            android.content.Intent.ACTION_VIEW, Uri
//                            .parse("geo:0,0?q=" + address));

//                    // Use the Intent to start Google Maps application using Activity.startActivity()
//                    startActivity(geoIntent);

                    LatLng latlng = getLocationFromAddress(address);

                    latitude = latlng.latitude;
                    longitude = latlng.longitude;

                    refreshMap();


                } catch (Exception e) {
                    // Log any error messages to LogCat using Log.e()
                    Log.e(TAG, e.toString());
                }
            }
        });

        // Buzzlab
        latitude = 42.350529;
        longitude = -71.099855;

        setUpMapIfNeeded();

        // Washington DC


        return rootView;
    }

    public LatLng getLocationFromAddress(String strAddress) {

        Geocoder coder = new Geocoder(getActivity());
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return p1;
    }

    private MapFragment getMapFragment() {
        FragmentManager fm = null;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            fm = getFragmentManager();
        } else {
            fm = getChildFragmentManager();
        }

        return (MapFragment) fm.findFragmentById(R.id.map);
    }

    /***** Sets up the map if it is possible to do so *****/
    public void setUpMapIfNeeded() {

        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            //mMap = ((MapFragment) self.getFragmentManager().findFragmentById(R.id.map)).getMap();

            mMap = getMapFragment().getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null)
                setUpMap();
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the
     * camera.
     * This should only be called once and when we are sure that {@link #mMap}
     * is not null.
     */
    private static void setUpMap() {

        mMap.clear();
        // For showing a move to my loction button
        mMap.setMyLocationEnabled(true);
        // For dropping a marker at a point on the Map
        final LatLng posCor = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(posCor).title("My Home").snippet("Home Address"));

        // For zooming automatically to the Dropped PIN Location
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(posCor, 12.0f));
    }


    private void refreshMap() {

        mMap.clear();
        // For showing a move to my loction button
        mMap.setMyLocationEnabled(true);
        // For dropping a marker at a point on the Map
        final LatLng posCor = new LatLng(latitude, longitude);
        final Marker myPosition = mMap.addMarker(new MarkerOptions().position(posCor).title("My Home").snippet("Home Address"));
        // Set onclick event
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.equals(myPosition)){
                    mlatitude = marker.getPosition().latitude;
                    mlongitude = marker.getPosition().longitude;
                    coordinateText = "Your chosen coordinate is " + String.valueOf(mlatitude) + ',' + String.valueOf(mlatitude);
                    locationData.setText(coordinateText);
                    return true;
                } else {
                    return false;
                }
            }
        });

        // For zooming automatically to the Dropped PIN Location
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(posCor, 12.0f));
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        if (mMap != null)
            setUpMap();

        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            //mMap = ((MapFragment) self.getFragmentManager().findFragmentById(R.id.map)).getMap();// getMap is deprecated
            mMap = getMapFragment().getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null)
                setUpMap();
        }
    }

    /**** The mapfragment's id must be removed from the FragmentManager
     **** or else if the same it is passed on the next time then
     **** app will crash ****/
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mMap != null) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.map)).commit();
            } else {
                getChildFragmentManager().beginTransaction().remove(getChildFragmentManager().findFragmentById(R.id.map)).commit();
            }

            mMap = null;
        }
    }
}