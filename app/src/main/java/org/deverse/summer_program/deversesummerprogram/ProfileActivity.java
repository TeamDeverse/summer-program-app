package org.deverse.summer_program.deversesummerprogram;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;


public class ProfileActivity extends Activity {

    // Declare tab variables
    ActionBar.Tab TabOne, TabTwo;
    Fragment tabOneFragment = new ProfileViewFragment();
    Fragment tabTwoFragment = new ProfileScheduleFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        ActionBar actionBar = getActionBar();

        // Hide ActionBar Icon
        actionBar.setDisplayShowHomeEnabled(false);

        // Hide ActionBar Title
        actionBar.setDisplayShowTitleEnabled(false);

        // Create ActionBar Tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set Tab Icon and Titles
        TabOne = actionBar.newTab().setText("Profile");
        TabTwo = actionBar.newTab().setText("Schedule");

        // Set Tab Listeners
        TabOne.setTabListener(new TabListener(tabOneFragment));
        TabTwo.setTabListener(new TabListener(tabTwoFragment));

        // Add Tabs to ActionBar
        actionBar.addTab(TabOne);
        actionBar.addTab(TabTwo);
    }
}