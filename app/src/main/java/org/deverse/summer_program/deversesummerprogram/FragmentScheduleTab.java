package org.deverse.summer_program.deversesummerprogram;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by aluh on 7/22/2015.
 */
public class FragmentScheduleTab extends Fragment {

    CalendarView calendar;
    TextView selectedDate;
    ListView timeSlotList;
    private static final String FIRST_COLUMN = "Date";
    private static final String SECOND_COLUMN = "Time Slot";
    private static final String THIRD_COLUMN = "Volunteers Needed";
    private ArrayList<HashMap<String, String>> dataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_schedule_tab, container, false);

        // Get today's date
        SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
        String today = sdf.format(new Date());

        // All the schedule views
        calendar = (CalendarView) rootView.findViewById(R.id.calendar);
        selectedDate = (TextView) rootView.findViewById(R.id.date_text);
        timeSlotList = (ListView) rootView.findViewById(R.id.time_slot_list);

        // Set the initial selected date to today's date
        selectedDate.setText(today);

        // hide the week number
        calendar.setShowWeekNumber(false);

        // DateChangeListener for the calendarView
        CalendarView.OnDateChangeListener dateChange = new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                month++;
                selectedDate.setText(month + "/" + day + "/" + year);
            }
        };

        // Assign the DatechangeListener to the calendarView
        calendar.setOnDateChangeListener(dateChange);

        dataList = new ArrayList<>();

        // Create and add fake data
        HashMap<String,String> row1 = new HashMap<>();
        row1.put(FIRST_COLUMN, today);
        row1.put(SECOND_COLUMN, "11:00-12:00");
        row1.put(THIRD_COLUMN, "3");
        dataList.add(row1);

        HashMap<String,String> row2 = new HashMap<>();
        row2.put(FIRST_COLUMN, today);
        row2.put(SECOND_COLUMN, "12:00-1:00");
        row2.put(THIRD_COLUMN, "4");
        dataList.add(row2);

        HashMap<String,String> row3 = new HashMap<>();
        row3.put(FIRST_COLUMN, today);
        row3.put(SECOND_COLUMN, "1:00-2:00");
        row3.put(THIRD_COLUMN, "2");
        dataList.add(row3);

        HashMap<String,String> row4 = new HashMap<>();
        row4.put(FIRST_COLUMN, today);
        row4.put(SECOND_COLUMN, "2:00-3:00");
        row4.put(THIRD_COLUMN, "1");
        dataList.add(row4);

        // Create custom adapter for the listView
        ListViewAdapter adapter = new ListViewAdapter(this.getActivity(), dataList);

        // Assign the adapter to the listView
        timeSlotList.setAdapter(adapter);

        return rootView;
    }
}
