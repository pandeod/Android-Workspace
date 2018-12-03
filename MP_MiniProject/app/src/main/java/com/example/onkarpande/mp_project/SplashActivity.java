package com.example.onkarpande.mp_project;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.onkarpande.mp_project.Activity.HomeActivity;

public class SplashActivity extends AppCompatActivity {

    private static int STATIC_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(getApplicationContext(),HomeActivity.class));

               //built in android fade in-out animation
               overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
               finish();
            }
        },STATIC_TIME_OUT);
    }
}
