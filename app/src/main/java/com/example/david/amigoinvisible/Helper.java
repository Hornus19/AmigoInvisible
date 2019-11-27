package com.example.david.amigoinvisible;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper extends SQLiteOpenHelper {

    private static final String DB_NAME = "friend.sqlite";
    private static final int DB_VERSION = 1;
    public Helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS USER(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user TEXT NULL ," +
                "name TEXT NOT NULL ," +
                "pass TEXT NULL," +
                "group INTEGER NOT NULL," +
                "amigo INTEGER NULL," +
                "admin INTEGER NOT NULL," +
                "UNIQUE(id))");
        db.execSQL("CREATE TABLE IF NOT EXISTS group(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL ," +
                "pass TEXT NOT NULL ," +
                "diner TEXT NOT NULL," +
                "fecha TEXT NOT NULL," +
                "UNIQUE(id))");

        ContentValues cv = new ContentValues();
        cv.put("user", "hornus");
        cv.put("name", "Grande");
        cv.put("pass", "abc123");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Brais");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Juncal");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Carla");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Gemma");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Ada");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Daniela");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Pablo");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Dani");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Marta");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Luis");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Vila");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Yaiza");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Sheyla");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Paz");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Carmen");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Tony");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Noe");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Jaco");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);
        cv = new ContentValues();
        cv.put("name", "Bea");
        cv.put("group", "BackOffice");
        cv.put("admin", "1");
        db.insert("user", null, cv);


        //group
        cv = new ContentValues();
        cv.put("name", "BackOffice");
        cv.put("pass", "BONM14");
        cv.put("diner", "5");
        cv.put("fecha", "07/01/2020");
        db.insert("group", null, cv);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }


}
