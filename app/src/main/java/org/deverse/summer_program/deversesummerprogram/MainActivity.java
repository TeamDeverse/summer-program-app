package org.deverse.summer_program.deversesummerprogram;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import org.deverse.summer_program.deversesummerprogram.ParseAPI;


public class MainActivity extends Activity {

    // Declare our variables up here so that they're globally accessible. We'll define them later
    ImageView falloutImage;
    Button mainButton;
    ParseAPI parse;

    // The onCreate method is the first method that runs when the app starts up. It's like Java's
    // main() method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parse = new ParseAPI(this);

        // Define the variables here. Using the `findViewById` method, Android searches the
        // view we've set for this Activity and then returns a reference to the view with
        // the name we've input - for the two below, we use "fallout" and "main_button" as names
        // since that's what we've named our variables in the activity_main.xml file
        falloutImage = (ImageView) findViewById(R.id.fallout);
        mainButton = (Button) findViewById(R.id.main_button);

        // Here, we attach an instance of a clickListener onto the main button. This just waits
        // for a click, and when one occurs, executes the onClick() method and passes in the view
        // that was clicked itself as an object. We've already defined `falloutImage`, and since it
        // was originally invisible we make it visible now
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   falloutImage.setVisibility(View.VISIBLE);
            }
        });
    }

}
