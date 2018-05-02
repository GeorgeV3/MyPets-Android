package com.example.gv.mypets2;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageView;

import android.widget.TextView;

import com.squareup.picasso.Picasso;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

import io.objectbox.Box;


public class PetDetailsActivity extends AppCompatActivity {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    private TextView  name , dateofbirth , gender , species ,breed ,colour , distinguishingmarks , chipid ,
    ownername , owneraddress , ownerphone , vetname , vetaddress , vetphone , comments;
    private ImageView mImageView;
    private int position=0;
    String url;


    public static final String EXTRA_SPECIE2="species.name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_details);

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
         mImageView = findViewById(R.id.imageView);

        Box<Pet> petBox = ((MyPetsApplication) getApplication()).getBoxStore().boxFor(Pet.class);

        Intent intent = getIntent();
        position = Objects.requireNonNull(intent.getExtras()).getInt("Position");

        final List<Pet> specieList =petBox.query().equal(Pet_.species,getIntent().getStringExtra(EXTRA_SPECIE2)).build().find();

        displayPets(specieList);

    }


    private void displayPets(List<Pet> petlist) {
        name.setText(petlist.get(position).getName());
        dateofbirth.setText(sdf.format(petlist.get(position).getDateOfBirth()));
        gender.setText(petlist.get(position).getGender());
        species.setText(petlist.get(position).getSpecies());
        breed.setText(petlist.get(position).getBreed());
        colour.setText(petlist.get(position).getColour());
        distinguishingmarks.setText(petlist.get(position).getDistinguishingMarks());
        chipid.setText(petlist.get(position).getChipID());
        ownername.setText(petlist.get(position).getOwnerName());
        owneraddress.setText(petlist.get(position).getOwnerAddress());
        ownerphone.setText(petlist.get(position).getOwnerPhone());
        vetname.setText(petlist.get(position).getVetName());
        vetaddress.setText(petlist.get(position).getVetAddress());
        vetphone.setText(petlist.get(position).getVetPhone());
        comments.setText(petlist.get(position).getComments());
        url = petlist.get(position).getImageUrl();
        Picasso.get().load(url).resize(300,220).centerCrop().into(mImageView);

    }

}


