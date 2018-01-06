package com.example.jorgenskevik.e_cardholders.models;

/**
 * Created by jorgenskevik on 27.03.2017.
 */

import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.digits.sdk.android.Digits;
import com.example.jorgenskevik.e_cardholders.BarCodeActivity;
import com.example.jorgenskevik.e_cardholders.TermsActivity;
import com.example.jorgenskevik.e_cardholders.UserActivity;
import com.example.jorgenskevik.e_cardholders.LoginActivity;

/**
 * The type Session manager.
 */
public class SessionManager {
    /**
     * The Pref.
     */
// Shared Preferences
    SharedPreferences pref;

    /**
     * The Editor.
     */
// Editor for Shared preferences
    Editor editor;

    /**
     * The Context.
     */
// Context
    Context _context;

    /**
     * The Private mode.
     */
// Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "AndroidHivePref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    /**
     * The constant KEY_NAME.
     */
// User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    /**
     * The constant KEY_EMAIL.
     */
// Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";

    /**
     * The constant KEY_ID.
     */
// id address (make variable public to access from outside)
    public static final String KEY_ID = "id";

    /**
     * The constant KEY_ROLE.
     */
// role address (make variable public to access from outside)
    public static final String  KEY_ROLE = "role";

    /**
     * The constant KEY_TOKEN.
     */
// token address (make variable public to access from outside)
    public static final String KEY_TOKEN = "token";

    /**
     * The constant KEY_PICTURETOKEN.
     */
// pictureToken address (make variable public to access from outside)
    public static final String KEY_PICTURETOKEN = "pictureToken";

    /**
     * The constant KEY_EXPERATIONDATE.
     */
// experationDate address (make variable public to access from outside)
    public static final String KEY_EXPERATIONDATE = "experationDate";

    /**
     * The constant KEY_STUDENTNUMBER.
     */
// studentNumber address (make variable public to access from outside)
    public static final String KEY_STUDENTNUMBER = "studentNumber";

    /**
     * The constant KEY_PATH.
     */
// path adress (make variable public to access from outside)
    public static final String KEY_PATH = "path";

    /**
     * The constant KEY_BIRTHDATE.
     */
// birthDate address (make variable public to access from outside)
    public static final String KEY_BIRTHDATE = "birthDate";

    /**
     * The constant KEY_PICTURE.
     */
    public static final String KEY_PICTURE = "picture";


    public static final String KEY_CHECK = "check";

    public static final String KEY_TURN = "turn";


    /**
     * Instantiates a new Session manager.
     *
     * @param context the context
     */
// Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session.
     *
     * @param name           the name
     * @param email          the email
     * @param token          the token
     * @param studentNumber  the student number
     * @param id             the id
     * @param role           the role
     * @param pictureToken   the picture token
     * @param experationDate the experation date
     * @param birthday       the birthday
     * @param picture        the picture
     */
    public void createLoginSession(String name, String email, String token, String studentNumber, String id, String role, String pictureToken, String experationDate, String birthday, String picture){
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

        // Storing studentnumber in pref

        editor.putString(KEY_STUDENTNUMBER, studentNumber);

        // Storing role in pref
        editor.putString(KEY_EXPERATIONDATE, experationDate);

        // Storing birthdate in pref
        editor.putString(KEY_BIRTHDATE, birthday);

        // Storing picture in pref
        editor.putString(KEY_PICTURE, picture);

        // commit changes
        editor.commit();
    }

    /**
     * Create updated login session.
     *
     * @param name           the name
     * @param email          the email
     * @param studentNumber  the student number
     * @param id             the id
     * @param role           the role
     * @param pictureToken   the picture token
     * @param dateOfBirth    the date of birth
     * @param experationDate the experation date
     * @param picture        the picture
     */
    public void createUpdatedLoginSession(String name, String email, String studentNumber, String id, String role, String pictureToken, String dateOfBirth ,String experationDate, String picture){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_NAME, name);

        // Storing email in pref
        editor.putString(KEY_EMAIL, email);

