package com.example.mechinetest2.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mechinetest2.MainActivity;
import com.example.mechinetest2.R;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                    Intent ik = new Intent(getApplicationContext(), MainActivity.class);
                    ik.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(ik);
                    finish();
            }
        }, SPLASH_TIME_OUT);

    }
}