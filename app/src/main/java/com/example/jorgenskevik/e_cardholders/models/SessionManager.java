package com.example.jorgenskevik.e_cardholders.models;

/**
 * Created by jorgenskevik on 27.03.2017.
 */

import java.util.Date;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.digits.sdk.android.Digits;
import com.example.jorgenskevik.e_cardholders.Code;
import com.example.jorgenskevik.e_cardholders.Main2Activity;
import com.example.jorgenskevik.e_cardholders.Main3Activity;
import com.example.jorgenskevik.e_cardholders.MainActivity;

public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "AndroidHivePref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";

    // Email address (make variable public to access from outside)
    public static final String KEY_ID = "id";

    // Email address (make variable public to access from outside)
    public static final String  KEY_ROLE = "role";

    // Email address (make variable public to access from outside)
    public static final String KEY_TOKEN = "token";

    // picturetoken address (make variable public to access from outside)
    public static final String KEY_PICTURETOKEN = "picturetoken";

    // picturetoken address (make variable public to access from outside)
    public static final long KEY_EXPERATIONDATE = 123;



    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String name, String email, String token, String id, String role, String pictureToken, long experationDate){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_NAME, name);

        // Storing email in pref
        editor.putString(KEY_EMAIL, email);

        // Storing id in pref
        editor.putString(KEY_ID, id);

        // Storing token in pref
        editor.putString(KEY_TOKEN, token);

        // Storing role in pref
        editor.putString(KEY_ROLE, role);

        // Storing role in pref
        editor.putString(KEY_PICTURETOKEN, pictureToken);

        // Storing role in pref
        editor.putLong("time", experationDate);

        // commit changes
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, MainActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }
    }


    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));

        // user email id
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

        // user id
        user.put(KEY_ID, pref.getString(KEY_ID, null));

        // user token id
        user.put(KEY_TOKEN, pref.getString(KEY_TOKEN, null));

        // user role id
        user.put(KEY_ROLE, pref.getString(KEY_ROLE, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();


        // After logout redirect user to Loing Activity
         //  Intent i = new Intent(_context, MainActivity.class);
        // Closing all the Activities
        //i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
      //  i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        //  _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}

