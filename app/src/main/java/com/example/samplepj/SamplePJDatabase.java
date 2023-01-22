package com.example.samplepj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SamplePJDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME = "sample_pj.db";
    public static final int DB_VERSION = 1;

    public final String TBL_USER = "tbl_user";
    public final String TBL_STATUS = "tbl_status";

    public SamplePJDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE table " + TBL_USER + "(user_id INTEGER PRIMARY KEY AUTOINCREMENT,user_name TEXT, password TEXT )");
        sqLiteDatabase.execSQL("CREATE table " + TBL_STATUS + "(status_id INTEGER PRIMARY KEY AUTOINCREMENT,user_id INTEGER, status TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public boolean insertUser(String userName, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("user_name", userName);
        cv.put("password", password);

        try {
            db.insert(TBL_USER, null, cv);
            db.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            db.close();
            return false;
        }
    }

    public boolean isUserExist(String userName) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TBL_USER + " WHERE user_name = ?", new String[]{userName});

        return c.getCount() > 0;

    }

    public boolean loginUser(String userName, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TBL_USER + " WHERE user_name = ? AND password = ?", new String[]{userName, password});
        return c.getCount() > 0;
    }
}
