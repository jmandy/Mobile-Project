package com.example.lab2_2;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Url;
    Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Url=(EditText)findViewById(R.id.text1);//find EditText by id in xml file
        nextBtn=(Button)findViewById(R.id.btn1);////find Button by id in xml file

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myUrl=Url.getText().toString();//get Url in EditText
                Intent intent =new Intent(getApplicationContext(),NewActivity.class);
                intent.putExtra("Url",myUrl);//insert String in intent
                startActivity(intent);//if button clicked, then start NewActivity by using intent
            }
        });
    }
}
