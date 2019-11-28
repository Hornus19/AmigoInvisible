package com.example.david.amigoinvisible;


import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Helper extends SQLiteAssetHelper {

    private static final String DB_NAME = "AmigoInvisible.db";
    private static final int DB_VERSION = 1;

    public Helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }
}
