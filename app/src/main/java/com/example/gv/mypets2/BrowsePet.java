package com.example.gv.mypets2;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BrowsePet extends AppCompatActivity {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    private TextView  name , dateofbirth , gender , species ,breed ,colour , distinguishingmarks , chipid ,
    ownername , owneraddress , ownerphone , vetname , vetaddress , vetphone , comments;
    private ImageView mImageView;
    private int position=0;
    String url;
    private List<Pet> mPets = new ArrayList<>();
    private List<Pet> specieList = new ArrayList<>();


    {
        try {
        mPets.add(new Pet ("Bella1", sdf.parse("22-11-2012"), "Male", "cat", "Unknown", "Brown-Black", "Uknown", "123456789123456", "George Verroiopoulos", "Marousi", "0123456789", "Panos Psaros", "Brilisia", "0123456789", "A nice cat with a shining fur",
                "https://images.pexels.com/photos/326875/pexels-photo-326875.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mPets.add(new Pet("Bella2", sdf.parse("12-11-1922"), "Female", "Cat", "Unknown", "Grey-White", "Uknown", "123456789123456", "Nancy Konsta", "Kifisia", "123456789", "Kiriakos Kiritsis", "Xalandri", "0123456789", "It likes to eat fishes and fried chicken.",
                "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"));
        mPets.add(new Pet("Bella3", sdf.parse("12-33-1233"), "Unknown", "Fish", "Unknown", "Orange-White", "Uknown", "123456789123456", "Antwnis Padiris", "P.Faliro", "1523478694", "Basilis Zaxaris", "Kalithea", "0123456789", "It likes to make boubles , boubles.",
                "https://images.pexels.com/photos/128756/pexels-photo-128756.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mPets.add(new Pet("Bella4", sdf.parse("02-12-2015"), "Female", "Parrot", "Unknown", "Multi-Colour", "Uknown", "123456789123456", "Rania Anagnwstou", "Zwgrafou", "1523478694", "Kwstas Andreou", "Psiri", "0123456789", "It likes to said good morning , a nice day today.",
                "https://images.pexels.com/photos/9291/nature-bird-flying-red.jpg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mPets.add(new Pet("Bella5", sdf.parse("20-12-2012"), "Female", "Lizard", "Unknown", "Green-Blue", "Uknown", "123456789123456", "Nick Papadopoulos", "Pedeli", "1523478694", "Niki Karabela", "Melisia", "0123456789", "It sleep most of the day.",
                "https://images.pexels.com/photos/33321/iguana-white-background-reptile.jpg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mPets.add(new Pet("Bella6", sdf.parse("01-02-2010"), "Male", "Cat", "Unknown", "Black", "Uknown", "123456789123456", "Adreas Filis", "Nikaia", "1523478694", "Soula Zoubou", "Nikaia", "0123456789", "It likes to gets hug , very peaceful.",
                "https://images.pexels.com/photos/881142/pexels-photo-881142.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
        mPets.add(new Pet("Bella7", sdf.parse("22-09-2014"), "Female", "Cat", "Unknown", "White", "Uknown", "123456789123456", "Anastasia Lioliou", "Glyfdada", "1523478694", "Maria Oikonomou", "Voula", "0123456789", "It likes to eat alot.",
                "https://images.pexels.com/photos/171227/pexels-photo-171227.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
    } catch (ParseException e) {
        e.printStackTrace();
    }}

    public static final String EXTRA_SPECIE2="species.name";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser_pet);

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

        Intent intent = getIntent();
        position = intent.getExtras().getInt("Position");

        for (Pet pet : mPets) {
            if (pet.getSpecies().equalsIgnoreCase(getIntent().getStringExtra(EXTRA_SPECIE2))) {
                specieList.add(pet);
            }
        }

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


