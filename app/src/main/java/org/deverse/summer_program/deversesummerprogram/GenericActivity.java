package org.deverse.summer_program.deversesummerprogram;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class GenericActivity extends Activity {

    // http://www.learn-android-easily.com/2013/06/datepicker-and-timepicker-dialog-in.html
    Button selectDateButton;
    Button selectTimeButton;

    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID=1;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        // get the references of buttons
        selectDateButton=(Button)findViewById(R.id.buttonSelectDate);
        selectTimeButton=(Button)findViewById(R.id.buttonSelectTime);

        // Set ClickListener on btnSelectDate
        selectDateButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Show the DatePickerDialog
                showDialog(DATE_DIALOG_ID);
            }
        });

        // Set ClickListener on btnSelectTime
        selectTimeButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Show the TimePickerDialog
                showDialog(TIME_DIALOG_ID);
            }
        });


    }

    // Register  DatePickerDialog listener
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                // the callback received when the user "sets" the Date in the DatePickerDialog
                public void onDateSet(DatePicker view, int yearSelected,
                                      int monthOfYear, int dayOfMonth) {
                    year = yearSelected;
                    month = monthOfYear;
                    day = dayOfMonth;
                    // Set the Selected Date in Select date Button
                    selectDateButton.setText("Date selected : "+day+"-"+month+"-"+year);
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
                    selectTimeButton.setText("Time selected :"+hour+"-"+minute);
                }
            };


    // Method automatically gets Called when you call showDialog()  method
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // create a new DatePickerDialog with values you want to show
                return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);
            // create a new TimePickerDialog with values you want to show
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this,
                        mTimeSetListener, mHour, mMinute, false);

        }
        return null;
    }


}
