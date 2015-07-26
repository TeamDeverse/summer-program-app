package org.deverse.summer_program.deversesummerprogram;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class TabActivity extends Activity {

    // Declare tab variables
    ActionBar.Tab Detail, Schedule;
    Fragment tabOneFragment = new TabOneFragment();
    Fragment tabTwoFragment = new TabTwoFragment();

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
        Detail = actionBar.newTab().setText("Tab 1");
        Schedule = actionBar.newTab().setText("Tab 2");

        // Set Tab Listeners
        Detail.setTabListener(new TabListener(tabOneFragment));
        Schedule.setTabListener(new TabListener(tabTwoFragment));

        // Add Tabs to ActionBar
        actionBar.addTab(Detail);
        actionBar.addTab(Schedule);
    }
}