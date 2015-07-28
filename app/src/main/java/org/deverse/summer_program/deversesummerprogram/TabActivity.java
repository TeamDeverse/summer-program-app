package org.deverse.summer_program.deversesummerprogram;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class TabActivity extends FragmentActivity {

    // Declare tab variables
    ActionBar.Tab timeSearch, locationSearch;
    Fragment tabOneFragment = new TabOneFragment();
    Fragment tabTwoFragment = new TabTwoFragment();

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        fragmentManager = getFragmentManager();

        ActionBar actionBar = getActionBar();

        // Hide ActionBar Icon
        actionBar.setDisplayShowHomeEnabled(false);

        // Hide ActionBar Title
        actionBar.setDisplayShowTitleEnabled(false);

        // Create ActionBar Tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set Tab Icon and Titles
        timeSearch = actionBar.newTab().setText("Search by Time");
        locationSearch = actionBar.newTab().setText("Search by Location");

        // Set Tab Listeners
        timeSearch.setTabListener(new TabListener(tabOneFragment));
        locationSearch.setTabListener(new TabListener(tabTwoFragment));

        // Add Tabs to ActionBar
        actionBar.addTab(timeSearch);
        actionBar.addTab(locationSearch);
    }


}