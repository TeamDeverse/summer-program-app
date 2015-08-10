package org.deverse.summer_program.deversesummerprogram;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluh on 8/7/2015.
 */
public class FragmentProfileTab extends Fragment {

    private List<String> myBadges = new ArrayList<String>();
    ListView userBadgeList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile_tab, container, false);

        // Get profile views
        userBadgeList = (ListView) rootView.findViewById(R.id.profile_badge_list);

        populateListView();

        // ArrayAdapter to supply row views to the list view of badges
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), R.layout.badge_list_item, myBadges);

        // Assign the adapter to the list view of badges
        userBadgeList.setAdapter(adapter);

        return rootView;
    }

    private void populateListView() {
        // Create fake list of badges
        myBadges.clear();
        myBadges.add("First Volunteer Shift");
        myBadges.add("Volunteered 10 Hours");
        myBadges.add("Volunteered 20 Hours");
        myBadges.add("Super Volunteer");
        myBadges.add("Volunteered 30 Hours");
        myBadges.add("Volunteered 40 Hours");
    }

}