        // Storing id in pref
        editor.putString(KEY_ID, id);

        // Storing role in pref
        editor.putString(KEY_ROLE, role);

        // Storing role in pref
        editor.putString(KEY_PICTURETOKEN, pictureToken);

        // Storing studentnumber in pref
        editor.putString(KEY_STUDENTNUMBER, studentNumber);

        // Storing dateofbirth in pref
        editor.putString(KEY_BIRTHDATE, dateOfBirth);

        // Storing role in pref
        editor.putString(KEY_EXPERATIONDATE, experationDate);

        editor.putString(KEY_PICTURE, picture);

        // commit changes
        editor.commit();
    }

    /**
     * Update picture token.
     *
     * @param pictureToken the picture token
     */
    public void updatePictureToken(String pictureToken){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing role in pref
        editor.putString(KEY_PICTURETOKEN, pictureToken);

        // commit changes
        editor.commit();
    }


    /**
     * Update path.
     *
     * @param path the path
     */
    public void updatePath(String path){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing path in pref
        editor.putString(KEY_PATH, path);

        // Storing picture in pref
        //editor.putString(KEY_PICTURE, path);

        // commit changes
        editor.apply();

    }


    /**
     * Update picture.
     *
     * @param picture the picture
     */
    public void updatePicture(String picture){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing role in pref
        editor.putString(KEY_PICTURE, picture);

        // commit changes
        editor.apply();

    }

    public void updateCheck(String check){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing role in pref
        editor.putString(KEY_CHECK, check);

        // commit changes
        editor.apply();

    }

    public void updateTurn(String turn){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing role in pref
        editor.putString(KEY_TURN, turn);

        // commit changes
        editor.apply();

    }


    /**
     * Is logged in boolean.
     *
     * @return the boolean
     */
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }


    /**
     * Get user details hash map.
     *
     * @return the hash map
     */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));

        // user email
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

        // user id
        user.put(KEY_ID, pref.getString(KEY_ID, null));

        // user token
        user.put(KEY_TOKEN, pref.getString(KEY_TOKEN, null));

        // user studentNumber
        user.put(KEY_STUDENTNUMBER, pref.getString(KEY_STUDENTNUMBER, null));

        // user role
        user.put(KEY_ROLE, pref.getString(KEY_ROLE, null));

        // user expertaionDate
        user.put(KEY_EXPERATIONDATE, pref.getString(KEY_EXPERATIONDATE, null));

        // user pictureToken
        user.put(KEY_PICTURETOKEN, pref.getString(KEY_PICTURETOKEN, null));

        // user path
        user.put(KEY_PATH, pref.getString(KEY_PATH, null));

        // user birthDate
        user.put(KEY_BIRTHDATE, pref.getString(KEY_BIRTHDATE, null));

        // user picture
        user.put(KEY_PICTURE, pref.getString(KEY_PICTURE, null));

        // user check
        user.put(KEY_CHECK, pref.getString(KEY_CHECK, null));

        user.put(KEY_TURN, pref.getString(KEY_TURN, null));


        // return user
        return user;
    }

    /**
     * Logout user.
     */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        //editor.clear();
        editor.remove(KEY_BIRTHDATE);
        editor.remove(IS_LOGIN);
        editor.remove(KEY_NAME);
        editor.remove(KEY_EMAIL);
        editor.remove(KEY_ID);
        editor.remove(KEY_ROLE);
        editor.remove(KEY_TOKEN);
        editor.remove(KEY_PICTURETOKEN);
        editor.remove(KEY_EXPERATIONDATE);
        editor.remove(KEY_STUDENTNUMBER);
        editor.remove(KEY_BIRTHDATE);
        editor.remove(KEY_PATH);
        editor.remove(KEY_PICTURE);
        editor.remove(KEY_CHECK);
        editor.commit();
    }

    public void deletePhoto(){
        editor.remove(KEY_PATH);
        editor.commit();
    }
}

