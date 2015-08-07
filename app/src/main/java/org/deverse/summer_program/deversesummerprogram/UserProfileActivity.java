package org.deverse.summer_program.deversesummerprogram;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;


public class UserProfileActivity extends FragmentActivity {

    // Declare tab variables
    ActionBar.Tab Profile, Events;
    Fragment fragmentProfileTab = new FragmentProfileTab();
    Fragment fragmentEventsTab = new FragmentEventsTab();
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        fragmentManager = getFragmentManager();

        ActionBar actionBar = getActionBar();

        // Hide ActionBar Icon
        actionBar.setDisplayShowHomeEnabled(false);

        // Hide ActionBar Title
        actionBar.setDisplayShowTitleEnabled(false);

        // Create ActionBar Tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set Tab Icon and Titles
        Profile = actionBar.newTab().setText("Profile");
        Events = actionBar.newTab().setText("Events");

        // Set Tab Listeners
        Profile.setTabListener(new TabListener(fragmentProfileTab));
        Events.setTabListener(new TabListener(fragmentEventsTab));

        // Add Tabs to ActionBar
        actionBar.addTab(Profile);
        actionBar.addTab(Events);
    }
}
