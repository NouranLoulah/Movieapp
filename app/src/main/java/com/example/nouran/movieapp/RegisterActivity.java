package com.example.nouran.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    TextView email,name,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email=findViewById(R.id.emailET);
        name=findViewById(R.id.nameET);
        password=findViewById(R.id.password) ;

        DatabaseHandler db = new DatabaseHandler(this);
    }
}
