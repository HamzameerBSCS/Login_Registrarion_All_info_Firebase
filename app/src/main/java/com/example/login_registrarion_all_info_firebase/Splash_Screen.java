package com.example.login_registrarion_all_info_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen extends AppCompatActivity {
//private int time 300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
getSupportActionBar().setTitle("Splash Screen");
        Handler handler = new Handler();
        int time=3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen.this, Registration_patients.class);
                startActivity(intent);
            }
        },time);

    }
}
