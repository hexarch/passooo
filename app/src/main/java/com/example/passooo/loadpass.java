package com.example.passooo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextPaint;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class loadpass extends AppCompatActivity {
    ImageButton button ,geri,btnsave;
    String sqlname,sqlusername,sqlmail,sqlpass,sqlnotes,sqlicon,sqlid = "s";
    String username,mail,pass,notes,name,idi,web = null;
    private ImageButton usrCopyButton , mailCopyButton , passCopyButton , notesCopyButton,webCopyButton,webButton;
    String intname,intusername,intmail,intpass,intnotes,intweb;
    int flag = 0;
    private DatabaseHelper databaseHelper;
    private EditText editTextUsername, editTextMail, editTextPass, editTextNotes, editTextName, editTextWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loadpass);
        ListView listView = findViewById(R.id.editTexthistory);
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        List<String> updateTimes = dbHelper.getAllUpdateTimes();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1, updateTimes);
        listView.setAdapter(adapter);
        webButton = findViewById(R.id.webButton);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String websiteUrl = editTextWeb.getText().toString().trim();
                Toast.makeText(getApplicationContext(), "deneme", Toast.LENGTH_SHORT).show();
                if (!websiteUrl.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "deneme2", Toast.LENGTH_SHORT).show();
                    // URL'yi doğru formatta kontrol et
                        websiteUrl = "https://" + websiteUrl; // http:// veya https:// olmadan girilmişse ekle
                    // URL'yi açmak için tarayıcıyı başlat
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                       startActivity(intent);
                }
            }
        });
        editTextWeb = findViewById(R.id.editTextweb);
        webCopyButton = findViewById(R.id.webcopy);
        webCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'ten metni al
                String webText = editTextWeb.getText().toString();
                // Kopyalama işlemi için ClipboardManager kullanımı
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("web", webText);
                clipboard.setPrimaryClip(clip);
            }
        });

        editTextUsername = findViewById(R.id.editTextusername);
        usrCopyButton = findViewById(R.id.usrcopy);
        usrCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'ten metni al
                String usernameText = editTextUsername.getText().toString();
                // Kopyalama işlemi için ClipboardManager kullanımı
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("username", usernameText);
                clipboard.setPrimaryClip(clip);
            }
        });

        editTextMail = findViewById(R.id.editTextmail);
        mailCopyButton = findViewById(R.id.mailcopy);
        mailCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'ten metni al
                String mailText = editTextMail.getText().toString();
                // Kopyalama işlemi için ClipboardManager kullanımı
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("mail", mailText);
                clipboard.setPrimaryClip(clip);
            }
        });

        editTextPass = findViewById(R.id.editTextPassword);
        passCopyButton = findViewById(R.id.passcopy);

        passCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'ten metni al
                String passText = editTextPass.getText().toString();
                // Kopyalama işlemi için ClipboardManager kullanımı
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("password", passText);
                clipboard.setPrimaryClip(clip);
            }
        });

        editTextNotes = findViewById(R.id.editTextnotes);
        notesCopyButton = findViewById(R.id.notescopy);
        notesCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText'ten metni al
                String notesText = editTextNotes.getText().toString();
                // Kopyalama işlemi için ClipboardManager kullanımı
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("notes", notesText);
                clipboard.setPrimaryClip(clip);
            }
        });


        editTextName = findViewById(R.id.editTextTextPersonName);
        editTextUsername = findViewById(R.id.editTextusername);
        editTextMail = findViewById(R.id.editTextmail);
        editTextPass = findViewById(R.id.editTextPassword);
        editTextNotes = findViewById(R.id.editTextnotes);
        editTextWeb = findViewById(R.id.editTextweb);

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
                web = editTextWeb.getText().toString();

                Intent selectionIntent = new Intent(loadpass.this, selecticon.class);
                // Verileri Intent'e ekleyerek aktar
                selectionIntent.putExtra("name", name);
                selectionIntent.putExtra("username", username);
                selectionIntent.putExtra("mail", mail);
                selectionIntent.putExtra("pass", pass);
                selectionIntent.putExtra("notes", notes);
                selectionIntent.putExtra("web", web);

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
            intweb = intent.getStringExtra("web");
            if (intweb != null) {
                editTextWeb.setText(intweb);
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
                String web = editTextWeb.getText().toString();
                String icon = veri.toString();

                idi = intent.getStringExtra("id");
                if (name.isEmpty() || username.isEmpty() || mail.isEmpty() || pass.isEmpty() || notes.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Lütfen tüm alanları doldurunuz", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), ""+sqlid+"     "+idi, Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "update", Toast.LENGTH_SHORT).show();
                        DatabaseHelper databaseHelper = new DatabaseHelper(loadpass.this);
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
            }
        });
    }

}

