package com.example.a5alumno.ejercicio9_contentprovider.activities.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by A5Alumno on 28/11/2016.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_CREATE_COMMAND = "CREATE TABLE " + ParamsDb.TABLE_NAME + " (" + ParamsDb._ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + ParamsDb.STUDENT_NAME + " TEXT, " + ParamsDb.STUDENT_AGE + " INTEGER);";


    public MyDatabaseHelper(Context context) {
        super(context, ParamsDb.DB_NAME, null, ParamsDb.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyDatabaseHelper.DATABASE_CREATE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
