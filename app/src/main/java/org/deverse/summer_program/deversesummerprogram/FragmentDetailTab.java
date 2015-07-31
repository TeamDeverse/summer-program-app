package org.deverse.summer_program.deversesummerprogram;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by aluh on 7/22/2015.
 */
public class FragmentDetailTab extends Fragment {

    private static GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private static double latitude, longitude;
    final Activity thisActivity = this.getActivity();

    Button locationButton;
    LinearLayout locationLayout;
    Button contactButton;
    LinearLayout contactLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail_tab, container, false);

        // All the site location views
        locationButton = (Button) rootView.findViewById(R.id.site_location_button);
        locationLayout = (LinearLayout) rootView.findViewById(R.id.site_location);

        // All the site contact views
        contactButton = (Button) rootView.findViewById(R.id.site_contact_button);
        contactLayout = (LinearLayout) rootView.findViewById(R.id.site_contact_info);

        // ClickListeners for each button
        View.OnClickListener locationClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contactLayout.getVisibility() == View.VISIBLE) {
                    contactLayout.setVisibility(View.GONE);
                }
                if (locationLayout.getVisibility() == View.VISIBLE) {
                    locationLayout.setVisibility(View.GONE);
                } else {
                    locationLayout.setVisibility(View.VISIBLE);
                }
            }
        };

        View.OnClickListener contactClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (locationLayout.getVisibility() == View.VISIBLE) {
                    locationLayout.setVisibility(View.GONE);
                }
                if (contactLayout.getVisibility() == View.VISIBLE) {
                    contactLayout.setVisibility(View.GONE);
                } else {
                    contactLayout.setVisibility(View.VISIBLE);
                }
            }
        };

        // Assign the click listener for each button
        locationButton.setOnClickListener(locationClick);
        contactButton.setOnClickListener(contactClick);

        // Washington DC
        latitude = 38.889;
        longitude = -77.0352;

        // Set up the map
        setUpMapIfNeeded();

        return rootView;
    }

    private MapFragment getMapFragment() {
        FragmentManager fm = null;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            fm = getFragmentManager();
        } else {
            fm = getChildFragmentManager();
        }

        return (MapFragment) fm.findFragmentById(R.id.site_map);
    }

    /***** Sets up the map if it is possible to do so *****/
    public void setUpMapIfNeeded() {

        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            //mMap = ((MapFragment) self.getFragmentManager().findFragmentById(R.id.map)).getMap();

            mMap = getMapFragment().getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the
     * camera.
     * <p>
     * This should only be called once and when we are sure that {@link #mMap}
     * is not null.
     */
    private static void setUpMap() {
        // For showing a move to my loction button
        mMap.setMyLocationEnabled(true);
        // For dropping a marker at a point on the Map
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("My Home").snippet("Home Address"));
        // For zooming automatically to the Dropped PIN Location
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude,
                longitude), 12.0f));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (mMap != null)
            setUpMap();

        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            //mMap = ((MapFragment) self.getFragmentManager().findFragmentById(R.id.map)).getMap();// getMap is deprecated
            mMap = getMapFragment().getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**** The MapFragment's id must be removed from the FragmentManager
     **** or else if the same it is passed on the next time then
     **** app will crash ****/
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mMap != null) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.site_map)).commit();
            } else {
                getChildFragmentManager().beginTransaction().remove(getChildFragmentManager().findFragmentById(R.id.site_map)).commit();
            }

            mMap = null;
        }
    }
}
