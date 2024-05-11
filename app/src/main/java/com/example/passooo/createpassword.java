package com.example.passooo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class createpassword extends AppCompatActivity {

    EditText editTextPassword,editTextPasswordtwo;
    Button buttonNext;
    boolean isFingerSet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createpassword);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPasswordtwo = (EditText) findViewById(R.id.editTextPasswordtwo);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = editTextPassword.getText().toString();
                String passwordtwo = editTextPasswordtwo.getText().toString();
                if (password.equals(passwordtwo)){
                    SharedPreferences setting = getSharedPreferences("PREFS", 0);
                    SharedPreferences.Editor editor = setting.edit();
                    editor.putString("password", password);
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), enterpassword.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(createpassword.this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isFingerSet = true;
                    SharedPreferences setting = getSharedPreferences("FINGER", 0);
                    SharedPreferences.Editor editor = setting.edit();
                    editor.putBoolean("finger", isFingerSet);
                    editor.apply();

                    Toast.makeText(getApplicationContext(), "CheckBox seçildi", Toast.LENGTH_SHORT).show();
                } else {
                    isFingerSet = false;
                    SharedPreferences setting = getSharedPreferences("FINGER", 0);
                    SharedPreferences.Editor editor = setting.edit();
                    editor.putBoolean("finger", isFingerSet);
                    editor.apply();
                    // CheckBox seçili değil ise buraya girilecek kod bloğu
                    // İşlem yapılacaksa buraya eklenebilir
                }
            }
        });
    }
}