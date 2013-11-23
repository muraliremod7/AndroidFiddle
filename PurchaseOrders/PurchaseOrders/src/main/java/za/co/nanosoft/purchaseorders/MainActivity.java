package za.co.nanosoft.purchaseorders;

import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = openOrCreateDatabase("PO", MODE_PRIVATE, null);

//
//        String sqlString = "create table if not exists suppliers(" +
//                "    id integer primary key autoincrement not null," +
//                "    name varchar(100) not null" +
//                ");";

       // db.execSQL(sqlString);

         String sqlString = "insert into suppliers(name) values('Paul')";

        db.execSQL(sqlString);

        Cursor c = db.rawQuery("select * from suppliers", null);
        c.moveToFirst();
        Log.d("results", c.getString(c.getColumnIndex("name")));
        db.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
