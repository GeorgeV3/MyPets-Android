package com.example.gv.mypets2.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gv.mypets2.PetServices;
import com.example.gv.mypets2.R;
import com.example.gv.mypets2.Session;
import com.example.gv.mypets2.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private EditText confirmPass;
    private EditText firstName;
    private EditText lastName;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = findViewById(R.id.user_username);
        password = findViewById(R.id.user_password);
        confirmPass = findViewById(R.id.user_conf_password);
        firstName = findViewById(R.id.user_name);
        lastName = findViewById(R.id.user_surname);

        session = new Session(this);

        findViewById(R.id.btn_reg_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etPassword = password.getText().toString().trim();
                String etConfirmPass =confirmPass.getText().toString().trim();

                if (etPassword.equals(etConfirmPass)&& password.length()>6) {

                    User user = new User(
                            userName.getText().toString().trim(),
                            password.getText().toString().trim(),
                            firstName.getText().toString().trim(),
                            lastName.getText().toString().trim()

                    );

                    sendRegister(user);
                }
                else {
                    Toast.makeText(RegisterActivity.this,"Password not match Confrim Password and must be above 6 characters",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
    private void sendRegister(User user){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://hodor.ait.gr:8080/myPet/api/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        PetServices service = retrofit.create(PetServices.class);

        Call<User> call = service.registerAccount(user);
        Log.i("register" , "register button click");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {

                    Toast.makeText(RegisterActivity.this, "Register successful", Toast.LENGTH_LONG).show();

                    session.setLoggedin(true);
                    Intent intent = new Intent(RegisterActivity.this , MainActivity.class);
                    startActivity(intent);
                }
                else {Toast.makeText(RegisterActivity.this,"Unsuccessful response",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(RegisterActivity.this,"Something went wrong , cannot connect on server",Toast.LENGTH_LONG).show();

            }
        });

    }

}
