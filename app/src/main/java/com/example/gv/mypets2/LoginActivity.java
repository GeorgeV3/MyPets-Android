package com.example.gv.mypets2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

   private EditText etUsernameInput;
   private EditText etPasswordInput;
   private Session session;


    private static final String TAG = "LoginActivity";


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
                String username = etUsernameInput.getText().toString().trim();
                String password = etPasswordInput.getText().toString().trim();
                if(validateLogin(username , password)) {
                     doLogin(username , password);


                }

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


    private boolean validateLogin(String username , String password){
        if (username == null || username.trim().length()==0){
            Toast.makeText(LoginActivity.this,"Username require",Toast.LENGTH_LONG).show();
            return false;
        }
        if (password == null || password.trim().length()==0){
            Toast.makeText(LoginActivity.this,"Password require",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    private void doLogin(final String username , final String password){


        //Create Retrofit instance

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://hodor.ait.gr:8080/myPet/api/")
                .addConverterFactory(GsonConverterFactory.create());


        Retrofit retrofit = builder.build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<User> call =service.login(username , password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code()==200){
                    Log.d(TAG,response.message());
                    User user = response.body();
                    assert user != null;
                    if (user.getUserName().equals(username)) {

                        session.setLoggedin(true);

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    if (response.code()==404){
                        Toast.makeText(LoginActivity.this,"The username or password is incorrect.",Toast.LENGTH_LONG).show();
                    }

                    }else{
                        Toast.makeText(LoginActivity.this,"Something has gone wrong.The Server is lazy.",Toast.LENGTH_LONG).show();
                    }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Smthing wrong",Toast.LENGTH_LONG).show();



            }
        });
    }
}
