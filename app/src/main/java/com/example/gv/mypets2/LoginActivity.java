package com.example.gv.mypets2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

   private EditText etUsernameInput;
   private EditText etPasswordInput;
   private Session session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsernameInput = findViewById(R.id.log_username);
        etPasswordInput = findViewById(R.id.log_password);
        session = new Session(this);



        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });

        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this , RegisterActivity.class);
                startActivity(intent);
            }
        });


    }


    private void login(){
       // String username = etUsernameInput.getText().toString();
       // String password = etPasswordInput.getText().toString();

        session.setLoggedin(true);

        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
        startActivity(intent);
    }
}
