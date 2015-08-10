package org.deverse.summer_program.deversesummerprogram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class WelcomeActivity extends Activity {

    TextView helloText;
    Button homeButton;
    ListView badgeList;
    private List<String> userBadges = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        helloText = (TextView) findViewById(R.id.hello_text);
        homeButton = (Button) findViewById(R.id.home_button);
        badgeList = (ListView) findViewById(R.id.badge_list);

        final Intent goToHomeViewActivity = new Intent(this, HomeView_Activity.class);

        // Get the username from the intent
        Intent fromMainActivity = getIntent();
        String username = fromMainActivity.getStringExtra("username");
        helloText.setText("Welcome back, " + username);

        // ClickListeners for each button
        View.OnClickListener homeClick = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(goToHomeViewActivity);
            }
        };

        // Assign the click listener for each button
        homeButton.setOnClickListener(homeClick);

        populateListView();

        // ArrayAdapter to supply row views to the list view of badges
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.badge_list_item, userBadges);

        // Assign the adapter to the list view of badges
        badgeList.setAdapter(adapter);

    }

    private void populateListView() {
        // Create fake list of badges
        userBadges.add("First Volunteer Shift");
        userBadges.add("Volunteered 10 Hours");
        userBadges.add("Volunteered 20 Hours");
        userBadges.add("Super Volunteer");
    }
}
