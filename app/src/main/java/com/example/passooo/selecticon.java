package com.example.passooo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class selecticon extends AppCompatActivity {
    ImageButton btnadobe, btnairbnb,btnamazon,btnandroid,btnapple,btnatlassian,btnbitbucket,btnbitcoin,btnblogger,btndiscord,btndropbox,btnebay ;
    String veri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecticon);
        btnadobe = (android.widget.ImageButton) findViewById(R.id.btnadobe);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        String mail = intent.getStringExtra("mail");
        String pass = intent.getStringExtra("pass");
        String notes = intent.getStringExtra("notes");
        String web =   intent.getStringExtra("website");

        Intent selectionIntent = new Intent(selecticon.this, addpass.class);
        selectionIntent.putExtra("name", name);
        selectionIntent.putExtra("username", username);
        selectionIntent.putExtra("mail", mail);
        selectionIntent.putExtra("pass", pass);
        selectionIntent.putExtra("notes", notes);
        selectionIntent.putExtra("website", web);
        btnadobe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Adobe";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });
        btnairbnb = (android.widget.ImageButton) findViewById(R.id.btnairbnb);
        btnairbnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Airbnb";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });

        btnamazon = (android.widget.ImageButton) findViewById(R.id.btnamazon);
        btnamazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Amazon";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });

        btnandroid = (android.widget.ImageButton) findViewById(R.id.btnandroid);
        btnandroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Android";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });

        btnapple = (android.widget.ImageButton) findViewById(R.id.btnapple);
        btnapple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Apple";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });

        btnatlassian = (android.widget.ImageButton) findViewById(R.id.btnatlassian);
        btnatlassian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Atlassian";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });

        btnbitbucket = (android.widget.ImageButton) findViewById(R.id.btnbitbucket);
        btnbitbucket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Bitbucket";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });

        btnbitcoin = (android.widget.ImageButton) findViewById(R.id.btnbitcoin);
        btnbitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Bitcoin";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });

        btnblogger = (android.widget.ImageButton) findViewById(R.id.btnblogger);
        btnblogger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Blogger";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });

        btndiscord = (android.widget.ImageButton) findViewById(R.id.btndiscord);
        btndiscord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Discord";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });

        btndropbox = (android.widget.ImageButton) findViewById(R.id.btndropbox);
        btndropbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Dropbox";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });

        btnebay = (android.widget.ImageButton) findViewById(R.id.btnebay);
        btnebay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Ebay";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });



    }
}