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
import android.widget.TextView;


public class HomeView_Activity extends Activity {

    // Declare our variables up here so that they're globally accessible.
    ParseAPI backend;
    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view_);

        // Get all the views
        logout = (TextView) findViewById(R.id.log_out);

        String logout_Text = new String("Logout");
        SpannableString content = new SpannableString(logout_Text);
        content.setSpan(new UnderlineSpan(), 0, logout_Text.length(), 0);
        logout.setText(content);

        // Create intents for going to other pages
        final Intent goToMainActivity = new Intent(this, MainActivity.class);

        // OnClickListeners for each clickable text or button
        View.OnClickListener logoutClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backend.logoutCurrentUser();
                startActivity(goToMainActivity);
            }
        };

        // Set the OnClickListeners
        logout.setOnClickListener(logoutClick);
    }
}
