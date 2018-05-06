package com.example.gv.mypets2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirmPass;
    private EditText etName;
    private EditText etSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.user_username);
        etPassword = findViewById(R.id.user_password);
        etConfirmPass = findViewById(R.id.user_conf_password);
        etName = findViewById(R.id.user_name);
        etSurname = findViewById(R.id.user_surname);

        findViewById(R.id.btn_reg_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();

            }
        });


    }
    
    private void register(){
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        String confirmPass = etConfirmPass.getText().toString();
        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();
        if (username.isEmpty()){
            Toast.makeText(RegisterActivity.this,"Username field empty",Toast.LENGTH_LONG).show();
        }
        if (!isPasswordValid(password)){
            Toast.makeText(RegisterActivity.this,"Password to small , must be above 6 characters",Toast.LENGTH_LONG).show();

        }
        if (!password.equals(confirmPass)){
            Toast.makeText(RegisterActivity.this,"Password not match Confrim Password",Toast.LENGTH_LONG).show();
        }
    }

    private boolean isPasswordValid(String password){
        return password.length()>6;
    }


}
