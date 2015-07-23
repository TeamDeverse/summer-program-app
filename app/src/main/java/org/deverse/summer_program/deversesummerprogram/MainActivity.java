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
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

//import org.deverse.summer_program.deversesummerprogram.ParseAPI;


public class MainActivity extends Activity {

    // Declare our variables up here so that they're globally accessible. We'll define them later
    ParseAPI backend;
    EditText loginEmail;
    EditText loginPassword;
    Button loginButton;
    EditText signupPassword;
    EditText signuppasswordconfirm;
    EditText signupfirstname;
    EditText signuplastname;
    EditText signupEmail;
    Button signupbutton;


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

        signupfirstname = (EditText) findViewById(R.id.signup_first);
        signuplastname = (EditText) findViewById(R.id.signup_last);
        signupPassword = (EditText) findViewById(R.id.signup_password);
        signuppasswordconfirm = (EditText) findViewById(R.id.signup_passwordconfirm);
        signupEmail = (EditText) findViewById(R.id.signup_email);
        signupbutton = (Button) findViewById(R.id.signup_button);

        final Intent goToWelcomeActivity = new Intent(this, WelcomeActivity.class);


        View.OnClickListener loginClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the string values from the EditTexts to log in the user
                String email = loginEmail.getText().toString();
                String password = loginPassword.getText().toString();

                // Call the loginUser function and pass in a callback to run when we
                // get confirmation the user logged in!
                backend.loginUser(email, password, new LogInCallback() {

                    @Override
                    public void done(ParseUser parseUser, ParseException e) {

                        System.out.println(e);
                        if (parseUser != null) {
                            // User does exist
                            goToWelcomeActivity.putExtra("username", parseUser.getUsername());
                            startActivity(goToWelcomeActivity);
                            System.out.println("USER DOES EXIST");
                        } else {
                            // User does not exist
                            System.out.println("USER DOESN'T EXIST");
                        }
                    }

                });

            }
        };

        View.OnClickListener signupClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = signupPassword.getText().toString();
                String passwordConfirm = signuppasswordconfirm.getText().toString();
                String firstname = signupfirstname.getText().toString();
                String lastname = signuplastname.getText().toString();
                final String signupemail = signupEmail.getText().toString();


                if (signupemail.trim().equals("") || password.trim().equals("")) {
                    //Password equal each other
                    Toast.makeText(getApplicationContext(), "Fill in the fields!", Toast.LENGTH_LONG).show();
                } else if (password.equals(passwordConfirm)) {
                    backend.signUpUser(signupemail, password, firstname, lastname, new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                goToWelcomeActivity.putExtra("username", signupemail);
                                startActivity(goToWelcomeActivity);
                            } else {
                                Toast.makeText(getApplicationContext(), "Signup Failed!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Password don't match!", Toast.LENGTH_LONG).show();
                }
            }
        };

        loginButton.setOnClickListener(loginClick);
        signupbutton.setOnClickListener(signupClick);

    }
}