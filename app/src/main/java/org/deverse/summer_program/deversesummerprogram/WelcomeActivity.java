package org.deverse.summer_program.deversesummerprogram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class WelcomeActivity extends Activity {

    TextView helloText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Find views in XML
        helloText = (TextView) findViewById(R.id.hello_text);

        // Get the username from the intent
        Intent fromMainActivity = getIntent();
        String username = fromMainActivity.getStringExtra("username");
        helloText.setText("Welcome back, " + username);

    }
}
