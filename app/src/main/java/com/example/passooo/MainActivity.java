package com.example.passooo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button2;
    private ListView listView;
    private DatabaseHelper databaseHelper;
    private ArrayList<String> passwordNames; // Sadece isimleri içeren liste
    private ArrayList<String> passwordIcons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = findViewById(R.id.button2);
        listView = findViewById(R.id.listView);

        databaseHelper = new DatabaseHelper(this);
        passwordNames = new ArrayList<>();
        passwordIcons = new ArrayList<>();

        // Veritabanından isimleri al ve listeye ekle
        loadPasswordsFromDatabase();

        // ArrayAdapter ile ListView'ı doldur
        CustomAdapter adapter = new CustomAdapter(this, passwordNames, passwordIcons);
        listView.setAdapter(adapter);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, addpass.class);
                startActivity(intent);
            }
        });

        // ListView elemanına tıklandığında o öğenin detaylarını göster
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedName = passwordNames.get(position);
                // Burada seçilen öğenin detaylarını göstermek için işlem yapabilirsiniz
                Toast.makeText(MainActivity.this, "Selected: " + selectedName, Toast.LENGTH_SHORT).show();
                Cursor cursor = databaseHelper.getDataByName(selectedName);
                if (cursor != null && cursor.moveToFirst()) {
                    String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
                    String username = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_USERNAME));
                    String mail = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_MAIL));
                    String pass = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD));
                    String notes = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NOTES));
                    String icon = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ICON));
                    String idi = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                    String web = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_WEB));

                    // Intent'e verileri ekleyerek yeni aktiviteyi başlat
                    Intent intent = new Intent(MainActivity.this, loadpass.class);
                    intent.putExtra("name", name);
                    intent.putExtra("username", username);
                    intent.putExtra("mail", mail);
                    intent.putExtra("pass", pass);
                    intent.putExtra("notes", notes);
                    intent.putExtra("anahtar", icon);
                    intent.putExtra("id",idi);
                    intent.putExtra("web",web);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Veri bulunamadı", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadPasswordsFromDatabase() {
        Cursor cursor = databaseHelper.getAllData();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
                String icon = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ICON));

                passwordNames.add(name);
                passwordIcons.add(icon);
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close(); // Cursor'ı kapat
        }
    }
}
