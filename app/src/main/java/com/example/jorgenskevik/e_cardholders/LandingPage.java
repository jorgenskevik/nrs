package com.example.jorgenskevik.e_cardholders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.jorgenskevik.e_cardholders.models.SessionManager;

import java.util.HashMap;

/**
 * Created by jorgenskevik on 29.12.2017.
 */

public class LandingPage extends Activity{
    Button buttonLogin;
    Button contact;
    SessionManager sessionManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.landingpage);
        buttonLogin = (Button) findViewById(R.id.button2);
        contact = (Button) findViewById(R.id.button);

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        }

        sessionManager = new SessionManager(getApplicationContext());
        HashMap<String, String> user = sessionManager.getUserDetails();

        String name = user.get(SessionManager.KEY_NAME);

        // id
        String id = user.get(SessionManager.KEY_ID);

        // email
        String email = user.get(SessionManager.KEY_EMAIL);

        //token
        String token = user.get(SessionManager.KEY_TOKEN);

        //check
        String check = user.get(SessionManager.KEY_CHECK);

        if (name == null || id == null || email == null || token == null) {


            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LandingPage.this, LoginActivity.class);
                    startActivity(intent);
                }
            });
            contact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LandingPage.this, ContactUsActivity.class);
                    startActivity(intent);
                }
            });
        }else if (check == null){
            Intent intent = new Intent(LandingPage.this, TermsActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(LandingPage.this, UserActivity.class);
            startActivity(intent);
        }
    }
}
