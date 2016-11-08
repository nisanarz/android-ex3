package com.example.nisan.ex3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText numInputText;
    private CheckBox foodCheckbox;
    private Button orderButton;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar_id);
        setSupportActionBar(toolBar);

        numInputText = (EditText) findViewById(R.id.input_id);
        foodCheckbox = (CheckBox) findViewById(R.id.checkbox_id);
        orderButton = (Button) findViewById(R.id.button_id);
        seekBar = (SeekBar) findViewById(R.id.seek_id);

        numInputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                checkButtonValid();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputText = (String) s.toString();
                double sheep_num = 0;
                if (inputText.length() > 0 || (inputText.length() > 0 && inputText.length() < 10)) {
                    sheep_num = Double.parseDouble(inputText);
                }
                if (sheep_num >100){
                    seekBar.setProgress(seekBar.getMax());
                }
                else {
                    seekBar.setProgress((int)sheep_num);
                }
                checkButtonValid();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                progressChanged = progress;
                String str = Integer.toString(progressChanged);
                if (fromUser){
                    if (progressChanged == 0){
                        numInputText.setText("");
                        return;
                    }
                    numInputText.setText(str);
                    numInputText.setSelection(str.length());
                    checkButtonValid();
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        foodCheckbox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkButtonValid();
            }
        });

    }

    public void makeOrder(View view){
        orderButton = (Button) findViewById(R.id.button_id);
        numInputText = (EditText) findViewById(R.id.input_id);
        foodCheckbox = (CheckBox) findViewById(R.id.checkbox_id);

        //Toast.makeText(getApplicationContext(),"Order sent",Toast.LENGTH_SHORT).show();
        orderButton.setEnabled(false);
        numInputText.setText("");
        foodCheckbox.setChecked(false);

        Intent intent = new Intent(this, OrderSendActivity.class);
        startActivity(intent);

    }

    private void checkButtonValid(){
        if (foodCheckbox.isChecked() && checkEditTextInput(numInputText)){
            orderButton.setEnabled(true);
        }
        else {
            orderButton.setEnabled(false);
        }
    }

    private boolean checkEditTextInput(EditText et){
        String text = et.getText().toString();
        double sheep_num = 0;
        boolean flag=false;
        if (text.length() > 0 || (text.length() > 0 && text.length() < 10)) {

            sheep_num = Double.parseDouble(text);//Integer.parseInt(text);
            if (sheep_num > 0 && sheep_num < Integer.MAX_VALUE) {
                return true;
            }
            else {
                flag=false;
            }
        }
        return flag;
    }

}
