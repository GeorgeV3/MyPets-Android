package com.example.gv.mypets2;



import android.support.constraint.ConstraintLayout;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BrowsePet extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private TextView  name , dateofbirth , gender , species ,breed ,colour , distinguishingmarks , chipid ,
    ownername , owneraddress , ownerphone , vetname , vetaddress , vetphone , comments , noPets;
    private ImageView mImageView;
    private EditText mEditText;
    private static ArrayList<Pet> mPets;
    private int position;
    String url;
    private static final String TAG = "BrowsePet";

    int trigerEvent;
    private GestureDetectorCompat detector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser_pet);

 //       SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");



        mPets = new ArrayList<>();

        mPets.add(new Pet ("Bella1","22-11-2012", "Male", "Dog", "Unknown", "Brown-White", "Uknown", "123456789123456", "George Verroiopoulos", "Marousi", "0123456789", "Panos Psaros", "Brilisia", "0123456789", "A nice dog with a shining fur"));
        mPets.add(new Pet("Bella2", "12-11-1922", "Female", "Cat", "Unknown", "White-Orange", "Uknown", "123456789123456", "Nancy Konsta", "Kifisia", "123456789", "Kiriakos Kiritsis", "Xalandri", "0123456789", "It likes to eat fishes and fried chicken."));
        mPets.add(new Pet("Bella3", "12-33-1233", "Unknown", "Fish", "Unknown", "Orange-Gold", "Uknown", "123456789123456", "Antwnis Padiris", "P.Faliro", "1523478694", "Basilis Zaxaris", "Kalithea", "0123456789", "It likes to make boubles , boubles."));
        mPets.add(new Pet("Bella4", "02-12-2015", "Female", "Bird", "Unknown", "Yellow-Red", "Uknown", "123456789123456", "Rania Anagnwstou", "Zwgrafou", "1523478694", "Kwstas Andreou", "Psiri", "0123456789", "it has the best eel that I have heard."));
        mPets.add(new Pet("Bella5", "20-12-2012", "Female", "Lizard", "Unknown", "Green-Grey", "Uknown", "123456789123456", "Nick Papadopoulos", "Pedeli", "1523478694", "Niki Karabela", "Melisia", "0123456789", "It sleep most of the day."));
        mPets.add(new Pet("Bella6", "01-02-2010", "Male", "Cat", "Unknown", "Black", "Uknown", "123456789123456", "Adreas Filis", "Nikaia", "1523478694", "Soula Zoubou", "Nikaia", "0123456789", "It likes to gets hug , very peaceful."));
        mPets.add(new Pet("Bella7", "22-09-2014", "Female", "Dog", "Unknown", "White", "Uknown", "123456789123456", "Anastasia Lioliou", "Glyfdada", "1523478694", "Maria Oikonomou", "Voula", "0123456789", "It likes to eat alot."));


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
        ConstraintLayout petView = findViewById(R.id.layout_pet);
        noPets = findViewById(R.id.no_pets);

        detector = new GestureDetectorCompat(this,this);


        //Get intent methods
        trigerEvent = getIntent().getExtras().getInt("cats");
        switch(trigerEvent) {
            case 1:


                List<Pet> catList = new ArrayList<>();
                for (Pet pet : mPets){
                    if(pet.getSpecies().equals("Cat")){
                        catList.add(pet);
                        displayPets(catList);
                    }//else statment dont work...!!
                    //else
                        //  petView.setVisibility(View.GONE);
                      //  noPets.setVisibility(View.VISIBLE);

                    }
        }


        trigerEvent = getIntent().getExtras().getInt("dogs");
        switch(trigerEvent) {
            case 2:

                for (position=0; position<mPets.size();position++){
                if (mPets.get(position).getSpecies().equals("Dog")) {
                 //   displayPets();
                    break;
                } else
                    //  petView.setVisibility(View.GONE);
                    noPets.setVisibility(View.VISIBLE);

                }
        }

        trigerEvent = getIntent().getExtras().getInt("others");
        switch(trigerEvent) {
            case 3:

                List<Pet> otherPets = new ArrayList<>();
                for (Pet pet : mPets){
                    if(!pet.getSpecies().equals("Dog") && !pet.getSpecies().equals("Cat")){
                        otherPets.add(pet);
                        displayPets(otherPets);
                    }// else
                        //  petView.setVisibility(View.GONE);
                        //  noPets.setVisibility(View.VISIBLE);
                }
        }


//      Method for put an url in Picasso by the user
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = mEditText.getText().toString();

                Picasso.get().load(url = mEditText.getText().toString()).into(mImageView);
            }
        });

