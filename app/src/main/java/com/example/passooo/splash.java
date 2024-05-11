package com.example.passooo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;


public class splash extends AppCompatActivity {
    String  password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences setting = getSharedPreferences("PREFS", 0);
        password = setting.getString("password", "");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (password.equals("")){
                    Intent intent = new Intent(getApplicationContext(), createpassword.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), enterpassword.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);

    }
}