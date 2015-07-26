package org.deverse.summer_program.deversesummerprogram;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

/**
 * Created by aluh on 7/22/2015.
 */
public class FragmentScheduleTab extends Fragment {

    CalendarView calendar;
    TextView selectedDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_schedule_tab, container, false);

        // All the schedule views
        calendar = (CalendarView) rootView.findViewById(R.id.calendar);
        selectedDate = (TextView) rootView.findViewById(R.id.date_text);

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

        return rootView;
    }
}
