package org.deverse.summer_program.deversesummerprogram;

import android.content.Context;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.Date;
import java.util.List;

class ParseAPI {

    public Context context;

    public ParseAPI(Context context) {
        Parse.initialize(context, "a6YcVdnzUomdTpnfLFOYC5YImQmdlCfzkpNqtPZK", "5b09yCzGmh3db0WAPBSyMkt410dtjPLxYqkXZC5h");
        this.context = context;
    }

    // Pass in a method to execute when the query runs
    public void getAllSites(FindCallback<ParseObject> callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Sites");
        query.findInBackground(callback);
    }

    public void getAvailableTimesForDate(ParseObject site, Date day, FindCallback<ParseObject> callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Times");
        query.whereEqualTo("date", day);
        query.whereEqualTo("Site", site);
        query.findInBackground(callback);
    }

    public void getTimes(FindCallback<ParseObject> callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Times");
        query.findInBackground(callback);
    }

    public void signUpUser(String email, String password, SignUpCallback callback) {
        ParseUser user = new ParseUser();
        user.setUsername(email);
        user.setPassword(password);
        user.signUpInBackground(callback);
    }

    public void loginUser(String email, String password, LogInCallback callback) {
        ParseUser.logInInBackground(email, password, callback);
    }

    public ParseUser getCurrentUser() {
        return ParseUser.getCurrentUser();
    }

    public void logoutCurrentUser() {
        ParseUser.logOut();
    }
}
