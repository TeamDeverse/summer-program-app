package org.deverse.summer_program.deversesummerprogram;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class SiteProfileActivity extends FragmentActivity {

    // Declare tab variables
    ActionBar.Tab Detail, Schedule;
    Fragment fragmentDetailTab = new FragmentDetailTab();
    Fragment fragmentScheduleTab = new FragmentScheduleTab();
    //String siteId;
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_profile);

        // Temporary, used for testing
        //siteId = "8BsaxGFW1Q";

        fragmentManager = getFragmentManager();

        ActionBar actionBar = getActionBar();

        // Hide ActionBar Icon
        actionBar.setDisplayShowHomeEnabled(false);

        // Hide ActionBar Title
        actionBar.setDisplayShowTitleEnabled(false);

        // Create ActionBar Tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set Tab Icon and Titles
        Detail = actionBar.newTab().setText("Details");
        Schedule = actionBar.newTab().setText("Schedule");

        // Set Tab Listeners
        Detail.setTabListener(new TabListener(fragmentDetailTab));
        Schedule.setTabListener(new TabListener(fragmentScheduleTab));

        // Add Tabs to ActionBar
        actionBar.addTab(Detail);
        actionBar.addTab(Schedule);
    }
}