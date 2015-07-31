package org.deverse.summer_program.deversesummerprogram;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileScheduleFragment extends Fragment {
    ListView VolunteerHistory;
    ListView UpcomingShifts;
    private static final String FIRST_COLUMN = "Volunteer Date";
    private static final String SECOND_COLUMN ="Volunteer Site";
    private static final String THIRD_COLUMN = "Volunteer Hours";
    private ArrayList<HashMap<String, String>> myVolunteerHistory;
    private ArrayList<HashMap<String, String>> myUpcomingShifts;
    //private List<Shifts> myVolunteerHistory = new ArrayList<Shifts>();
    //private List<Shifts> myUpcomingShifts = new ArrayList<Shifts>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profileview_schedule, container, false);

        VolunteerHistory=(ListView) rootView.findViewById(R.id.profileview_volunteerhistory);
        UpcomingShifts=(ListView) rootView.findViewById(R.id.profileview_upcomingshifts);

        myVolunteerHistory=new ArrayList<>();
        myUpcomingShifts=new ArrayList<>();






        //populateListView();
        //populateListView2();

        populatelist1();
        populatelist2();
        return rootView;
    }

    public void populatelist1(){
        HashMap<String,String> row1 = new HashMap<>();
        row1.put(FIRST_COLUMN, "05/15/2015");
        row1.put(SECOND_COLUMN, "Beacon Street Site");
        row1.put(THIRD_COLUMN, "2");
        myVolunteerHistory.add(row1);

        HashMap<String,String> row2 = new HashMap<>();
        row2.put(FIRST_COLUMN, "05/26/2015");
        row2.put(SECOND_COLUMN, "Central Square Site");
        row2.put(THIRD_COLUMN, "4");
        myVolunteerHistory.add(row2);

        HashMap<String,String> row3 = new HashMap<>();
        row3.put(FIRST_COLUMN, "06/15/2015");
        row3.put(SECOND_COLUMN, "Beacon Street Site");
        row3.put(THIRD_COLUMN, "3");
        myVolunteerHistory.add(row3);

        HashMap<String,String> row4 = new HashMap<>();
        row4.put(FIRST_COLUMN, "06/19/2015");
        row4.put(SECOND_COLUMN, "Beacon Street Site");
        row4.put(THIRD_COLUMN, "2");
        myVolunteerHistory.add(row4);

        ListViewAdapter adapter = new ListViewAdapter(this.getActivity(), myVolunteerHistory);

        VolunteerHistory.setAdapter(adapter);
    }
    public  void populatelist2(){
        HashMap<String,String> row1 = new HashMap<>();
        row1.put(FIRST_COLUMN, "08/15/2015");
        row1.put(SECOND_COLUMN, "Beacon Street Site");
        row1.put(THIRD_COLUMN, "3");
        myUpcomingShifts.add(row1);

        HashMap<String,String> row2 = new HashMap<>();
        row2.put(FIRST_COLUMN, "08/26/2015");
        row2.put(SECOND_COLUMN, "Central Square Site");
        row2.put(THIRD_COLUMN, "4");
        myUpcomingShifts.add(row2);

        HashMap<String,String> row3 = new HashMap<>();
        row3.put(FIRST_COLUMN, "09/15/2015");
        row3.put(SECOND_COLUMN, "Beacon Street Site");
        row3.put(THIRD_COLUMN, "3");
        myUpcomingShifts.add(row3);

        HashMap<String,String> row4 = new HashMap<>();
        row4.put(FIRST_COLUMN, "09/19/2015");
        row4.put(SECOND_COLUMN, "Beacon Street Site");
        row4.put(THIRD_COLUMN, "5");
        myUpcomingShifts.add(row4);

        ListViewAdapter adapter = new ListViewAdapter(this.getActivity(), myUpcomingShifts);

        UpcomingShifts.setAdapter(adapter);
    }
    /*private void populateListView() {
        //Creat list of items
        myVolunteerHistory.add(new Shifts("06/15/15","Beacon Street Site", 15));
        myVolunteerHistory.add(new Shifts("06/20/15","Beacon Street Site", 1));
        myVolunteerHistory.add(new Shifts("06/22/15","Beacon Street Site", 5));
        myVolunteerHistory.add(new Shifts("06/30/15","Beacon Street Site", 2));
        //Build Adapter
        ArrayAdapter<Shifts> adapter= new MyListAdapter();
                //ArrayAdapter<String>(this.getActivity(), R.layout.shifts_list,myVolunteerHistory);

        //Configure Listview
        VolunteerHistory.setAdapter(adapter);
    }


    private void populateListView2() {
        //Creat list of items
        myUpcomingShifts.add(new Shifts("08/02/15","Beacon Street Site", 2));
        myUpcomingShifts.add(new Shifts("08/10/15","Beacon Street Site", 4));
        myUpcomingShifts.add(new Shifts("08/15/15","Beacon Street Site", 2));
        myUpcomingShifts.add(new Shifts("08/23/15","Beacon Street Site", 3));

        //Build Adapter
        //ArrayAdapter<String> adapter= new ArrayAdapter<String>(this.getActivity(), R.layout.shifts_list, myUpcomingShifts);
        ArrayAdapter<Shifts> adapter= new MyListAdapter2();
        //Configure Listview
        UpcomingShifts.setAdapter(adapter);
    }
    private class MyListAdapter extends ArrayAdapter<Shifts>{
        public MyListAdapter(){
            super(ProfileScheduleFragment.this.getActivity(), R.layout.shifts_list,myVolunteerHistory);
        }

    }
    private class MyListAdapter2 extends ArrayAdapter<Shifts>{
        public MyListAdapter2(){
            super(ProfileScheduleFragment.this.getActivity(),R.layout.shifts_list,myUpcomingShifts);
        }
    }*/

}