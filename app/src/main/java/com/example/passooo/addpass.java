package com.example.passooo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Objects;
public class addpass extends AppCompatActivity {
    ImageButton button ,geri,btnsave;
    String sqlname,sqlusername,sqlmail,sqlpass,sqlnotes,sqlicon,sqlid = "s";
    String username,mail,pass,notes,name,idi ,web = null;
    private ProgressBar progressBar;
    public   int strength = 0;
    String intname,intusername,intmail,intpass,intnotes,intwebsite;
    int flag = 0;
    private DatabaseHelper databaseHelper;
    private EditText editTextUsername, editTextMail, editTextPass, editTextNotes, editTextName, editTextWebsite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpass);
        progressBar = findViewById(R.id.horizontalProgressBar);
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
                    showPasswordButton.setImageResource(R.drawable.closeeye);
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

            switch (veri) {
                case "Adobe":
                    button.setImageResource(R.drawable.adobe100x100);
                    break;
                case "Airbnb":
                    button.setImageResource(R.drawable.airbnb100x100);
                    break;
                case "Amazon":
                    button.setImageResource(R.drawable.amazon100x100);
                    break;
                case "Android":
                    button.setImageResource(R.drawable.android100x100);
                    break;
                case "Apple":
                    button.setImageResource(R.drawable.appel100x100);
                    break;
                case "Atlassian":
                    button.setImageResource(R.drawable.atlassian100x100);
                    break;
                case "Bitbucket":
                    button.setImageResource(R.drawable.bitbucker100x100);
                    break;
                case "Bitcoin":
                    button.setImageResource(R.drawable.bitcoin100x100);
                    break;
                case "Blogger":
                    button.setImageResource(R.drawable.blogger100x100);
                    break;
                case "Discord":
                    button.setImageResource(R.drawable.discord100x100);
                    break;
                case "Dropbox":
                    button.setImageResource(R.drawable.dropbox100x100);
                    break;
                case "Ebay":
                    button.setImageResource(R.drawable.ebay100x100);
                    break;
                case "Epic":
                    button.setImageResource(R.drawable.epic100x100);
                    break;
                case "Facebook":
                    button.setImageResource(R.drawable.facebook);
                    break;
                case "Flickr":
                    button.setImageResource(R.drawable.flickr100x100);
                    break;
                case "Github":
                    button.setImageResource(R.drawable.github100x100);
                    break;
                case "Gmail":
                    button.setImageResource(R.drawable.gmail100x100);
                    break;
                case "Google":
                    button.setImageResource(R.drawable.google100x100);
                    break;
                case "Huawei":
                    button.setImageResource(R.drawable.huawei100x100);
                    break;
                case "Instagram":
                    button.setImageResource(R.drawable.instagramicon150x150);
                    break;
                case "Linkedin":
                    button.setImageResource(R.drawable.linkedln100x100);
                    break;
                case "Microsoft":
                    button.setImageResource(R.drawable.microsoft100x100);
                    break;
                case "Netflix":
                    button.setImageResource(R.drawable.netflix100x100);
                    break;
                case "Mastercard":
                    button.setImageResource(R.drawable.mastercard100x100);
                    break;
                case "Nintendo":
                    button.setImageResource(R.drawable.nintendo100x100);
                    break;
                case "Paypal":
                    button.setImageResource(R.drawable.paypal100x100);
                    break;
                case "Playstation":
                    button.setImageResource(R.drawable.playstation100x100);
                    break;
                case "Reddit":
                    button.setImageResource(R.drawable.redditicon150x150);
                    break;
                case "Skype":
                    button.setImageResource(R.drawable.skype100x100);
                    break;
                case "Slack":
                    button.setImageResource(R.drawable.slack100x100);
                    break;
                case "Snapchat":
                    button.setImageResource(R.drawable.snapchat100x100);
                    break;
                case "Spotify":
                    button.setImageResource(R.drawable.spotify100x100);
                    break;
                case "Steam":
                    button.setImageResource(R.drawable.steamicon2);
                    break;
                case "Teamviewer":
                    button.setImageResource(R.drawable.teamviewer100x100);
                    break;
                case "Telegram":
                    button.setImageResource(R.drawable.telegram100x100);
                    break;
                case "Tinder":
                    button.setImageResource(R.drawable.tinder100x100);
                    break;
                case "Tumblr":
                    button.setImageResource(R.drawable.tumblr100x100);
                    break;
                case "Twitch":
                    button.setImageResource(R.drawable.twitch100x100);
                    break;
                case "X":
                    button.setImageResource(R.drawable.twittericon150x150);
                    break;
                case "Visa":
                    button.setImageResource(R.drawable.visa100x100);
                    break;
                case "Vk":
                    button.setImageResource(R.drawable.vk100x100);
                    break;
                case "We Chat":
                    button.setImageResource(R.drawable.wechat100x100);
                    break;
                case "Windows":
                    button.setImageResource(R.drawable.windows100x100);
                    break;
                case "Xbox":
                    button.setImageResource(R.drawable.xbox100x100);
                    break;
                case "Xiaomi":
                    button.setImageResource(R.drawable.xiaomi100x100);
                    break;
                case "Youtube":
                    button.setImageResource(R.drawable.youtube100x100);
                    break;
                case "Zoom":
                    button.setImageResource(R.drawable.zoom100x100);
                    break;

                default:
                    // Belirli bir duruma göre resim atanmadıysa varsayılan işlem yapılabilir
                    break;
            }
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





        editTextPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Metin değişmeden önceki durum
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Metin değiştiği zaman çağrılır
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Metin değiştikten sonra çağrılır
                String password = s.toString();
                int passwordStrength = calculatePasswordStrength(password);

                // Zorluk seviyesine göre mesaj oluştur
                String message = getMessageByPasswordStrength(passwordStrength);

                // Mesajı ekrana göster
                Toast.makeText(addpass.this, message, Toast.LENGTH_SHORT).show();
                int progressValue = 0;
                progressBar.setProgress(progressValue);
                progressBar.setMax(100);
                updateProgressBarColor(progressBar, progressValue);
            }
        });
    }

    private int calculatePasswordStrength(String password) {
        // Şifrenin zorluk seviyesini hesapla
        // Örnek: Şifrenin zorluk seviyesini belirlemek için belirli kriterleri değerlendir
        // Burada kendi zorluk seviyesi hesaplama mantığınızı uygulayabilirsiniz
        // Örneğin, uzunluk, harf/karakter tipleri, rakam içeriği, özel karakterler, vb. değerlendirilebilir


        // Örnek bir zorluk seviyesi hesaplama algoritması
        if (password.length() >= 8) {
            strength += 20;
        }
        if (containsUpperCase(password)) {
            strength += 20;
        }
        if (containsLowerCase(password)) {
            strength += 20;
        }
        if (containsDigit(password)) {
            strength += 20;
        }
        if (containsSpecialCharacter(password)) {
            strength += 20;
        }

        return strength;
    }

    private boolean containsUpperCase(String password) {
        // Büyük harf kontrolü
        return !password.equals(password.toLowerCase());
    }

    private boolean containsLowerCase(String password) {
        // Küçük harf kontrolü
        return !password.equals(password.toUpperCase());
    }

    private boolean containsDigit(String password) {
        // Rakam kontrolü
        return password.matches(".*\\d.*");
    }

    private boolean containsSpecialCharacter(String password) {
        // Özel karakter kontrolü
        return !password.matches("[A-Za-z0-9 ]*");
    }

    private String getMessageByPasswordStrength(int strength) {
        // Zorluk seviyesine göre mesaj oluştur
        if (strength >= 80) {
            return "Şifreniz çok güçlü!";
        } else if (strength >= 60) {
            return "Şifreniz güçlü!";
        } else if (strength >= 40) {
            return "Şifreniz orta güçte.";
        } else {
            return "Şifreniz zayıf, daha güçlü bir şifre oluşturun!";
        }
    }

    private void updateProgressBarColor(ProgressBar progressBar, int progressValue) {
        // İlerleme değerine göre progress bar rengini güncelle
        if (progressValue < 40) {
            progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.custom_progress_bar));
        } else if (progressValue < 60) {
            progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.custom_progress_bar_yellow));
        } else {
            progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.custom_progress_bar_green));
        }
    }
    }

