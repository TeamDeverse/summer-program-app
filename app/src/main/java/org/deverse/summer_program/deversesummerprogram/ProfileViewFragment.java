package org.deverse.summer_program.deversesummerprogram;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class ProfileViewFragment extends Fragment {
    TextView tabOneTextView;

    private ProgressBar progressBar;
    private int progressStatus = 0;
    TextView Profile_username;
    TextView Profile_email;
    TextView Profile_PhoneNumber;
    int x = 0;

    private List<String> myBadges2 = new ArrayList<String>();


    //private Handler handler = new Handler();
    //private int x = 0;
    ListView badgesList;
    //int y = 5;

    //public ArrayList<String> Badges;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);
        super.onCreate(savedInstanceState);


        Profile_username = (TextView) rootView.findViewById(R.id.profile_username);
        Profile_email = (TextView) rootView.findViewById(R.id.profile_email);
        Profile_PhoneNumber = (TextView) rootView.findViewById(R.id.profile_phone_number);
        badgesList = (ListView) rootView.findViewById(R.id.profile_list);

        //if (y >0){
        //  Badges.add("Badge" + y);
        //y-=1;}./**/l/
        if (x ==0){
            populateListView();}
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), R.layout.layout_textview, myBadges2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), R.layout.layout_textview, myBadges2);

        badgesList.setAdapter(adapter);
        return rootView;
    }

    private void populateListView() {
        //Creat list of items
        myBadges2.add("First Volunteer Shift!");
        myBadges2.add("10 hours of volunteering");
        myBadges2.add("Volunteering Pro");
        myBadges2.add("Sup");


        x+=1;
    }
}
        /*myBadges.add(new Badges("First Shift", R.drawable.badge_icon));
        myBadges.add(new Badges("10 hours!", R.drawable.badge_icon));
        myBadges.add(new Badges("10 shifts", R.drawable.badge_icon));
        myBadges.add(new Badges("Tax Expert", R.drawable.badge_icon));

        //Build Adapter
        //ArrayAdapter<String> adapter= new ArrayAdapter<String>(this.getActivity(), R.layout.layout_textview,Badges2);
        ArrayAdapter<Badges> adapter = new MyListAdapter();
        //Configu re Listview
        //badgesList.setAdapter(adapter);
    }


    //private class MyListAdapter extends ArrayAdapter<Badges> {
        //public MyListAdapter() {
            //super(ProfileViewFragment.this.getActivity(), R.layout.image_list, myBadges);
        }





    }
    //ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Badges);
    //badgeslist.setAdapter(adapter);


    //progressBar = (ProgressBar) findViewById(R.id.profile_ProgressBar);
    //textView = (TextView) findViewById(R.id.profile_ProgressMessage);
    //if (x > 1){
    //progressStatus+=1;}
    //while (progressStatus > 0){
    //progressBar.setProgress(progressStatus);
*/


