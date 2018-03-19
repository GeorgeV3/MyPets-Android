package com.example.gv.mypets2;


import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;





public class MainActivity extends AppCompatActivity {

    private TextView  name , dateofbirth , gender , species ,breed ,colour , distinguishingmarks , chipid ,
    ownername , owneraddress , ownerphone , vetname , vetaddress , vetphone , comments;
    private ImageView mImageView;
    private EditText mEditText;
    private static ArrayList<Pet> mPets;
    private int position;
    String url;
    private static final String TAG = "MainActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 /*       if (savedInstanceState!=null){
            mPets= (ArrayList<Pet>) savedInstanceState.getSerializable("mPets");
        } */


        mPets = new ArrayList<>();

        mPets.add(new Pet ("Bella1", "22-11-2015", "Male", "Dog", "Unknown", "Black-White", "dededed", "dedede", "George Verroiopoulos", "Marousi", "0123456789", "Panos Psaros", "Brilisia", "0123456789", "A nice dog with a shining fur"));
        mPets.add(new Pet("Bella2", "12-11-1922", "Male1", "dede1", "ded1", "dede", "dededed", "dedede", "dedede", "dededed", "ddededed", "dededed", "dededed", "dededed", "eweee"));
        mPets.add(new Pet("Bella3", "12-33-1233", "Male1", "dede1", "ded1", "dede", "dededed", "dedede", "dedede", "dededed", "ddededed", "dededed", "dededed", "dededed", "eweee"));
        mPets.add(new Pet("Bella4", "02-12-2015", "Male1", "dede1", "ded1", "dede", "dededed", "dedede", "dedede", "dededed", "ddededed", "dededed", "dededed", "dededed", "eweee"));
        mPets.add(new Pet("Bella5", "20-12-2012", "Male1", "dede1", "ded1", "dede", "dededed", "dedede", "dedede", "dededed", "ddededed", "dededed", "dededed", "dededed", "eweee"));
        mPets.add(new Pet("Bella6", "01-02-2010", "Male1", "dede1", "ded1", "dede", "dededed", "dedede", "dedede", "dededed", "ddededed", "dededed", "dededed", "dededed", "eweee"));
        mPets.add(new Pet("Bella7", "22-09-2014", "Male1", "dede1", "ded1", "dede", "dededed", "dedede", "dedede", "dededed", "ddededed", "dededed", "dededed", "dededed", "eweee"));





         name =  findViewById(R.id.pet_name);
         dateofbirth = findViewById(R.id.pet_dateofbirth);
         gender = findViewById(R.id.pet_gender);
         species = findViewById(R.id.pet_species);
         breed = findViewById(R.id.pet_breed);
         colour = findViewById(R.id.pet_colour);
         distinguishingmarks = findViewById(R.id.pet_distinguishingmakrs);
         chipid = findViewById(R.id.pet_chipid);
         ownername = findViewById(R.id.pet_ownername);
         owneraddress = findViewById(R.id.pet_owneraddress);
         ownerphone = findViewById(R.id.pet_ownerphone);
         vetname= findViewById(R.id.pet_vetname);
         vetaddress = findViewById(R.id.pet_vetaddress);
         vetphone= findViewById(R.id.pet_vetphone);
         comments = findViewById(R.id.pet_comments);
         mEditText = findViewById(R.id.editText);
        Button submit = findViewById(R.id.btn_sumbit);
         mImageView = findViewById(R.id.imageView);

        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if (position<mPets.size())
                    position  ++;
                if  (position == mPets.size()){ position =0;}
                Log.d(TAG, "next: " + position);

                name.setText(mPets.get(position).getName());
                dateofbirth.setText(mPets.get(position).getDateOfBirth());
                gender.setText(mPets.get(position).getGender());
                species.setText(mPets.get(position).getSpecies());
                breed.setText(mPets.get(position).getBreed());
                colour.setText(mPets.get(position).getColour());
                distinguishingmarks.setText(mPets.get(position).getDistinguishingMarks());
                chipid.setText(mPets.get(position).getChipID());
                ownername.setText(mPets.get(position).getOwnerName());
                owneraddress.setText(mPets.get(position).getOwnerAddress());
                ownerphone.setText(mPets.get(position).getOwnerPhone());
                vetname.setText(mPets.get(position).getVetName());
                vetaddress.setText(mPets.get(position).getVetAddress());
                vetphone.setText(mPets.get(position).getVetPhone());
                comments.setText(mPets.get(position).getComments());

            }
        });

        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {if (position < mPets.size())
             position--;
                if (position==0){position=mPets.size()-1;}
                Log.d(TAG, "back: " + position);

                name.setText(mPets.get(position).getName());
                dateofbirth.setText(mPets.get(position).getDateOfBirth());
                gender.setText(mPets.get(position).getGender());
                species.setText(mPets.get(position).getSpecies());
                breed.setText(mPets.get(position).getBreed());
                colour.setText(mPets.get(position).getColour());
                distinguishingmarks.setText(mPets.get(position).getDistinguishingMarks());
                chipid.setText(mPets.get(position).getChipID());
                ownername.setText(mPets.get(position).getOwnerName());
                owneraddress.setText(mPets.get(position).getOwnerAddress());
                ownerphone.setText(mPets.get(position).getOwnerPhone());
                vetname.setText(mPets.get(position).getVetName());
                vetaddress.setText(mPets.get(position).getVetAddress());
                vetphone.setText(mPets.get(position).getVetPhone());
                comments.setText(mPets.get(position).getComments());
            }
        });

// Method for put an url in Picasso by the user
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = mEditText.getText().toString();

                Picasso.get().load(url = mEditText.getText().toString()).into(mImageView);
            }
        });


        firstPage();

    }
    private void firstPage() {
        name.setText(mPets.get(0).getName());
        dateofbirth.setText((CharSequence) mPets.get(0).getDateOfBirth());
        gender.setText(mPets.get(0).getGender());
        species.setText(mPets.get(0).getSpecies());
        breed.setText(mPets.get(0).getBreed());
        colour.setText(mPets.get(0).getColour());
        distinguishingmarks.setText(mPets.get(0).getDistinguishingMarks());
        chipid.setText(mPets.get(0).getChipID());
        ownername.setText(mPets.get(0).getOwnerName());
        owneraddress.setText(mPets.get(0).getOwnerAddress());
        ownerphone.setText(mPets.get(0).getOwnerPhone());
        vetname.setText(mPets.get(0).getVetName());
        vetaddress.setText(mPets.get(0).getVetAddress());
        vetphone.setText(mPets.get(0).getVetPhone());
        comments.setText(mPets.get(0).getComments());

        }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putString("name" , name.getText().toString());
//        outState.putString("1" ,dateofbirth.getText().toString());

 //       outState.putSerializable("mPets", (Serializable) mPets);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        name.setText(savedInstanceState.getString("name"));
//        dateofbirth.setText(savedInstanceState.getString("1"));

    }

}

