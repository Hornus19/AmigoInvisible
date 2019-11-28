package com.example.david.amigoinvisible;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by davgra3049 on 28/11/2019.
 */

public class Acceso {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static Acceso instance;
    Cursor c=null;

    private Acceso(Context context){
        this.openHelper= new Helper(context);
    }
    public static  Acceso getInstance(Context contexto){
            if(instance==null){
                instance= new Acceso(contexto);
            }

            return instance;
    }

    public void open(){
        this.db= openHelper.getWritableDatabase();
    }

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }

    public Cursor getAddress(String user){
        c=db.rawQuery("select pass,group,amigo where user from user='" + user + "'", null);
        return c;
    }

    public Cursor friend(Cursor cursor){
        Cursor g = db.rawQuery("select diner, fecha from group where id='" + cursor.getString(cursor.getColumnIndex("group")) + "'", null);

        return g;
    }
}
