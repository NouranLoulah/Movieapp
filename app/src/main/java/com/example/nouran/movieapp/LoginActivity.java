
package com.example.nouran.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button login;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.emailET);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });

        //set  user login or not
        final SharedPrefDueDate prefDueDate=new SharedPrefDueDate(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e=email.getText().toString();
                String p=password.getText().toString();
                if(e.isEmpty()|| p.isEmpty()){
                    Toast.makeText(LoginActivity.this,"complete your information",Toast.LENGTH_LONG).show();



                }else {
                    Intent t=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(t);
                    finish();

                    prefDueDate.setPersonId(email.getText().toString());
                }

            }
        });
    }


}
