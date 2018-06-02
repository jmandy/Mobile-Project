package com.example.jmand.lab6;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    Button write_btn,clear_btn,read_btn,finish_btn;
    final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();// call microSD_available function and initialize xml component

        write_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = edit.getText().toString();//get Text


                File sdCard = Environment.getExternalStorageDirectory();
                File directory = new File(sdCard.getAbsolutePath() + "/MyFiles");
                directory.mkdirs();
                File file = new File(directory, "mysdfile.txt");
                try {
                    FileOutputStream fOut = new FileOutputStream(file);
                    OutputStreamWriter osw = new OutputStreamWriter(fOut);
                    BufferedWriter bw = new BufferedWriter(osw);
                    System.out.println("test : write : " + text);
                    bw.write(text);
                    bw.close();
                } catch(FileNotFoundException ef) {
                    ef.printStackTrace();
                } catch(IOException eio) {
                    eio.printStackTrace();
                }

                Toast.makeText(MainActivity.this, "Done writing SD 'mysdfile.txt", Toast.LENGTH_LONG).show();
            }
        });

        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText("");
            }
        });


        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File sdCard = Environment.getExternalStorageDirectory();
                File directory = new File(sdCard.getAbsolutePath() + "/MyFiles");
                directory.mkdirs();
                File file = new File(directory, "mysdfile.txt");
                try {
                    FileInputStream file_in = new FileInputStream(file);
                    InputStreamReader inputread = new InputStreamReader(file_in);
                    BufferedReader br = new BufferedReader(inputread);

                    String text;
                    while((text = br.readLine()) != null) {
                        edit.append(text + "\n");
                    }
                    br.close();
                } catch(FileNotFoundException ef) {
                    ef.printStackTrace();
                } catch(IOException eio) {
                    eio.printStackTrace();
                }

                Toast.makeText(MainActivity.this, "Done reading SD 'mysdfile.txt", Toast.LENGTH_LONG).show();
            }
        });



        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {               
                finish();
            }
        });
    }

    public void onRequestPermissionResult(int requestCode, String permissions[], int[] grantResults) {
        switch(requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE:
                
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                   
                }
                else {
                 
                }
                return;
        }
    }

    public void check_sdAvailable(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
          
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {                
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            }
        }
    }

    public void init(){
        check_sdAvailable();
        edit = (EditText)findViewById(R.id.edit1);
        write_btn = findViewById(R.id.btn1);
        clear_btn=findViewById(R.id.btn2);
        read_btn = findViewById(R.id.btn3);
        finish_btn = findViewById(R.id.btn4);
    }
}
