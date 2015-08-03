package org.deverse.summer_program.deversesummerprogram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class WelcomeActivity extends Activity {

    TextView helloText;
    Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        helloText = (TextView) findViewById(R.id.hello_text);
        homeButton = (Button) findViewById(R.id.home_button);

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

    }
}
