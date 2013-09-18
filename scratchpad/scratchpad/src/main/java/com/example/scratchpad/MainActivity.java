package com.example.scratchpad;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    //private declaration of UI elements
    private SeekBar tipPercentageSlider;
    private TextView tipPercentageLabel;
    private EditText amountEditText;
    private EditText tipEditText;
    private String[] percent = { "0", "10", "12.5", "15", "17.5", "20",  "25", "30" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Instantiate Reference to Elements
        tipPercentageSlider =  (SeekBar) findViewById(R.id.tipslide);
        tipPercentageLabel  = (TextView) findViewById(R.id.tipLabel);
        amountEditText =  (EditText) findViewById(R.id.amount);
        tipEditText = (EditText) findViewById(R.id.tipamount);

        //Initialise
        amountEditText.setText("1000"); //set main ET to 1000
        tipPercentageSlider.setProgress(2); //set the default tip % to 12 %

        setTipPercentageLabel(2);
        setTipValue(); //set the tip amount

        //Listeners
        tipPercentageSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //set the tip percentage
                setTipPercentageLabel();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //set the tip amount
                //
                setTipValue();

            }
        });

        tipEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setTipPercentageLabel();



            }
        });

        amountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(amountEditText.getText().toString().trim().length() > 0){
                    setTipValue();
                }else
                {
                    tipEditText.setText("");
                }

            }
        });
    }

    private void setTipValue() {
        //get the amount
        double amount = Double.parseDouble(String.valueOf(amountEditText.getText()));

        //get percentage
        double tipPercentage = Double.parseDouble(String.valueOf(percent[tipPercentageSlider.getProgress()]));

        double tip = amount * (tipPercentage/100);
        tipEditText.setText(FormatMoney(tip));

    }

    private String FormatMoney(double number){
        DecimalFormat df = new DecimalFormat("##0.00");
        String result = df.format(number);
        return result;

    }

    private String FormatPercentage(double number){
        DecimalFormat df = new DecimalFormat("#0.#");
        String result = df.format(number);
        return result;

    }

    private void setTipPercentageLabel() {
        double tip = Double.parseDouble(String.valueOf(tipEditText.getText().toString()));
        double amount  = Double.parseDouble(String.valueOf(amountEditText.getText().toString()));
        double percentage = (tip/amount ) *100;
        String x = "Tip (" + FormatPercentage(percentage) + " %)";
        tipPercentageLabel.setText(x);
    }

    private void setTipPercentageLabel(int position) {
        String x = "Tip (" + Double.parseDouble(percent[position]) + " %)";
        tipPercentageLabel.setText(x);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
