package org.deverse.summer_program.deversesummerprogram;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by aluh on 8/7/2015.
 */
public class FragmentEventsTab extends Fragment {

    ListView volunteerHistory;
    ListView upcomingShifts;
    private static final String FIRST_COLUMN = "Date";
    private static final String SECOND_COLUMN ="Time";
    private static final String THIRD_COLUMN = "Site";
    private ArrayList<HashMap<String, String>> myVolunteerHistory;
    private ArrayList<HashMap<String, String>> myUpcomingShifts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events_tab, container, false);

        volunteerHistory=(ListView) rootView.findViewById(R.id.volunteer_history_list);
        upcomingShifts=(ListView) rootView.findViewById(R.id.upcoming_shifts_list);

        myVolunteerHistory = new ArrayList<>();
        myUpcomingShifts = new ArrayList<>();

        populateHistory();
        populateUpcoming();

        // Create custom adapter for the listViews
        ProfileListViewAdapter historyAdapter = new ProfileListViewAdapter(this.getActivity(), myVolunteerHistory);
        ProfileListViewAdapter upcomingAdapter = new ProfileListViewAdapter(this.getActivity(), myUpcomingShifts);

        // Assign the adapter to the listViews
        volunteerHistory.setAdapter(historyAdapter);
        upcomingShifts.setAdapter(upcomingAdapter);

        return rootView;
    }

    public void populateHistory() {
        HashMap<String,String> row1 = new HashMap<>();
        row1.put(FIRST_COLUMN, "05/15/2015");
        row1.put(SECOND_COLUMN, "2");
        row1.put(THIRD_COLUMN, "Beacon Street Site");
        myVolunteerHistory.add(row1);

        HashMap<String,String> row2 = new HashMap<>();
        row2.put(FIRST_COLUMN, "05/26/2015");
        row2.put(SECOND_COLUMN, "4");
        row2.put(THIRD_COLUMN, "Central Square Site");
        myVolunteerHistory.add(row2);

        HashMap<String,String> row3 = new HashMap<>();
        row3.put(FIRST_COLUMN, "06/15/2015");
        row3.put(SECOND_COLUMN, "3");
        row3.put(THIRD_COLUMN, "Beacon Street Site");
        myVolunteerHistory.add(row3);

        HashMap<String,String> row4 = new HashMap<>();
        row4.put(FIRST_COLUMN, "06/19/2015");
        row4.put(SECOND_COLUMN, "1");
        row4.put(THIRD_COLUMN, "Boston Common Site");
        myVolunteerHistory.add(row4);
    }

    public void populateUpcoming() {
        HashMap<String,String> row1 = new HashMap<>();
        row1.put(FIRST_COLUMN, "08/15/2015");
        row1.put(SECOND_COLUMN, "2:00 - 4:00");
        row1.put(THIRD_COLUMN, "Beacon Street Site");
        myUpcomingShifts.add(row1);

        HashMap<String,String> row2 = new HashMap<>();
        row2.put(FIRST_COLUMN, "08/26/2015");
        row2.put(SECOND_COLUMN, "3:00 - 7:00");
        row2.put(THIRD_COLUMN, "Central Square Site");
        myUpcomingShifts.add(row2);

        HashMap<String,String> row3 = new HashMap<>();
        row3.put(FIRST_COLUMN, "09/15/2015");
        row3.put(SECOND_COLUMN, "2:00 - 5:00");
        row3.put(THIRD_COLUMN, "Beacon Street Site");
        myUpcomingShifts.add(row3);

        HashMap<String,String> row4 = new HashMap<>();
        row4.put(FIRST_COLUMN, "09/19/2015");
        row4.put(SECOND_COLUMN, "3:00 - 4:00");
        row4.put(THIRD_COLUMN, "Beacon Street Site");
        myUpcomingShifts.add(row4);
    }
}
