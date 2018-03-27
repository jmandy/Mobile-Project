package com.example.jmand.lab1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1;//Clicked before image
    ImageView imageView2;//Clicked After image

    int imageIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//Conduct Layout Inflation by using setContentView method

        imageView1=(ImageView)findViewById(R.id.img1);//find imgate by using id
        imageView2=(ImageView)findViewById(R.id.img2);//find image by using id
    }

    public void onButton1Clicked(View v){
        changeImage();
    }


    private void changeImage(){
        if(imageIndex == 0){//clicked before
            imageView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageIndex = 1;//to handle when clicked
        }
        else if (imageIndex == 1){//clicked after
            imageView1.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageIndex = 0;
        }
    }
}
