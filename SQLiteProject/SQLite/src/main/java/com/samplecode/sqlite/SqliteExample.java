package com.samplecode.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import com.samplecode.db.PersonDBOpenHelper;
import com.samplecode.db.PersonDataSource;

public class SqliteExample extends Activity {

    private PersonDataSource personDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqliteexample);
        personDataSource = new PersonDataSource(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        personDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        personDataSource.open();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sqlite_example, menu);
        return true;
    }
    
}
