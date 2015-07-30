package org.deverse.summer_program.deversesummerprogram;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HomeView_Activity extends Activity {

    // Declare our variables up here so that they're globally accessible.
    ParseAPI backend;
    TextView logout;
    Button accountButton;
    Button appointmentsButton;
    Button searchButton;
    Button sitesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view_);

        // Get all the views
        logout = (TextView) findViewById(R.id.log_out);
        accountButton = (Button) findViewById(R.id.Account_button);
        appointmentsButton = (Button) findViewById(R.id.Appointment_button);
        searchButton = (Button) findViewById(R.id.Search_button);
        sitesButton = (Button) findViewById(R.id.Sites_button);

        String logout_Text = new String("Logout");
        SpannableString content = new SpannableString(logout_Text);
        content.setSpan(new UnderlineSpan(), 0, logout_Text.length(), 0);
        logout.setText(content);

        // Create intents for going to other pages
        final Intent goToMainActivity = new Intent(this, MainActivity.class);
        // Two of the buttons (Account and Appointments) take the user to different tabs
        //     in the ProfileActivity. Do we need two separate intents that go straight to the
        //     correct tab? Perhaps code in ProfileActivity.java can distinguish the intents
        //     and choose which tap is displayed
        final Intent goToProfileView = new Intent(this, ProfileActivity.class);
        final Intent goToAppointmentsView = new Intent(this, ProfileActivity.class);
        // Same deal with two buttons leading to different tabs in SearchFiltering
        final Intent goToAvailabilitySearch = new Intent(this, SearchFilteringActivity.class);
        final Intent goToLocationSearch = new Intent(this, SearchFilteringActivity.class);


        // OnClickListeners for each clickable text or button
        View.OnClickListener logoutClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backend.logoutCurrentUser();
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
                startActivity(goToAppointmentsView);
            }
        };

        View.OnClickListener searchClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goToAvailabilitySearch);
            }
        };

        View.OnClickListener sitesClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goToLocationSearch);
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
