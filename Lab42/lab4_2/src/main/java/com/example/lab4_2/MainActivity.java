package com.example.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    LinearLayout Layout1, Layout2;
    Button button;
    int mode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Animation open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.trans2);
        Animation close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.trans1);

        //Layout close handle
        if(mode==0){
            button.setText("Close Page");   ///button change
            mode=mode+1;   //change mode
            Layout2.setVisibility(View.VISIBLE);    //Layout 2 visible
            Layout2.startAnimation(open);   //animation handle
        }

        //Layout open handle
        else if(mode==1){
            button.setText("Open Page");    ///button change
            mode =mode- 1;                  //change mode
            Layout2.startAnimation(close);  //Layout 2 visible
            Layout2.setVisibility(View.GONE);   //animation handle
        }


    }

    public void init(){
        Layout1 = findViewById(R.id.Layout1);
        Layout2 = findViewById(R.id.Layout2);
        button = findViewById(R.id.button);
    }
}
