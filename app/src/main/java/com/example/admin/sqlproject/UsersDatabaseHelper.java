package com.example.admin.sqlproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 4/11/2016.
 */
public class UsersDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "usersDB";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "users";

    public static final String KEY_USER_ID = "id";
    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_AGE = "age";

    public UsersDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
