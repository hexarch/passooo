package com.example.passooo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Veritabanı adı ve sürümü
    private static final String DATABASE_NAME = "passwords.db";
    private static final int DATABASE_VERSION = 1;

    // Tablo adı ve sütun isimleri
    public static final String TABLE_NAME = "passwords";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_USERNAME = "username";
    public static final String COL_MAIL = "mail";
    public static final String COL_PASSWORD = "password";
    public static final String COL_NOTES = "notes";

    public static final String COL_WEB = "web";
    public static final String COL_ICON = "icon";
    public static final String COL_UPDATE_TIME = "update_time";

    // Tablo oluşturma sorgusu
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NAME + " TEXT, " +
                    COL_USERNAME + " TEXT, " +
                    COL_MAIL + " TEXT, " +
                    COL_PASSWORD + " TEXT, " +
                    COL_NOTES + " TEXT, " +
                    COL_WEB + " TEXT, " +
                    COL_ICON + " TEXT, " +
                    COL_UPDATE_TIME + " TEXT)";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Veritabanı oluşturma işlemi
        try {
            db.execSQL(CREATE_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Veritabanı sürümü değişikliği durumunda, mevcut tabloyu yeniden oluştur
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Yeni veri ekleme işlemi
    public boolean insertData(String name, String username, String mail, String password, String notes,String icon, String web) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_USERNAME, username);
        values.put(COL_MAIL, mail);
        values.put(COL_PASSWORD, password);
        values.put(COL_ICON, icon);
        values.put(COL_WEB, web);
        values.put(COL_NOTES, notes);
        values.put(COL_UPDATE_TIME, getCurrentDateTime());
        long result = db.insert(TABLE_NAME, null, values);
        // Ekleme işlemi başarılıysa true döner
        return result != -1;
    }
    // DatabaseHelper sınıfı içinde
    public Cursor getDataByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, null, COL_NAME + "=?", new String[]{name}, null, null, null);
    }


    // Veritabanından tüm verileri getirme işlemi
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }



    // Belirli bir veriyi güncelleme işlemi
    public boolean updateData(String id, String name, String username, String mail, String password, String notes, String icon, String web) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_USERNAME, username);
        values.put(COL_MAIL, mail);
        values.put(COL_PASSWORD, password);
        values.put(COL_ICON, icon);
        values.put(COL_WEB, web);
        values.put(COL_NOTES, notes);
        values.put(COL_UPDATE_TIME, getCurrentDateTime());
        // İlgili ID'ye sahip veriyi güncelle
        int rowsAffected = db.update(TABLE_NAME, values, COL_ID + "=?", new String[]{id});
        return rowsAffected > 0;
    }


    // Belirli bir veriyi silme işlemi
    public boolean deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        // İlgili ID'ye sahip veriyi sil
        int rowsAffected = db.delete(TABLE_NAME, COL_ID + "=?", new String[]{id});
        return rowsAffected > 0;
    }
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

    public List<String> getAllUpdateTimes() {
        List<String> updateTimes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COL_UPDATE_TIME + " FROM " + TABLE_NAME, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String updateTime = cursor.getString(cursor.getColumnIndex(COL_UPDATE_TIME));
                updateTimes.add(updateTime);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return updateTimes;
    }



}
