package org.deverse.summer_program.deversesummerprogram;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by aluh on 7/22/2015.
 */
public class FragmentDetailTab extends Fragment {

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

        return rootView;
    }
}
