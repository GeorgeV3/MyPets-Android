package com.example.gv.mypets2;

import android.app.Application;

import android.content.SharedPreferences;


import java.text.ParseException;
import java.text.SimpleDateFormat;


import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

public class MyPetsApplication extends Application {


    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    private BoxStore boxStore;
    SharedPreferences appIntro= null;



    public void onCreate(){
        super.onCreate();

        boxStore = MyObjectBox.builder().androidContext(MyPetsApplication.this).build();
        if (BuildConfig.DEBUG){
            new AndroidObjectBrowser(boxStore).start(this);
        }

        //Delete drop all files from database

       // boxStore.close();
       // boxStore.deleteAllFiles();

        appIntro = getSharedPreferences("hasRunBefore" , 0);
        Boolean hasRun = appIntro.getBoolean("hasRun" , false);

        if(!hasRun){


            //To put some dummies pets in the database when the app start.

            Box<Pet> petBox = boxStore.boxFor(Pet.class);

            try {
                petBox.put(new Pet(0, "Bella1", sdf.parse("22-11-2012"), "Male", "Cat", "Unknown", "Brown-Black", "Uknown", "123456789123456", "George Verroiopoulos", "Marousi", "0123456789", "Panos Psaros", "Brilisia", "0123456789", "A nice dog with a shining fur",
                        "https://images.pexels.com/photos/326875/pexels-photo-326875.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));

                petBox.put(new Pet(0, "Bella2", sdf.parse("12-11-1922"), "Female", "Cat", "Unknown", "Grey-White", "Uknown", "123456789123456", "Nancy Konsta", "Kifisia", "123456789", "Kiriakos Kiritsis", "Xalandri", "0123456789", "It likes to eat fishes and fried chicken.",
                        "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"));
                petBox.put(new Pet(0, "Bella3", sdf.parse("12-33-1233"), "Unknown", "Fish", "Unknown", "Orange-White", "Uknown", "123456789123456", "Antwnis Padiris", "P.Faliro", "1523478694", "Basilis Zaxaris", "Kalithea", "0123456789", "It likes to make boubles , boubles.",
                        "https://images.pexels.com/photos/128756/pexels-photo-128756.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
                petBox.put(new Pet(0, "Bella4", sdf.parse("02-12-2015"), "Female", "Parrot", "Unknown", "Multi-Colour", "Uknown", "123456789123456", "Rania Anagnwstou", "Zwgrafou", "1523478694", "Kwstas Andreou", "Psiri", "0123456789", "It likes to said good morning , a nice day today.",
                        "https://images.pexels.com/photos/9291/nature-bird-flying-red.jpg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
                petBox.put(new Pet(0, "Bella5", sdf.parse("20-12-2012"), "Female", "Lizard", "Unknown", "Green-Blue", "Uknown", "123456789123456", "Nick Papadopoulos", "Pedeli", "1523478694", "Niki Karabela", "Melisia", "0123456789", "It sleep most of the day.",
                        "https://images.pexels.com/photos/33321/iguana-white-background-reptile.jpg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
                petBox.put(new Pet(0, "Bella6", sdf.parse("01-02-2010"), "Male", "Cat", "Unknown", "Black", "Uknown", "123456789123456", "Adreas Filis", "Nikaia", "1523478694", "Soula Zoubou", "Nikaia", "0123456789", "It likes to gets hug , very peaceful.",
                        "https://images.pexels.com/photos/881142/pexels-photo-881142.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
                petBox.put(new Pet(0, "Bella7", sdf.parse("22-09-2014"), "Female", "Cat", "Unknown", "White", "Uknown", "123456789123456", "Anastasia Lioliou", "Glyfdada", "1523478694", "Maria Oikonomou", "Voula", "0123456789", "It likes to eat alot.",
                        "https://images.pexels.com/photos/171227/pexels-photo-171227.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"));
            } catch (ParseException e) {
                e.printStackTrace();
            }


            SharedPreferences settings = getSharedPreferences("hasRunBefore" , 0);
            SharedPreferences.Editor edit= settings.edit();
            edit.putBoolean("hasRun" , true);
            edit.apply();
        }



        }


    
    public BoxStore getBoxStore(){
        return boxStore;
    }

}



