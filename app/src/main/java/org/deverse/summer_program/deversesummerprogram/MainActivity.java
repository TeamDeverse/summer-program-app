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

    EditText signupFirstName;
    EditText signupLastName;
    EditText signupEmail;
    EditText signupPassword;
    EditText signupPasswordConfirm;
    Button signupButton;

    // The onCreate method is the first method that runs when the app starts up. It's like Java's
    // main() method
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference to our API Wrapper
        backend = new ParseAPI(this);

        // All the login views
        loginEmail = (EditText) findViewById(R.id.login_email);
        loginPassword = (EditText) findViewById(R.id.login_password);
        loginButton = (Button) findViewById(R.id.login_button);
        signupFirstName=(EditText)findViewById(R.id.signup_first);
        signupLastName=(EditText)findViewById(R.id.signup_last);
        signupEmail=(EditText)findViewById(R.id.signup_email);
        signupPassword=(EditText)findViewById(R.id.signup_password);
        signupButton=(Button)findViewById(R.id.signup_button);
        signupPasswordConfirm = (EditText) findViewById(R.id.signup_password_confirm);
        signupButton = (Button) findViewById(R.id.signup_button);

        final Intent goToWelcomeActivity = new Intent(this, WelcomeActivity.class);

        // ClickListeners for each button
        View.OnClickListener loginClick = new View.OnClickListener(){
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
                        if (parseUser != null) {
                            // User does exist
                            goToWelcomeActivity.putExtra("username", parseUser.getUsername());
                            startActivity(goToWelcomeActivity);
                        } else {
                            // User does not exist
                            Toast.makeText(getApplicationContext(), "User does not exist!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        };

        View.OnClickListener signupClick = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String firstName = signupFirstName.getText().toString();
                String lastName = signupLastName.getText().toString();
                final String email = signupEmail.getText().toString();
                String password = signupPassword.getText().toString();
                String passwordConfirm = signupPasswordConfirm.getText().toString();

                if (email.trim().equals("") || password.trim().equals("")) {
                    // Email or password is blank
                    Toast.makeText(getApplicationContext(), "Fill in the fields!", Toast.LENGTH_LONG).show();
                } else if (password.equals(passwordConfirm)) {
                    // Passwords equal each other
                    backend.signUpUser(email, password, firstName, lastName, new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            // What happens when we sign up a user
                            if (e == null) {
                                goToWelcomeActivity.putExtra("username", email);
                                startActivity(goToWelcomeActivity);
                            } else {
                                Toast.makeText(getApplicationContext(), "Signup Failed!", Toast.LENGTH_LONG).show();
                                System.out.println(e);
                            }
                        }
                    });
                } else {
                    // Passwords don't equal each other
                    Toast.makeText(getApplicationContext(), "Passwords don't match!", Toast.LENGTH_LONG).show();
                }
            }
        };

        // Assign the click listener for each button
        loginButton.setOnClickListener(loginClick);
        signupButton.setOnClickListener(signupClick);
    }

}
