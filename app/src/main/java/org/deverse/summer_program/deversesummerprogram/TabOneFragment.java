package org.deverse.summer_program.deversesummerprogram;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class TabOneFragment extends Fragment {

    final Activity self = this.getActivity();

    Button dateSelectionButton;
    Button timeSelectionButton;
    Button searchButton;


    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID = 1;
    // variables to save user selected date and time
    public  int year,month,day,hour,minute;
    public  int yearSelected,monthSelected,daySelected,hourSelected,minuteSelected;

    // declare  the variables to show the date and time whenTime and Date Picker Dialog first appears
    private int mYear, mMonth, mDay,mHour,mMinute;

    public void DateAndTimePickerActivity()
    {
        // Assign current Date and Time Values to Variables
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_tab_one, container, false);

        dateSelectionButton=(Button)rootView.findViewById(R.id.buttonSelectDate);
        timeSelectionButton=(Button)rootView.findViewById(R.id.buttonSelectTime);
        searchButton=(Button)rootView.findViewById(R.id.buttonSearchDateTime);

        // Set ClickListener on btnSelectDate
        dateSelectionButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Show the DatePickerDialog
                self.showDialog(DATE_DIALOG_ID);
            }
        });

        // Set ClickListener on btnSelectTime
        timeSelectionButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Show the TimePickerDialog
                self.showDialog(TIME_DIALOG_ID);
            }
        });



        return rootView;
    }



    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                // the callback received when the user "sets" the Date in the DatePickerDialog
                public void onDateSet(DatePicker view, int yearSelected,
                                      int monthOfYear, int dayOfMonth) {
                    year = yearSelected;
                    month = monthOfYear;
                    day = dayOfMonth;
                    // Set the Selected Date in Select date Button
                    dateSelectionButton.setText("Date selected : "+day+"-"+month+"-"+year);
                }
            };

    // Register  TimePickerDialog listener
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                // the callback received when the user "sets" the TimePickerDialog in the dialog
                public void onTimeSet(TimePicker view, int hourOfDay, int min) {
                    hour = hourOfDay;
                    minute = min;
                    // Set the Selected Date in Select date Button
                    timeSelectionButton.setText("Time selected :"+hour+"-"+minute);
                }
            };




}