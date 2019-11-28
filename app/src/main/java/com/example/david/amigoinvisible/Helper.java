package com.example.david.amigoinvisible;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Helper extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/com.example.david.amigoinvisible/databases/";
    private SQLiteDatabase myDataBase;
    private static final String DB_NAME = "AmigoInvisible.db";
    private static final int DB_VERSION = 1;
    public Helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        BaseDeDatos db2 = new BaseDeDatos(this, DB_NAME, null, DB_VERSION);
        try {
            db.createDataBase();
            db.openDataBase();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public void createDataBase() throws IOException {

        boolean dbExist = false;
        try {
            dbExist = checkDataBase();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        if (dbExist) {
            // Si existe, no haemos nada!
        } else {
            // Llamando a este método se crea la base de datos vacía en la ruta
            // por defecto del sistema de nuestra aplicación por lo que
            // podremos sobreescribirla con nuestra base de datos.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copiando database");
            }
        }
    }

    private boolean checkDataBase() throws Throwable {

        SQLiteDatabase checkDB = null;

        String myPath = DB_PATH + DB_NAME;
        checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        if (checkDB != null) {

            checkDB.close();
        }

        return checkDB != null ? true : false;

    }
    public void openDataBase() throws Throwable {

        // Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }
    private void copyDataBase() throws IOException {

        OutputStream databaseOutputStream = new FileOutputStream("" + DB_PATH + DB_NAME);
        InputStream databaseInputStream;

        byte[] buffer = new byte[1024];
        int length;

        databaseInputStream = myContext.getAssets().open("MiPrimeraBD");
        while ((length = databaseInputStream.read(buffer)) > 0) {
            databaseOutputStream.write(buffer);
        }

        databaseInputStream.close();
        databaseOutputStream.flush();
        databaseOutputStream.close();
    }

}
