package com.samplecode.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnFiles(View view){
        Intent intent = new Intent(this, FilesExample.class);
        startActivity(intent);
    }


    public void onClickBtnSqlite(View view){
        Intent intent = new Intent(this, SqliteExample.class);
        startActivity(intent);
    }




}
