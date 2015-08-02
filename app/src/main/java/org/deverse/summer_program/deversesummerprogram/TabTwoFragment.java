package org.deverse.summer_program.deversesummerprogram;


import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
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

import android.net.Uri;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabTwoFragment extends Fragment {

    private static GoogleMap mMap; // Might be null if Google Play services APK is not available.

    private static Double latitude, longitude, mlatitude, mlongitude;

    private String coordinateText;

    EditText addrText;
    Button mapSearchButton, viewDetailButton;

    TextView locationData;

    private final String TAG = "MapLocation";
    final Activity self = this.getActivity();

    private List<Marker> markerList;

    private final static List<Double> fakeLatList = Arrays.asList(new Double[]{42.3512972, 42.3629523, 42.3493625});
    private final static List<Double> fakeLngList = Arrays.asList(new Double[]{-71.0817463, -71.0686975, -71.0857804});
    private final static List<String> fakeName = Arrays.asList("Boston Common", "MGH", "Pour House");
    private final static List<String> fakeAvai = Arrays.asList("Sept 1, 11-12", "Aug 30, 3-5", "Sept 5, 9-10");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(container == null){
            return null;
        }
        View rootView = inflater.inflate(R.layout.fragment_tab_two, container, false);

        addrText = (EditText) rootView.findViewById(R.id.enter_location);
        mapSearchButton = (Button) rootView.findViewById(R.id.mapButton);

        locationData = (TextView) rootView.findViewById(R.id.coordinates);
        viewDetailButton = (Button) rootView.findViewById(R.id.view_site_info_button);

        mapSearchButton.setOnClickListener(new View.OnClickListener() {

            // Called when user clicks the Show Map button
            public void onClick(View v) {
                try {

                    // Process text for network transmission
                    String address = addrText.getText().toString();
                    address = address.replace(' ', '+');

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

        viewDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Buzzlab
        // TODO: get the current location by GPS
        latitude = 42.350529;
        longitude = -71.099855;

        setUpMapIfNeeded();

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
    private void setUpMap() {

        markerList = new ArrayList<>();
        // For showing a move to my loction button
        mMap.setMyLocationEnabled(true);
        for (int i = 0; i < fakeLatList.size(); i++) {
            final LatLng posCor = new LatLng(fakeLatList.get(i), fakeLngList.get(i));
            Marker currentMarker = mMap.addMarker(new MarkerOptions().position(posCor).
                    title(fakeName.get(i)).snippet(fakeAvai.get(i)));
            currentMarker.setAlpha(Float.parseFloat("0.5"));
            markerList.add(currentMarker);
        }

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Marker marker : markerList) {
            builder.include(marker.getPosition());
        }
        LatLngBounds bounds = builder.build();

        int padding = 100; // offset from edges of the map in pixels
        final CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                mMap.animateCamera(cu);
            }
        });

        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (markerList.contains(marker)) {
//                    mlatitude = marker.getPosition().latitude;
//                    mlongitude = marker.getPosition().longitude;

                    String nameOfSite = marker.getTitle();
                    String availableTime = marker.getSnippet();

//                    coordinateText = "Your chosen coordinate is " + String.valueOf(mlatitude) + ',' + String.valueOf(mlatitude);

                    coordinateText = "Site Name: " + nameOfSite + ", Availability: " + availableTime;
                    locationData.setText(coordinateText);
                    viewDetailButton.setVisibility(View.VISIBLE);
                    return true;
                } else {
                    locationData.setText("No site chosen yet.");
                    viewDetailButton.setVisibility(View.GONE);
                    return false;
                }
            }
        });


    }


    private void refreshMap() {

        mMap.clear();

        // For dropping a marker at a point on the Map
        final LatLng posCor = new LatLng(latitude, longitude);
        Marker currentMarker = mMap.addMarker(new MarkerOptions().position(posCor).title("My Position"));
        currentMarker.setFlat(true);

        setUpMap();
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