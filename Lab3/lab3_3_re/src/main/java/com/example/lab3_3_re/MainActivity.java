package com.example.lab3_3_re;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button btn1;
    public Button btn2;
    public Fragment1 fstFragment;
    public Fragment2 secFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = findViewById(R.id.tab1);
        btn2 = findViewById(R.id.tab2);

        Fragment1 fstFragment = new Fragment1();
        Fragment2 secFragment = new Fragment2();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction().replace(R.id.contain1, fstFragment).commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction().replace(R.id.contain1,secFragment).commit();
            }
        });
    }
}
