package com.example.gv.mypets2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {


    RadioButton cats, dogs, others;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cats =  findViewById(R.id.rd_cats);
        dogs =  findViewById(R.id.rd_dogs);
        others =  findViewById(R.id.rd_others);
        submit =  findViewById(R.id.btn_submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cats.isChecked()) {

                    Intent intent = new Intent(MainActivity.this, BrowsePet.class);
                    intent.putExtra("cats" ,1);

                    startActivity(intent);



                } else if (dogs.isChecked()) {
                    Intent intent = new Intent(MainActivity.this, BrowsePet.class);
                    intent.putExtra("dogs",2);
                    startActivity(intent);
                } else if (others.isChecked()) {
                    Intent intent = new Intent(MainActivity.this, BrowsePet.class);
                    intent.putExtra("others",3);

                    startActivity(intent);
                }


            }
        });
    }
}
