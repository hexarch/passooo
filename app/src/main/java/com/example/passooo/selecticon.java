package com.example.passooo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class selecticon extends AppCompatActivity {
    public  ImageButton btnadobe, btnairbnb,btnamazon,btnandroid,btnapple,btnatlassian,btnbitbucket,btnbitcoin,btnblogger,btndiscord,btndropbox,btnebay,btnepic
    ,btnfacebook,btnflickr,btngithub,btngmail,btngoogle,btnhuawei,btninstagram,btnlinkedin,btnmastercard,btnmicrosoft,btnnetflix
    ,btnNintendo,btnoutlook,btnpaypay,btnplaystation,btnreddit,btnskype,btnslack,btnsnapchat,btnspotify,btnsteam,btnteamviewer,
      btntelegram,btntinder,btntumblr,btntwitch,btnvisa,btnvk,btnwechat,btnwindows,btnxbox,btnx,btnxiaomi,btnyoutube,btnzoom;

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

        btnepic = (android.widget.ImageButton) findViewById(R.id.btnepic);
        btnepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Epic Games";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });
        btnfacebook = (android.widget.ImageButton) findViewById(R.id.btnfacebook);
        btnfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Facebook";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });
        btnflickr = (android.widget.ImageButton) findViewById(R.id.btnflickr);
        btnflickr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Flickr";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });
        btngithub = (android.widget.ImageButton) findViewById(R.id.btngithub);
        btngithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Github";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });
        btngmail = (android.widget.ImageButton) findViewById(R.id.btngmail);
        btngmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Gmail";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });
        btngoogle = (android.widget.ImageButton) findViewById(R.id.btngoogle);
        btngoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Google";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });
        btnhuawei = (android.widget.ImageButton) findViewById(R.id.btnhuawei);
        btnhuawei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Huawei";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });
        btninstagram = (android.widget.ImageButton) findViewById(R.id.btninstagram);
        btninstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Instagram";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });
        btnlinkedin = (android.widget.ImageButton) findViewById(R.id.btnlinkedin);
        btnlinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Linkedin";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }
        });


        btnmastercard = (android.widget.ImageButton) findViewById(R.id.btnmastercard);
        btnmastercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Mastercard";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnmicrosoft = (android.widget.ImageButton) findViewById(R.id.btnmicrosoft);
        btnmicrosoft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Microsoft";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnnetflix = (android.widget.ImageButton) findViewById(R.id.btnnetflix);
        btnnetflix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Netflix";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnNintendo = (android.widget.ImageButton) findViewById(R.id.btnnintendo);
        btnNintendo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Nintendo";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });

        btnoutlook = (android.widget.ImageButton) findViewById(R.id.btnoutlook);
        btnoutlook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Outlook";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnpaypay = (android.widget.ImageButton) findViewById(R.id.btnpaypal);
        btnpaypay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Paypal";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });

        btnplaystation = (android.widget.ImageButton) findViewById(R.id.btnplaystation);
        btnplaystation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Playstation";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnreddit = (android.widget.ImageButton) findViewById(R.id.btnreddit);
        btnreddit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Reddit";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnskype = (android.widget.ImageButton) findViewById(R.id.btnskype);
        btnskype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Skype";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnslack = (android.widget.ImageButton) findViewById(R.id.btnslack);
        btnslack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Slack";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnsnapchat = (android.widget.ImageButton) findViewById(R.id.btnsnapchat);
        btnsnapchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Snapchat";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnspotify = (android.widget.ImageButton) findViewById(R.id.btnspotify);
        btnspotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Spotify";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnsteam = (android.widget.ImageButton) findViewById(R.id.btnsteam);
        btnsteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Steam";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnteamviewer = (android.widget.ImageButton) findViewById(R.id.btnteamviewer);
        btnteamviewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Teamviewer";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btntelegram = (android.widget.ImageButton) findViewById(R.id.btntelegram);
        btntelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Telegram";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btntinder = (android.widget.ImageButton) findViewById(R.id.btntinder);
        btntinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Tinder";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btntumblr = (android.widget.ImageButton) findViewById(R.id.btntumblr);
        btntumblr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Tumblr";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btntwitch = (android.widget.ImageButton) findViewById(R.id.btntwitch);
        btntwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Twitch";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnvisa = (android.widget.ImageButton) findViewById(R.id.btnvisa);
        btnvisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Visa";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnvk = (android.widget.ImageButton) findViewById(R.id.btnvk);
        btnvk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "VK";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnwechat = (android.widget.ImageButton) findViewById(R.id.btnwechat);
        btnwechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "WeChat";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnwindows = (android.widget.ImageButton) findViewById(R.id.btnwindows);
        btnwindows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Windows";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnxbox = (android.widget.ImageButton) findViewById(R.id.btnxbox);
        btnxbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Xbox";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnx = (android.widget.ImageButton) findViewById(R.id.btnx);
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "X";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnxiaomi = (android.widget.ImageButton) findViewById(R.id.btnxiaomi);
        btnxiaomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Xiaomi";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnyoutube = (android.widget.ImageButton) findViewById(R.id.btnyoutube);
        btnyoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Youtube";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });
        btnzoom = (android.widget.ImageButton) findViewById(R.id.btnzoom);
        btnzoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veri = "Zoom";
                selectionIntent.putExtra("anahtar", veri); // "anahtar" veriye erişmek için bir referans
                startActivity(selectionIntent);
            }

        });

    }
}