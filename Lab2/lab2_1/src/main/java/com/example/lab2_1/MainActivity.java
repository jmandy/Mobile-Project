package com.example.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button add_btn;
    EditText Name;
    EditText Age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn=(Button)findViewById(R.id.btn);//find button which is enrolled in xml file
        Name=(EditText)findViewById(R.id.text1);//find Name EditText which is enrolled in xml file
        Age=(EditText)findViewById(R.id.text2) ;//find age EditText which is enrolled in xml file

        add_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {//button clicked event handling, if button is clicked then, two string is given to NewActivity class
                String name=Name.getText().toString();//get String in editText
                String age=Age.getText().toString();//get String in editText

                Intent intent = new Intent (getApplicationContext(), NewActivity.class);//create intent
                intent.putExtra("loginName", name);//put name String in intent
                intent.putExtra("loginAge", age);//put age String in intent
                startActivity(intent);// if button is clicked then, NewActivity is going to begin.

            }
        });
    }
}
