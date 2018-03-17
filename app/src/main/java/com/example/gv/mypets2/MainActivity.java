package com.example.gv.mypets2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.gv.mypets2.R.id.list_view;


public class MainActivity extends AppCompatActivity {

    private Button next, back;
    private ListView listView;
    private List<Pet> pets;
    private static final String TAG = "MainActivity";
    private BaseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(list_view);

        //Create a collection of pets using class Pet
        pets = new ArrayList<>();
        // Create some objects pets

        Pet firstPet = new Pet("Bella", "22.5525", "Male", "dede", "ded", "dede", "dededed", "dedede", "dedede", "dededed", "ddededed", "dededed", "dededed", "dededed", "eweee");
        pets.add(firstPet);

        Pet secondPet= (new Pet("Bella1", "ded1", "Male1", "dede1", "ded1", "dede", "dededed", "dedede", "dedede", "dededed", "ddededed", "dededed", "dededed", "dededed", "eweee"));
        pets.add(secondPet);

      //  pets.add(new Pet("Bella2", "ded2", "Male2", "dede2", "ded", "dede", "dededed", "dedede", "dedede", "dededed", "ddededed", "dededed", "dededed", "dededed", "eweee"));
        //      pets.add(new Pet("Bella3", "ded3", "Male3", "dede3", "ded", "dede", "dededed", "dedede", "dedede", "dededed", "ddededed", "dededed", "dededed", "dededed", "eweee"));

        // method for generate many pets
        /*  for (int i = 0; i <4; i++){
               pets.add(new Pet("bella2" + i))
           }
           */

                {   Log.d(TAG, "onCreate: pets:" + pets.get(1).getName() + "" + pets.get(1).getDateOfBirth()); }






        this.adapter = new PetAdapter(this, pets);
        this.showListView();
    }



        private void showListView() {

        this.listView.setAdapter(this.adapter);
        this.listView.setVisibility(View.VISIBLE);

    }


}

