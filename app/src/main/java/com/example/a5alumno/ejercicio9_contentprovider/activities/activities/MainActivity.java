package com.example.a5alumno.ejercicio9_contentprovider.activities.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a5alumno.ejercicio9_contentprovider.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

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

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_query_db:

                break;
            case R.id.btn_add_db:
                break;
            case R.id.btn_delete_db:
                break;
        }
    }
}
