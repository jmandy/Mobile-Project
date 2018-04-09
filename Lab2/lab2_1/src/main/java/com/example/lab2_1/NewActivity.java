package com.example.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
      import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;


public class NewActivity extends AppCompatActivity {
    Button close_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);//activy_new xml file

        Intent passedIntent = getIntent();//getIntent from MainActivity
        if (passedIntent != null) {
            String loginName = passedIntent.getStringExtra("loginName");//get the Name of MainActiviy's Edittext written
            String loginAge = passedIntent.getStringExtra("loginAge");////get the age of MainActiviy's Edittext written
            Toast.makeText(getApplicationContext(), "Student info : " + loginName + ", " + loginAge, Toast.LENGTH_LONG).show();//show Text message

        }

        close_btn=(Button)findViewById(R.id.btn3);//get button which is enrolled in xmlfile
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //close the previous activity
            }
        });

    }
}
