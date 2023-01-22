package com.example.samplepj;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pref = getSharedPreferences("My_Pref", MODE_PRIVATE);

        Boolean isLoggedIn = pref.getBoolean("isLoggedIn", false);

        if (isLoggedIn) {
            startActivity(new Intent(this, HomeActivity.class));
        } else {
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }
}