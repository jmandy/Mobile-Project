package com.example.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText edit_text;
    RadioGroup gender;
    RadioButton radio_btn1;
    RadioButton radio_btn2;
    CheckBox check_btn1;
    CheckBox check_btn2;
    Button enroll_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get button
        edit_text = findViewById(R.id.entry1);
        gender = findViewById(R.id.gender);
        radio_btn1 = findViewById(R.id.man);
        radio_btn2 = findViewById(R.id.woman);
        check_btn1 = findViewById(R.id.email);
        check_btn2 = findViewById(R.id.sms);
        enroll_btn = findViewById(R.id.enroll);

        enroll_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_text.getText().toString();
                String gen = "";
                String connect = "";


                int radioId = gender.getCheckedRadioButtonId();//get radio ID

                if (radio_btn1.getId() == radioId){//if radio1 is checked
                    gen = radio_btn1.getText().toString();
                }
                if (radio_btn2.getId() == radioId){///if radio2 is checked
                    gen = radio_btn2.getText().toString();
                }
                if (check_btn1.isChecked()) {//check_btn1(SMS)
                    connect += (" " + check_btn1.getText().toString());
                }
                if (check_btn2.isChecked()) {//check_btn2(email)
                    connect += (" " + check_btn2.getText().toString());
                }
                //make new Intent to convert display
                Intent intent = new Intent (getApplicationContext(),NewActivity.class);

                intent.putExtra("name",name);//put name in Intent
                intent.putExtra("gender",gen);//put gender in Intent
                intent.putExtra("connect",connect);//put connect in Intent

                startActivityForResult(intent,1);//change activity
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Return to first display(default)
        edit_text.setText("");
        gender.clearCheck();
        check_btn1.setChecked(false);
        check_btn2.setChecked(false);
    }
}

