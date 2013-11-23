package com.samplecode.sqlite;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class FilesExample extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_example);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.files_example, menu);
        return true;
    }
    
}
