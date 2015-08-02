package org.deverse.summer_program.deversesummerprogram;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;


public class SearchTabListener implements ActionBar.TabListener {

    Fragment fragment;

    public SearchTabListener(Fragment fragment) {
        // constructor
        this.fragment = fragment;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.replace(R.id.fragment_container, fragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.remove(fragment);
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}