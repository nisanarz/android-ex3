package com.example.nisan.ex3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;



public class SelectFoodActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.nisan.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_food);


        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar_id);
        setSupportActionBar(toolBar);
    }

    public void makeSelection(View view){
        Intent intent = new Intent(this, MainActivity.class);
        TextView editText = (TextView) findViewById(R.id.new_id);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
