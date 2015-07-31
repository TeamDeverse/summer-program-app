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
import android.widget.LinearLayout;
import android.widget.TimePicker;

import java.util.Calendar;

public class TabOneFragment extends Fragment {

    final Activity self = this.getActivity();

    Button dateSelectionButton;
    Button timeSelectionButton;
    Button searchButton;

    LinearLayout calendarLinearLayout;
    LinearLayout timepickerLinearLayout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_tab_one, container, false);

        dateSelectionButton=(Button)rootView.findViewById(R.id.buttonSelectDate);
        timeSelectionButton=(Button)rootView.findViewById(R.id.buttonSelectTime);
        searchButton=(Button)rootView.findViewById(R.id.buttonSearchDateTime);

        calendarLinearLayout = (LinearLayout) rootView.findViewById(R.id.calendar_linearLayout);
        timepickerLinearLayout = (LinearLayout) rootView.findViewById(R.id.timepicker_linearLayout);

        // Set ClickListener on btnSelectDate
        dateSelectionButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (timepickerLinearLayout.getVisibility()==View.VISIBLE){
                    timepickerLinearLayout.setVisibility(View.GONE);
                }
                if (calendarLinearLayout.getVisibility() == View.VISIBLE){
                    calendarLinearLayout.setVisibility(View.GONE);
                } else {
                    calendarLinearLayout.setVisibility(View.VISIBLE);
                }

            }
        });

        // Set ClickListener on btnSelectTime
        timeSelectionButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (calendarLinearLayout.getVisibility()==View.VISIBLE){
                    calendarLinearLayout.setVisibility(View.GONE);
                }
                if (timepickerLinearLayout.getVisibility() == View.VISIBLE){
                    timepickerLinearLayout.setVisibility(View.GONE);
                } else {
                    timepickerLinearLayout.setVisibility(View.VISIBLE);
                }
            }
        });



        return rootView;
    }








}