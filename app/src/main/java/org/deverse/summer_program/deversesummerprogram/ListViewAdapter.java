package org.deverse.summer_program.deversesummerprogram;

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
 * Created by aluh on 7/26/2015.
 */
public class ListViewAdapter extends BaseAdapter {

    public static final String FIRST_COLUMN = "Date";
    public static final String SECOND_COLUMN = "Time Slot";
    public static final String THIRD_COLUMN = "Volunteers Needed";

    // List contains rows of data stored in hashMaps
    public ArrayList<HashMap<String, String>> dataList;
    Activity activity;
    TextView date;
    TextView timeSlot;
    TextView volunteersNeeded;

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
            view = inflater.inflate(R.layout.time_slot_row, null);
            date = (TextView) view.findViewById(R.id.date);
            timeSlot = (TextView) view.findViewById(R.id.time_slot);
            volunteersNeeded = (TextView) view.findViewById(R.id.volunteers_needed);
        }

        // Fetch data for a row from the hashMap and plug data into three textViews (list columns)
        HashMap<String, String> dataRow = dataList.get(i);
        date.setText(dataRow.get(FIRST_COLUMN));
        timeSlot.setText(dataRow.get(SECOND_COLUMN));
        volunteersNeeded.setText(dataRow.get(THIRD_COLUMN));

        return view;
    }
}
