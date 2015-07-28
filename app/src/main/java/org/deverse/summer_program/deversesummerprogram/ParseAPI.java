package org.deverse.summer_program.deversesummerprogram;

import android.content.Context;

import com.parse.CountCallback;
import com.parse.FindCallback;
import com.parse.FunctionCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseCloud;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ParseAPI {

    public Context context;

    public ParseAPI(Context context) {
        this.context = context;
    }



    /* * * * * * * *
     *
     * SITE METHODS
     *
     * * * * * * * */

    // Gets all the sites

    public void getAllSites(FindCallback callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Sites");
        query.findInBackground(callback);
    }



    // Get sites by a location. Pass in a latitude and longitude, and it will order sites by
    // proximity to that latitude/longitude combination
    public void getSitesByLocation(double latitude, double longitude, FindCallback callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Sites");
        ParseGeoPoint currentLocation = new ParseGeoPoint(latitude, longitude);
        query.whereNear("geolocation", currentLocation);
        query.findInBackground(callback);
    }

    /* * * * * * * *
     *
     * TIME METHODS
     *
     * * * * * * * */

    // Gets all the upcoming times for every site

    public void getTimes(FindCallback callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Times");
        query.orderByDescending("date");
        query.findInBackground(callback);
    }

    // Pass in a Java Date function, will pass back all the upcoming times for all sites for a date

    public void getTimesByDate(Date date, FindCallback callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Times");
        query.whereEqualTo("date", date);
        query.orderByDescending("start_hour");
        query.findInBackground(callback);
    }

    // Pass in a Site object, will pass back all the times

    public void getTimesForSite(String site_id, FindCallback callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Times");
        query.whereEqualTo("site_id", site_id);
        query.orderByDescending("date");
        query.findInBackground(callback);
    }

    // Pass in a Java Date function for a day with a Site object, and will pass back all the times for that day

    public void getTimesForSiteByDate(String site_id, Date day, FindCallback callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Times");
        query.whereEqualTo("date", day);
        query.whereEqualTo("site_id", site_id);
        query.orderByDescending("start_hour");
        query.findInBackground(callback);
    }

    // Pass in a Java Date function for a day with a Site object, will pass back all the upcoming times

    public void getTimesForSiteAfterDate(String site_id, Date day, FindCallback callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Times");
        query.whereEqualTo("site_id", site_id);
        query.whereGreaterThan("date", day);
        query.orderByDescending("date");
        query.findInBackground(callback);
    }

    /* * * * * * * *
     *
     * SIGNUP METHODS
     *
     * * * * * * * */

    // Pass in a site object, and will return all the Time objects a user is signed up for

    public void getTimesForSiteWithUserSignups(String site_id, FunctionCallback<Map<String, List<ParseObject>>> callback) {
        System.out.println("IN HERE fff");
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Signups");
        Map<String, String> values = new HashMap<String, String>();
        values.put("site_id", site_id);
//        values.put("user_id", this.getCurrentUser().getObjectId());
        values.put("user_id", "UrIuR0kj4b");
        ParseCloud.callFunctionInBackground("getTimesForSiteWithUserSignups", values, callback);
    }

    // Pass in a site object, and will return all the Time objects a user is signed up for
    public void getTimesForSiteWithUserSignupsByDate(String site_id, Date day, FunctionCallback<Map<String, List<ParseObject>>> callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Signups");
        Map<String, String> values = new HashMap<String, String>();
        values.put("site_id", site_id);
        values.put("user_id", this.getCurrentUser().getObjectId());
        values.put("date", day.toString());
        ParseCloud.callFunctionInBackground("getTimesForSiteWithUserSignupsByDate", values, callback);
    }

    // Get all user signups
    public void getUserSignups(FindCallback callback) {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Signups");
        query.whereEqualTo("user_id", this.getCurrentUser().getObjectId());
        query.findInBackground(callback);
    }

    // SIGNING UP FOR A VOLUNTEER TIME IS BELOW

    // Pass in a Time object to sign a user up. No callback needed
    public void signupForTime(ParseObject time) {
        ParseObject signup = new ParseObject("Signups");

        signup.put("user_id", this.getCurrentUser().getObjectId());
        signup.put("time_id", time.getObjectId());
        signup.put("site_id", time.get("site_id"));
        signup.saveInBackground();
    }

    // Pass in a Time object to sign a user up. There is a callback as well which will run after the
    // signup is saved
    public void signupForTimeWithCallback(ParseObject time, SaveCallback callback) {
        ParseObject signup = new ParseObject("Signups");

        signup.put("user_id", this.getCurrentUser().getObjectId());
        signup.put("time_id", time.getObjectId());
        signup.put("site_id", time.get("site_id"));
        signup.saveInBackground(callback);
    }

    /* * * * * * * *
     *
     * USER METHODS
     *
     * * * * * * * */

    // Pass in an email, password, first name and last name, and a user will be created
    public void signUpUser(String email, String password, String firstName, String lastName, SignUpCallback callback) {
        ParseUser user = new ParseUser();
        user.setUsername(email);
        user.setPassword(password);
        user.put("first_name", firstName);
        user.put("last_name", lastName);
        user.signUpInBackground(callback);
        user.put("first-name",firstName);
        user.put("last_name",lastName);
    }

    // Logs in a user with an email and a password, will return the user
    public void loginUser(String email, String password, LogInCallback callback) {
        ParseUser.logInInBackground(email, password, callback);
    }

    // If a user has logged in, this will return the current user
    public ParseUser getCurrentUser() {
        return ParseUser.getCurrentUser();
    }

    // Will log a user out
    public void logoutCurrentUser() {
        ParseUser.logOut();
    }
}
