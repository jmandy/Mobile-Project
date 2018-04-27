package com.example.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    TextView text1;
    TextView text2;
    TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

       //find textview
        text1 = findViewById(R.id.textview1);
        text2 = findViewById(R.id.textview2);
        text3 = findViewById(R.id.textview3);

        //get Intent
        Intent passedIntent = getIntent();
        if(passedIntent!=null){
            //get "name" and store in setName
            String setName = passedIntent.getStringExtra("name");
            //get "gender" and store in setGender
            String setGender = passedIntent.getStringExtra("gender");
            //get "connect" and store
            String setConnect = passedIntent.getStringExtra("connect");

            //display on TextView
            text1.setText(setName);
            text2.setText(setGender);
            text3.setText(setConnect);
        }

        Button button0 = findViewById(R.id.button2);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"돌아가기버튼이 눌렸어요",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
