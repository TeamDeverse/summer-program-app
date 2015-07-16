package org.deverse.summer_program.deversesummerprogram;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.parse.ParseException;
import com.parse.SignUpCallback;

//import org.deverse.summer_program.deversesummerprogram.ParseAPI;


public class MainActivity extends Activity {

    // Declare our variables up here so that they're globally accessible. We'll define them later
    ParseAPI backend;
    EditText loginEmail;
    EditText loginPassword;
    Button loginButton;

    // The onCreate method is the first method that runs when the app starts up. It's like Java's
    // main() method
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backend = new ParseAPI(this);
        loginEmail = (EditText) findViewById(R.id.login_email);
        loginPassword = (EditText) findViewById(R.id.login_password);
        loginButton = (Button) findViewById(R.id.login_button);


        View.OnClickListener loginClick = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = loginEmail.getText().toString();
                String password = loginPassword.getText().toString();
            }
        };

        loginButton.setOnClickListener(loginClick);
    }

}
