package com.example.lab6_3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    EditText name, studentNum;
    Button addBtn, deleteBtn;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();//call xml components

        addBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String get_Name = name.getText().toString();
                String get_num = studentNum.getText().toString();
                
                
                if(get_Name.length()<1||get_num.length()<1){//if edit text is empty
                    Toast.makeText(MainActivity.this, "모든 항목을 입력해 주세요", Toast.LENGTH_LONG).show();
                }
          
                else { 
                    name.setText("");
                    studentNum.setText("");
                    int student_num = Integer.parseInt(get_num);
                    insert(get_Name, student_num);
                    invalidate();
                }
            }
        });


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String get_Name = name.getText().toString();

                if(get_Name.length()<1) {//if name is empty...
                    Toast.makeText(MainActivity.this, "이름을 입력해 주세요", Toast.LENGTH_LONG).show();
                }
                else {
                    name.setText("");
                    studentNum.setText("");

                    // delete in DB and refresh listView
                    delete(get_Name);
                    invalidate();
                }
            }
        });
    }

    public void insert(String name, int studentNo) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("studentNo", studentNo);
        db.insert("student", null, values);
    }

    public void delete(String name) {
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});
    }

    public String[] select() {
        db = helper.getReadableDatabase();
        Cursor cr = db.query("student", null, null, null, null, null, null);
        String[] items = new String[cr.getCount()];

        int count = 0;
        while(cr.moveToNext()) {
            items[count] = cr.getString(cr.getColumnIndex("name")) +  " " + cr.getString(cr.getColumnIndex("studentNo"));
            count++;
        }
        cr.close();
        return items;
    }

    public void invalidate() {
        String[] items = select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listview.setAdapter(adapter);
    }

    public void init(){
        name = findViewById(R.id.edit1);
        studentNum = findViewById(R.id.edit2);
        addBtn = findViewById(R.id.btn1);
         deleteBtn = findViewById(R.id.btn2);
        listview = findViewById(R.id.list);
        helper = new MySQLiteOpenHelper(MainActivity.this, "person.db", null, 1);
    }
}
