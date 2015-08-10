package org.deverse.summer_program.deversesummerprogram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by aluh on 8/7/2015.
 */
public class ProfileListViewAdapter extends BaseAdapter {

    private static final String FIRST_COLUMN = "Date";
    private static final String SECOND_COLUMN = "Time";
    private static final String THIRD_COLUMN = "Site";

    // List contains rows of data stored in hashMaps
    public ArrayList<HashMap<String, String>> dataList;
    Activity activity;
    TextView shiftDate;
    TextView shiftTime;
    TextView shiftSite;

    public ProfileListViewAdapter(Activity activity, ArrayList<HashMap<String, String>> list) {
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
            view = inflater.inflate(R.layout.shifts_list_row, null);
            shiftDate = (TextView) view.findViewById(R.id.shift_date);
            shiftTime = (TextView) view.findViewById(R.id.shift_time);
            shiftSite = (TextView) view.findViewById(R.id.shift_site);
        }

        // Fetch data for a row from the hashMap and plug data into three textViews (list columns)
        HashMap<String, String> dataRow = dataList.get(i);
        shiftDate.setText(dataRow.get(FIRST_COLUMN));
        shiftTime.setText(dataRow.get(SECOND_COLUMN));
        shiftSite.setText(dataRow.get(THIRD_COLUMN));

        return view;
    }

}
