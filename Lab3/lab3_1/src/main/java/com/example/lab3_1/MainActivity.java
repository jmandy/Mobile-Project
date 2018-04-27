package com.example.lab3_1;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import static android.graphics.Color.*;


public class MainActivity extends Activity {
    Button mBtn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = findViewById(R.id.button);
        registerForContextMenu(mBtn);
    }
    //Make contextMenu
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Button Menu");

        menu.add(0,1,0,"Red");
        menu.add(0,2,0,"Green");
        menu.add(0,3,0,"Blue");
    }
    //Menun handling
    public boolean onContextItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case 1://Handling Red color
                mBtn.setTextColor(RED);
                return true;

            case 2://Green color
                mBtn.setTextColor(GREEN);
                return true;
            case 3://Blue color
                mBtn.setTextColor(BLUE);
                return true;
        }
        return true;
    }
}
