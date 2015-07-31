package org.deverse.summer_program.deversesummerprogram;

import android.app.Activity;
import android.widget.TextView;

import java.util.HashMap;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by amruss on 7/30/2015.
 */

public class ListViewAdapter extends BaseAdapter {


    public static final String FIRST_COLUMN = "Date";
    public static final String SECOND_COLUMN = "Location";
    public static final String THIRD_COLUMN = "Volunteer Hours";
    // List contains rows of data stored in hashMaps
    public ArrayList<HashMap<String, String>> dataList;
    Activity activity;
    TextView shift_date;
    TextView shift_location;
    TextView shift_hours;
    public ListViewAdapter(Activity activity, ArrayList<HashMap<String, String>> list) {
        super();
        this.activity = activity;
        this.dataList = list;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        if (view == null) {
            view = inflater.inflate(R.layout.shifts_list, null);
            shift_date = (TextView) view.findViewById(R.id.shift_date);
            shift_location = (TextView) view.findViewById(R.id.shift_location);
            shift_hours = (TextView) view.findViewById(R.id.shift_hours);
        }
        // Fetch data for a row from the hashMap and plug data into three textViews (list columns)
        HashMap<String, String> dataRow = dataList.get(i);
        shift_date.setText(dataRow.get(FIRST_COLUMN));
        shift_location.setText(dataRow.get(SECOND_COLUMN));
        shift_hours.setText(dataRow.get(THIRD_COLUMN));
        return view;
    }
}