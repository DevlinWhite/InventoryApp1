package com.example.android.inventoryapp1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.inventoryapp1.data.ClothesContract.ClothesEntry;

/**
 * Database helper for Pets app. Manages database creation and version management.
 */
public class ClothesdbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = ClothesdbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "clothes.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link ClothesdbHelper}.
     *
     * @param context of the app
     */
    public ClothesdbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_CLOTHES_TABLE =  "CREATE TABLE " + ClothesEntry.TABLE_NAME + " ("
                +ClothesEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT "
                + ClothesEntry._PRICE + " INTEGER NOT NULL, "
                + ClothesEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, "
                + ClothesEntry.COLUMN_QTY + " INTEGER NOT NULL, "
                + ClothesEntry.COLUMN_SUPP_NAME + " TEXT, "
                + ClothesEntry.COLUMN_SUPP_PHONENUMBER + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_CLOTHES_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}