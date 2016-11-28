package com.example.a5alumno.ejercicio9_contentprovider.activities.activities;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a5alumno.ejercicio9_contentprovider.R;
import com.example.a5alumno.ejercicio9_contentprovider.activities.data.MyContentProvider;
import com.example.a5alumno.ejercicio9_contentprovider.activities.data.MyDatabaseHelper;
import com.example.a5alumno.ejercicio9_contentprovider.activities.data.ParamsDb;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText edtName;
    private EditText edtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnQueryDb = (Button) this.findViewById(R.id.btn_query_db);
        btnQueryDb.setOnClickListener(this);
        Button btnAddDb = (Button) this.findViewById(R.id.btn_add_db);
        btnAddDb.setOnClickListener(this);
        Button btnDeleteDb = (Button) this.findViewById(R.id.btn_delete_db);
        btnDeleteDb.setOnClickListener(this);

        this.edtName = (EditText) this.findViewById(R.id.edtTxtName);
        this.edtAge = (EditText) this.findViewById(R.id.edtTxtAge);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_query_db:
                Cursor queryCursor = getContentResolver().query(MyContentProvider.CONTENT_URI,null,null,null,null);
                StringBuilder dbContent = new StringBuilder("");

                while (queryCursor.moveToNext()){
                    dbContent.append("\n"
                            + queryCursor.getString(queryCursor.getColumnIndex(ParamsDb._ID)) /* queryCursor.getColumnIndex(ParamsDb._ID) RETORNA EL NÚMERO DE LA COLUMNA   */
                            + " " + queryCursor.getString(queryCursor.getColumnIndex(ParamsDb.STUDENT_NAME))
                            + " "+ queryCursor.getInt(queryCursor.getColumnIndex(ParamsDb.STUDENT_AGE))); //Poner los valores de la tabla en el string builder
                }

                Toast.makeText(this,dbContent.toString(),Toast.LENGTH_LONG).show();

                queryCursor.close();

                break;
            case R.id.btn_add_db:


                ContentValues insertValues = new ContentValues();
                insertValues.put(ParamsDb.STUDENT_NAME, this.edtName.getText().toString());
                insertValues.put(ParamsDb.STUDENT_AGE, this.edtAge.getText().toString());

                Uri insertUri = getContentResolver().insert(MyContentProvider.CONTENT_URI, insertValues);
                Toast.makeText(this,"Name: " + edtName.getText().toString() + ", Age: " +edtAge.getText().toString() + " added to database",Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_delete_db:

                String whereCond = ParamsDb.STUDENT_NAME + "=?";
                String [] whereCondArgs = {this.edtName.getText().toString()};

                //int deleteCursor = getContentResolver().delete(MyContentProvider.CONTENT_URI,"name='"+edtName.getText().toString()+"'",null);

                int deleteCursor = getContentResolver().delete(MyContentProvider.CONTENT_URI,whereCond,whereCondArgs);
                Toast.makeText(this,edtName.getText().toString() + " had " + deleteCursor + " number of rows deleted",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
