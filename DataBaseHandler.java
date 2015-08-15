package com.mycompany.samplelogin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Utsav on 7/27/2015.
 *
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.android.volley.RequestQueue;
// insert
// delete
// create table name
// update

public class DataBaseHandler {

    private final static String DATABASE_NAME = "login.db",
            TABLE_name = "Users",
            key_id = "id",
            key_user = "User",
            key_pw = "Password";

    private static final int DB_verision = 1;

    public final static String create_table = " CREATE TABLE " + TABLE_name + " ( " + key_id + " INTEGER PRIMARY KEY, " + key_user + " TEXT," + key_pw + " TEXT " + ") ";
    public static SQLiteDatabase db;
    private final Context context;
    private DataBaseHelper dbHelper;


    public DataBaseHandler open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public DataBaseHandler(Context _context) {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DB_verision);
    }

    public void insertEntry(String username, String password) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("User", username);
        contentValues.put("Password", password);
        db.insert(TABLE_name, null, contentValues);
        Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }

    public static String getPassword(String username) {
        Cursor cursor = db.query(TABLE_name, null, key_user + " =? ", new String[]{username}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return " Man WTF you tryna do";
        }

        cursor.moveToFirst();
        String pw = cursor.getString(cursor.getColumnIndex(key_pw));
        cursor.close();
        return pw;

    }

    public void updateEntry(String userName, String password)
    {
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD",password);

        String where="User = ?";
        db.update(TABLE_name,updatedValues,where,new String[]{userName} );

    }


    public void close()
    {
        db.close();
    }

}