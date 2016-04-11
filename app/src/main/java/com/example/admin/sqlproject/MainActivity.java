package com.example.admin.sqlproject;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String EXAMPLE_NAME = "Etienne";
    private static final String EXAMPLE_AGE = "83";

    private static final String EXAMPLE_NAME1 = "Saulo";

    private static final String EXAMPLE_NAME2 = "Benjamin";

    private static final String EXAMPLE_NAME3 = "Miguel";

    private static final String TAG = "MainActivityTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSql(View v){
        UsersDatabaseHelper usersDatabaseHelper = new UsersDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = usersDatabaseHelper.getWritableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(UsersDatabaseHelper.KEY_USER_NAME, EXAMPLE_NAME);
            values.put(UsersDatabaseHelper.KEY_AGE, EXAMPLE_AGE);

            db.insertOrThrow(UsersDatabaseHelper.TABLE_USERS, null, values);


            ContentValues values1 = new ContentValues();
            values.put(UsersDatabaseHelper.KEY_USER_NAME, EXAMPLE_NAME1);
            values.put(UsersDatabaseHelper.KEY_AGE, EXAMPLE_AGE);

            db.insertOrThrow(UsersDatabaseHelper.TABLE_USERS, null, values1);

            ContentValues values2 = new ContentValues();
            values.put(UsersDatabaseHelper.KEY_USER_NAME, EXAMPLE_NAME2);
            values.put(UsersDatabaseHelper.KEY_AGE, EXAMPLE_AGE);

            db.insertOrThrow(UsersDatabaseHelper.TABLE_USERS, null, values2);

            ContentValues values3 = new ContentValues();
            values.put(UsersDatabaseHelper.KEY_USER_NAME, EXAMPLE_NAME3);
            values.put(UsersDatabaseHelper.KEY_AGE, EXAMPLE_AGE);

            db.insertOrThrow(UsersDatabaseHelper.TABLE_USERS, null, values3);
        } catch (Exception e) {
            Log.e(TAG, "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }

    public void logInformation(View view) {
        UsersDatabaseHelper usersDatabaseHelper = new UsersDatabaseHelper(getApplicationContext());

        final String POSTS_SELECT_QUERY = "SELECT * FROM users";

        SQLiteDatabase db = usersDatabaseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(POSTS_SELECT_QUERY, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    String nameUser = cursor.getString(cursor.getColumnIndex(UsersDatabaseHelper.KEY_USER_NAME));
                    String ageUser = cursor.getString(cursor.getColumnIndex(UsersDatabaseHelper.KEY_USER_ID));

                    Log.d(TAG, "logInformation: " + nameUser);
                    Log.d(TAG, "logInformation: " + ageUser);

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
    }
}
