package com.mycompany.samplelogin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Utsav on 7/28/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context, String name,SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(DataBaseHandler.create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w("TaskDBAdapter", "Upgrading from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");

        // Upgrade the existing database to conform to the new version. Multiple
        // previous versions can be handled by comparing _oldVersion and _newVersion
        // values.
        // The simplest case is to drop the old table and create a new one.
        db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
        // Create a new one.
        onCreate(db);

    }
}
