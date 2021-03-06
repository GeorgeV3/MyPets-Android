package com.example.gv.mypets2.activities;

import android.content.Intent;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

import android.widget.TextView;

import com.example.gv.mypets2.MyPetsApplication;
import com.example.gv.mypets2.Pet;
import com.example.gv.mypets2.Pet_;
import com.example.gv.mypets2.R;
import com.squareup.picasso.Picasso;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.objectbox.Box;


public class PetDetailsActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    private TextView  name , dateofbirth , gender , species ,breed ,colour , distinguishingmarks , chipid ,
    ownername , owneraddress , ownerphone , vetname , vetaddress , vetphone , comments;
    private ImageView mImageView;
    private int position=0;
    String url;
    private GestureDetectorCompat detector;

    private List<Pet> specieList = new ArrayList<>();


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

        detector = new GestureDetectorCompat(this,this);

        Box<Pet> petBox = ((MyPetsApplication) getApplication()).getBoxStore().boxFor(Pet.class);

        Intent intent = getIntent();
        position = Objects.requireNonNull(intent.getExtras()).getInt("Position");

         List<Pet> specieList2 =petBox.query().equal(Pet_.species,getIntent().getStringExtra(EXTRA_SPECIE2)).build().find();

        displayPets(specieList2);


        specieList = specieList2;





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
    // Method for trigger touchEvents
    @Override
    public boolean onTouchEvent(MotionEvent event){
        return detector.onTouchEvent(event);

    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int SWIPE_THRESHOLD_VELOCITY = 200;
        int SWIPE_MIN_DISTANCE = 120;
        if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
            // Right to left, your code



                        position++;
                        if (position==specieList.size()){position=0;}
                        displayPets(specieList);


            return true;
        } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE &&     Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
            // Left to right , your code


                        position--;
                        if (position == -1) {position = specieList.size() - 1;}
                        displayPets(specieList);


            return true;
        }

        return false;
    }

}


