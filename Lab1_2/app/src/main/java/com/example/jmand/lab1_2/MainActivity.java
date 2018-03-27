package com.example.jmand.lab1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public EditText edit_name;
    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//Conduct Layout Inflation by using setContentView method

        init();

    }

    //function: find components by using component's id
    //R.id.000 ,  000 is id which is defined in xml file
    public void init() {

        edit_name = (EditText) findViewById(R.id.edit);
        btn_print = (Button) findViewById(R.id.btn2);
        btn_clear = (Button) findViewById(R.id.btn1);
        view_print = (TextView) findViewById(R.id.text);

    }

    //clear button
    // in xml file , I defined the clear button's click event which name is onButton1Clicked
    public void onButton1Clicked(View v) {
        edit_name.setText("");//when button clicked, then clear the text
        setTextView(); //call the setTextview function
    }

    //PRINT button
    // in xml file , I defined the clear button's click event which name is onButton2Clicked
    public void onButton2Clicked(View v) {
        setTextView();
    }

    // set TextView which is typed in EditText
    private void setTextView() {
        String getString = edit_name.getText().toString();//get EditText's String
        view_print.setText(getString);//print the text which is got from edit text in the TextView
    }
}