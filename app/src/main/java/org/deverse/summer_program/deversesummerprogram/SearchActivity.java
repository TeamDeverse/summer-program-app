package org.deverse.summer_program.deversesummerprogram;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

/**
 * Created by aluh on 8/2/2015.
 */
public class SearchActivity extends FragmentActivity {

    // Declare tab variables
    ActionBar.Tab timeSearch, locationSearch;
    Fragment tabOneFragment = new SearchTimeTab();
    Fragment tabTwoFragment = new SearchLocationTab();

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

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
        timeSearch.setTabListener(new SearchTabListener(tabOneFragment));
        locationSearch.setTabListener(new SearchTabListener(tabTwoFragment));

        // Add Tabs to ActionBar
        actionBar.addTab(timeSearch);
        actionBar.addTab(locationSearch);

        // Get which tab is selected from the intent
        Intent fromHomeView = getIntent();
        String tabSelected = fromHomeView.getStringExtra("tabSelected");
        int tabPosition = 0;
        if (tabSelected != null && tabSelected.equals("location")) {
            tabPosition = 1;
        }

        actionBar.setSelectedNavigationItem(tabPosition);

    }
}