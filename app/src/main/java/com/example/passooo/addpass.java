package com.example.passooo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Objects;
public class addpass extends AppCompatActivity {
    ImageButton button ,geri,btnsave;
    String sqlname,sqlusername,sqlmail,sqlpass,sqlnotes,sqlicon,sqlid = "s";
    String username,mail,pass,notes,name,idi ,web = null;

    String intname,intusername,intmail,intpass,intnotes,intwebsite;
    int flag = 0;
    private DatabaseHelper databaseHelper;
    private EditText editTextUsername, editTextMail, editTextPass, editTextNotes, editTextName, editTextWebsite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpass);
        editTextName = findViewById(R.id.editTextTextPersonName);
        editTextUsername = findViewById(R.id.editTextusername);
        editTextMail = findViewById(R.id.editTextmail);
        editTextPass = findViewById(R.id.editTextPassword);
        editTextNotes = findViewById(R.id.editTextnotes);
        editTextWebsite = findViewById(R.id.editTextwebsite);

        Intent intent = getIntent();
        String veri = intent.getStringExtra("anahtar");
        geri = (android.widget.ImageButton) findViewById(R.id.btnLeft);
        button = (android.widget.ImageButton) findViewById(R.id.iconsbutton);
        btnsave = (android.widget.ImageButton) findViewById(R.id.btnsave);
        databaseHelper = new DatabaseHelper(this);
        final EditText passwordEditText = findViewById(R.id.editTextPassword);
        final ImageButton showPasswordButton = findViewById(R.id.showPasswordButton);

        // Göz simgesine tıklandığında
        showPasswordButton.setOnClickListener(new View.OnClickListener() {
            boolean passwordVisible = false;

            @Override
            public void onClick(View v) {
                showPasswordButton.setBackground(null);

                // Şifre görünürlüğünü değiştir

                if (!passwordVisible) {
                    // Şifreyi göster
                    showPasswordButton.setImageResource(R.drawable.openeye);
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordVisible = true;
                } else {
                    // Şifreyi gizle
                    showPasswordButton.setImageResource(R.drawable.closedeye);
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordVisible = false;
                }

                // Yeniden layout'u geçerli hale getir
                passwordEditText.setSelection(passwordEditText.getText().length());
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editTextName.getText().toString();
                username = editTextUsername.getText().toString();
                mail = editTextMail.getText().toString();
                pass = editTextPass.getText().toString();
                notes = editTextNotes.getText().toString();
                web = editTextWebsite.getText().toString();
                Intent selectionIntent = new Intent(addpass.this, selecticon.class);
                // Verileri Intent'e ekleyerek aktar
                selectionIntent.putExtra("name", name);
                selectionIntent.putExtra("username", username);
                selectionIntent.putExtra("mail", mail);
                selectionIntent.putExtra("pass", pass);
                selectionIntent.putExtra("notes", notes);
                selectionIntent.putExtra("website", web);
                startActivity(selectionIntent);
            }
        });
        if (veri != null) {
            button.setBackground(null);
            button.setScaleType(ImageButton.ScaleType.FIT_CENTER);
        }
        if(Objects.equals(veri, "Adobe"))
        {
          button.setImageResource(R.drawable.adobe100x100);
        }
        if(Objects.equals(veri, "Airbnb"))
        {
            button.setImageResource(R.drawable.airbnb100x100);
        }
        if(Objects.equals(veri, "Amazon"))
        {
            button.setImageResource(R.drawable.amazon100x100);
        }
        if(Objects.equals(veri, "Android"))
        {
            button.setImageResource(R.drawable.android100x100);
        }
        if(Objects.equals(veri, "Apple"))
        {
                button.setImageResource(R.drawable.appel100x100);
        }
        if(Objects.equals(veri, "Atlassian"))
        {
            button.setImageResource(R.drawable.atlassian100x100);
        }
        if(Objects.equals(veri, "Bitbucket"))
        {
            button.setImageResource(R.drawable.bitbucker100x100);
        }
        if(Objects.equals(veri, "Bitcoin"))
        {
            button.setImageResource(R.drawable.bitcoin100x100);
        }
        if(Objects.equals(veri, "Blogger"))
        {
            button.setImageResource(R.drawable.blogger100x100);
        }
        if(Objects.equals(veri, "Discord"))
        {
            button.setImageResource(R.drawable.discord100x100);
        }
        if(Objects.equals(veri, "Dropbox"))
        {
            button.setImageResource(R.drawable.dropbox100x100);
        }
        if(Objects.equals(veri, "Ebay"))
        {
            button.setImageResource(R.drawable.ebay100x100);
        }
        if(Objects.equals(veri, "flickr"))
        {
            button.setImageResource(R.drawable.flickr100x100);
        }

        if(Objects.equals(veri, "Github"))
        {
            button.setImageResource(R.drawable.github100x100);
        }

        if(Objects.equals(veri, "Gmail"))
        {
            button.setImageResource(R.drawable.gmail100x100);
        }

        if(Objects.equals(veri, "Google"))
        {
            button.setImageResource(R.drawable.google100x100);
        }

        if(Objects.equals(veri, "Huawei"))
        {
            button.setImageResource(R.drawable.huawei100x100);
        }

        if(Objects.equals(veri, "Instagram"))
        {
            button.setImageResource(R.drawable.instagramicon150x150);
        }

        if(Objects.equals(veri, "Linkedin"))
        {
            button.setImageResource(R.drawable.linkedln100x100);
        }

        if(Objects.equals(veri, "Microsoft"))
        {
            button.setImageResource(R.drawable.microsoft100x100);
        }

        if(Objects.equals(veri, "Netflix"))
        {
            button.setImageResource(R.drawable.netflix100x100);
        }

        if(Objects.equals(veri, "Nintendo"))
        {
            button.setImageResource(R.drawable.nintendo100x100);
        }

        if(Objects.equals(veri, "Outlook"))
        {
            button.setImageResource(R.drawable.outlook100x100);
        }

        if(Objects.equals(veri, "Paypal"))
        {
            button.setImageResource(R.drawable.paypal100x100);
        }

        if(Objects.equals(veri, "Playstation"))
        {
            button.setImageResource(R.drawable.playstation100x100);
        }
        if(Objects.equals(veri, "Reddit"))
        {
            button.setImageResource(R.drawable.redditicon150x150);
        }
        if(Objects.equals(veri, "Skype"))
        {
            button.setImageResource(R.drawable.skype100x100);
        }
        if(Objects.equals(veri, "Slack"))
        {
            button.setImageResource(R.drawable.slack100x100);
        }
        if(Objects.equals(veri, "Snapchat"))
        {
            button.setImageResource(R.drawable.snapchat100x100);
        }
        if(Objects.equals(veri, "Spotify"))
        {
            button.setImageResource(R.drawable.spotify100x100);
        }
        if(Objects.equals(veri, "Steam"))
        {
            button.setImageResource(R.drawable.steamicon2);
        }
        if(Objects.equals(veri, "Teamviewer"))
        {
            button.setImageResource(R.drawable.teamviewer100x100);
        }
        if(Objects.equals(veri, "Telegram"))
        {
            button.setImageResource(R.drawable.telegram100x100);
        }
        if(Objects.equals(veri, "Tinder"))
        {
            button.setImageResource(R.drawable.tinder100x100);
        }
        if(Objects.equals(veri, "Twitch"))
        {
            button.setImageResource(R.drawable.twitch100x100);
        }
        if(Objects.equals(veri, "tumblr"))
        {
            button.setImageResource(R.drawable.tumblr100x100);
        }
        if(Objects.equals(veri, "Twitter"))
        {
            button.setImageResource(R.drawable.twittericon150x150);
        }
        if(Objects.equals(veri, "Visa"))
        {
            button.setImageResource(R.drawable.visa100x100);
        }
        if(Objects.equals(veri, "Vk"))
        {
            button.setImageResource(R.drawable.vk100x100);
        }
        if(Objects.equals(veri, "Windows"))
        {
            button.setImageResource(R.drawable.windows100x100);
        }
        if(Objects.equals(veri, "Xbox"))
        {
            button.setImageResource(R.drawable.xbox100x100);
        }
        if(Objects.equals(veri, "Xiaomi"))
        {
            button.setImageResource(R.drawable.xiaomi100x100);
        }
        if(Objects.equals(veri, "Youtube"))
        {
            button.setImageResource(R.drawable.youtube100x100);
        }
        if(Objects.equals(veri, "Zoom"))
        {
            button.setImageResource(R.drawable.zoom100x100);
        }

        // Intent üzerinden verileri alarak EditText bileşenlerine yaz
         idi = intent.getStringExtra("id");
        if (intent != null) {
            intname = intent.getStringExtra("name");
            if (intname != null) {
                editTextName.setText(intname);
            }

            intusername = intent.getStringExtra("username");
            if (intusername != null) {
                editTextUsername.setText(intusername);
            }

            intmail = intent.getStringExtra("mail");
            if (intmail != null) {
                editTextMail.setText(intmail);
            }

            intpass = intent.getStringExtra("pass");
            if (intpass != null) {
                editTextPass.setText(intpass);
            }
            intnotes = intent.getStringExtra("notes");
            if (intnotes != null) {
                editTextNotes.setText(intnotes);
            }
            intwebsite = intent.getStringExtra("website");
            if (intwebsite != null) {
                editTextWebsite.setText(intwebsite);
            }
        }
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //Kaydetme butonuna tıklandığında
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EditText bileşenlerinden verileri al
                String name = editTextName.getText().toString();
                String username = editTextUsername.getText().toString();
                String mail = editTextMail.getText().toString();
                String pass = editTextPass.getText().toString();
                String notes = editTextNotes.getText().toString();
                String web = editTextWebsite.getText().toString();

                String icon = veri.toString();


                if (name.isEmpty() || username.isEmpty() || mail.isEmpty() || pass.isEmpty() || notes.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Lütfen tüm alanları doldurunuz", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), ""+sqlid+"     "+idi, Toast.LENGTH_SHORT).show();
                    if(Objects.equals(sqlid, idi))
                    {
                        Toast.makeText(getApplicationContext(), "update", Toast.LENGTH_SHORT).show();

                        DatabaseHelper databaseHelper = new DatabaseHelper(addpass.this);
                        boolean result = databaseHelper.updateData(idi,name, username, mail, pass, notes,icon,web);
                        if (result) {
                            Toast.makeText(getApplicationContext(), "Veri başarıyla kaydedildiasdas", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Veri kaydedilirken bir hata oluştu", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {

                    DatabaseHelper databaseHelper = new DatabaseHelper(addpass.this);
                    boolean result = databaseHelper.insertData(name, username, mail, pass, notes,icon,web);
                    if (result) {
                        Toast.makeText(getApplicationContext(), "Veri başarıyla kaydedildi", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Veri kaydedilirken bir hata oluştu", Toast.LENGTH_SHORT).show();
                    }
                    }
                }
            }
        });
    }


}