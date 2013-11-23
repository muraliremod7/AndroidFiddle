package com.example.currency;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Currency currency = Currency.getInstance(Locale.getDefault());

//        final Currency curr = Currency.getInstance("GBP");
//        et1.setText(curr.getSymbol() + "5.00");

        displayCurrencies();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void displayCurrencies(){

        double number = 123456.789;

        Locale[] locales = {

                Locale.UK
        };

        String[] symbols = { "GBP"};
        for (int i = 0; i < locales.length; i++) {
            //
            // Gets currency's formatted value for each locale
            // without change the currency symbol
            //
            DecimalFormat formatter = (DecimalFormat)
                    NumberFormat.getCurrencyInstance(locales[i]);
            String before = formatter.format(number);

            //
            // Create a DecimalFormatSymbols for each locale and sets
            // its new currency symbol.
            //
            DecimalFormatSymbols symbol =
                    new DecimalFormatSymbols(locales[i]);
            symbol.setCurrencySymbol(symbols[i]);

            //
            // Set the new DecimalFormatSymbols into formatter object.
            //
            formatter.setDecimalFormatSymbols(symbol);

            //
            // Gets the formatted value
            //
            String after = formatter.format(number);
            EditText et1 = (EditText) findViewById(R.id.ET1);
            et1.setText(before);
            Log.i("TAG", before + " | after: " + after);
        }
    }
    
}
