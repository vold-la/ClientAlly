package com.felngss.ClientApp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "customer.db";
    private static final int DATABASE_VERSION = 1;
    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    String SQL_CREATE_TABLE = "CREATE TABLE "+ClientContract.CustomerEntry.TABLE_NAME+" ("
            + ClientContract.CustomerEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ClientContract.CustomerEntry.CUSTOMER_NAME + " TEXT NOT NULL,"
            + ClientContract.CustomerEntry.PHONE + " INTEGER NOT NULL,"
            + ClientContract.CustomerEntry.EMAIL + " TEXT,"
            + ClientContract.CustomerEntry.LAST_VISITED + " TEXT,"
            + ClientContract.CustomerEntry.VISITED_FOR + " TEXT,"
            + ClientContract.CustomerEntry.AMOUNT_DUE_FOR_PAYMENT + " INTEGER);";
    String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + ClientContract.CustomerEntry.TABLE_NAME;




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);
    }

}
