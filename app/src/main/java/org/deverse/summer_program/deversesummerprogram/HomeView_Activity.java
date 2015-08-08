package org.deverse.summer_program.deversesummerprogram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class HomeView_Activity extends Activity {

    // Declare our variables up here so that they're globally accessible.
    ParseAPI backend;
    TextView logout;
    ImageButton accountButton;
    ImageButton appointmentsButton;
    ImageButton searchButton;
    ImageButton sitesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view_);

        // Get all the views
        logout = (TextView) findViewById(R.id.log_out);
        accountButton = (ImageButton) findViewById(R.id.account_button);
        appointmentsButton = (ImageButton) findViewById(R.id.appointments_button);
        searchButton = (ImageButton) findViewById(R.id.search_button);
        sitesButton = (ImageButton) findViewById(R.id.sites_button);

        // Underline the logout text
        String logout_Text = new String("Logout");
        SpannableString content = new SpannableString(logout_Text);
        content.setSpan(new UnderlineSpan(), 0, logout_Text.length(), 0);
        logout.setText(content);

        // Create intents for going to other pages
        final Intent goToMainActivity = new Intent(this, MainActivity.class);
        final Intent goToProfileView = new Intent(this, UserProfileActivity.class);
        final Intent goToSearchView = new Intent(this, SearchActivity.class);


        // OnClickListeners for each clickable text or button
        View.OnClickListener logoutClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //backend.logoutCurrentUser();
                startActivity(goToMainActivity);
            }
        };

        View.OnClickListener accountClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goToProfileView);
            }
        };

        View.OnClickListener appointmentsClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToProfileView.putExtra("tabSelected", "events");
                startActivity(goToProfileView);
            }
        };

        View.OnClickListener searchClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goToSearchView);
            }
        };

        View.OnClickListener sitesClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSearchView.putExtra("tabSelected", "location");
                startActivity(goToSearchView);
            }
        };

        // Set the OnClickListeners
        logout.setOnClickListener(logoutClick);
        accountButton.setOnClickListener(accountClick);
        appointmentsButton.setOnClickListener(appointmentsClick);
        searchButton.setOnClickListener(searchClick);
        sitesButton.setOnClickListener(sitesClick);
    }
}