//       Method that utilizing  bundle savedinstancestate for remember position.
        if (savedInstanceState !=null){
            position =  savedInstanceState.getInt("position");
//          mImageView = savedInstanceState.getParcelable("16");

        }


    }

    private void displayPets(List<Pet> petlist) {
        name.setText(petlist.get(position).getName());
        dateofbirth.setText(petlist.get(position).getDateOfBirth());
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
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("name" , name.getText().toString());
        outState.putString("1" ,dateofbirth.getText().toString());
        outState.putString("2",gender.getText().toString());
        outState.putString("3",species.getText().toString());
        outState.putString("4", breed.getText().toString());
        outState.putString("5",colour.getText().toString());
        outState.putString("6" ,distinguishingmarks.getText().toString());
        outState.putString("7" ,chipid.getText().toString());
        outState.putString("8", ownername.getText().toString());
        outState.putString("9", owneraddress.getText().toString());
        outState.putString("10", ownerphone.getText().toString());
        outState.putString("11",vetname.getText().toString());
        outState.putString("12",vetaddress.getText().toString());
        outState.putString("13",vetphone.getText().toString());
        outState.putString("14",comments.getText().toString());
 //       outState.putString("15",mEditText.toString());
 //       outState.putParcelable("16" , (Parcelable) mImageView);


        outState.putInt("position",position);

        super.onSaveInstanceState(outState);

    }

     @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        name.setText(savedInstanceState.getString("name"));
        dateofbirth.setText(savedInstanceState.getString("1"));
        gender.setText(savedInstanceState.getString("2"));
        species.setText(savedInstanceState.getString("3"));
        breed.setText(savedInstanceState.getString("4"));
        colour.setText(savedInstanceState.getString("5"));
        distinguishingmarks.setText(savedInstanceState.getString("6"));
        chipid.setText(savedInstanceState.getString("7"));
        ownername.setText(savedInstanceState.getString("8"));
        owneraddress.setText(savedInstanceState.getString("9"));
        ownerphone.setText(savedInstanceState.getString("10"));
        vetname.setText(savedInstanceState.getString("11"));
        vetaddress.setText(savedInstanceState.getString("12"));
        vetphone.setText(savedInstanceState.getString("13"));
        comments.setText(savedInstanceState.getString("14"));
 //       mEditText.setText(savedInstanceState.getString("15"));

         super.onRestoreInstanceState(savedInstanceState);
   }


// Method for triger touchEvents
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

            trigerEvent = getIntent().getExtras().getInt("cats");
            switch(trigerEvent) {
                case 1:


                    List<Pet> catList = new ArrayList<>();
                    for (Pet pet : mPets){
                        if(pet.getSpecies().equals("Cat")){
                            catList.add(pet);

                        }//else
                        //  petView.setVisibility(View.GONE);
                        // noPets.setVisibility(View.VISIBLE);

                    }
                    if (position<catList.size())
                        position++;
                    if (position==catList.size()){position=0;}
                    displayPets(catList);

            }
            trigerEvent = getIntent().getExtras().getInt("others");
            switch(trigerEvent) {
                case 3:

                    List<Pet> otherPets = new ArrayList<>();
                    for (Pet pet : mPets){
                        if(!pet.getSpecies().equals("Dog") && !pet.getSpecies().equals("Cat")){
                            otherPets.add(pet);
                        }// else
                        //  petView.setVisibility(View.GONE);
                        //  noPets.setVisibility(View.VISIBLE);


                    }
                    if (position<otherPets.size())
                    position++;
                    if (position==otherPets.size()){position=0;}
                    displayPets(otherPets);
            }

            Log.d(TAG, "next: " + position);

            return true;
        } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE &&     Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
            // Left to right , your code

            trigerEvent = getIntent().getExtras().getInt("cats");
            switch(trigerEvent) {
                case 1:

                    List<Pet> catList = new ArrayList<>();
                    for (Pet pet : mPets){
                        if(pet.getSpecies().equals("Cat")){
                            catList.add(pet);
                        }//else
                        //  petView.setVisibility(View.GONE);
                        // noPets.setVisibility(View.VISIBLE);

                    }
                    if (position<catList.size())
                        position--;
                    if (position==-1) { position=catList.size()-1;}
                    displayPets(catList);

            }
            trigerEvent = getIntent().getExtras().getInt("others");
            switch(trigerEvent) {
                case 3:

                    List<Pet> otherPets = new ArrayList<>();
                    for (Pet pet : mPets){
                        if(!pet.getSpecies().equals("Dog") && !pet.getSpecies().equals("Cat")){
                            otherPets.add(pet);

                        }// else
                        //  petView.setVisibility(View.GONE);
                        //  noPets.setVisibility(View.VISIBLE);


                    }
                    if (position<otherPets.size())
                    position--;
                    if (position==-1) { position=otherPets.size()-1;}
                    displayPets(otherPets);

            }

             Log.d(TAG, "back: " + position);

            return true;
        }

        return false;
    }
}


