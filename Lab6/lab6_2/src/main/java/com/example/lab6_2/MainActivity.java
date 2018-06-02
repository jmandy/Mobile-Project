package com.example.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText studentnum_text, name_text;
    Button call_btn, save_btn, init_btn;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    String input_num, input_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentnum_text = (EditText) findViewById(R.id.edit1);
        name_text = (EditText) findViewById(R.id.edit2);
        call_btn = (Button) findViewById(R.id.btn1);
        save_btn = (Button) findViewById(R.id.btn2);
        init_btn = (Button) findViewById(R.id.btn3);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_num = name_text.getText().toString();
                input_name = studentnum_text.getText().toString();
                sharedPrefernces();
            }
        });

        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applySharedPreference();
            }
        });

        init_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentnum_text.setText("");
                name_text.setText("");
            }
        });

    }


    public void sharedPrefernces(){
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("Username", input_name);
        toEdit.putString("UserNum", input_num);
        toEdit.commit();
    }


    public void applySharedPreference(){
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        if (sh_Pref!=null && sh_Pref.contains("Username")){
            String name = sh_Pref.getString("Username", "noname");

            name_text.setText(name);

        }

        if (sh_Pref!=null && sh_Pref.contains("UserNum")){

            String num=sh_Pref.getString("UserNum", "nonum");
            studentnum_text.setText(num);
        }


    }






}
