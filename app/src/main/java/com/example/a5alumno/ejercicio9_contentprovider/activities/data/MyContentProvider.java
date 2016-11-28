package com.example.a5alumno.ejercicio9_contentprovider.activities.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

    private static final String TAG = MyContentProvider.class.getSimpleName();
    private static final String PROVIDER_AUTHORITY = "com.example.a5alumno.ejercicio9_contentprovider.activities.data";
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_AUTHORITY);

    private MyDatabaseHelper myDatabaseHelper;

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        SQLiteDatabase db = this.myDatabaseHelper.getWritableDatabase();
        return db.delete(ParamsDb.TABLE_NAME,selection,selectionArgs);
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        SQLiteDatabase db = this.myDatabaseHelper.getReadableDatabase();

        long regId = db.insert(ParamsDb.TABLE_NAME, null, values); //Pide nombre de la tabla, número de columnas a insertar y sus valores

        return ContentUris.withAppendedId(MyContentProvider.CONTENT_URI, regId); //tiene que devolver una uri, le añade el identificador
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.

        this.myDatabaseHelper = new MyDatabaseHelper(this.getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.

        SQLiteDatabase db = myDatabaseHelper.getReadableDatabase();
        return db.query(ParamsDb.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
