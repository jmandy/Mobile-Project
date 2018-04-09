package com.example.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView=(TextView)findViewById(R.id.text2);//find textView by id in xml file
        goBtn=(Button)findViewById(R.id.btn2);//find goButton by id in xml file
        backBtn=(Button)findViewById(R.id.btn3);//find backButton by id xml file

        Intent passedIntent=getIntent();//get intent from MyActivity
        final String passedUrl=passedIntent.getStringExtra("Url");//passedUrl is the string that inserted in intent
        textView.setText(passedUrl);//set text

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(passedUrl.isEmpty())) {//if passedUrl is not null string
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + passedUrl));//connect internet by using ACTION_VIEW
                    startActivity(intent);//start Internet
                } else {// if passedURl is null string
                    Toast.makeText(getApplicationContext(),"주소를 다시 입력하세요.",Toast.LENGTH_LONG).show();//show Toast message
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"뒤로가기버튼을 룰렀습니다.",Toast.LENGTH_LONG).show();//show Toast message
                finish();//remove current activity
            }
        });


    }
}
