package com.example.miguel909.bh2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by miguel909 on 28/01/2018.
 */

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_activity);

        Thread t = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                    Intent jumpToHome = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(jumpToHome);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t.start();
    }
}