package org.deverse.summer_program.deversesummerprogram;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;


public class SiteProfileActivity extends Activity {

    // Declare tab variables
    ActionBar.Tab Detail, Schedule;
    Fragment fragmentDetailTab = new FragmentDetailTab();
    Fragment fragmentScheduleTab = new FragmentScheduleTab();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_profile);

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
