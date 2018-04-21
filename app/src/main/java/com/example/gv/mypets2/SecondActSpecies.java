package com.example.gv.mypets2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SecondActSpecies extends AppCompatActivity {

    private ListView secListView;
    private BaseAdapter adapter;

    public static final String EXTRA_SPECIE="species.name";
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private List<Pet> mPets = new ArrayList<>();
    private List<Pet> specieList = new ArrayList<>();

    {
     try {
        mPets.add(new Pet ("Bella1", sdf.parse("22-11-2012"), "Male", "cat", "Unknown", "Brown-Black", "Uknown", "123456789123456", "George Verroiopoulos", "Marousi", "0123456789", "Panos Psaros", "Brilisia", "0123456789", "A nice dog with a shining fur",
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_act_species);

        secListView = findViewById(R.id.sec_listview);

        for (Pet pet : mPets) {
            if (pet.getSpecies().equalsIgnoreCase(getIntent().getStringExtra(EXTRA_SPECIE))) {
                specieList.add(pet);
                }
        }
        this.adapter = new PetAdapter(this , specieList);
                this.secListView.setAdapter(this.adapter);

                secListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String nameSpecie = specieList.get(position).getSpecies();
                        Intent intent = new Intent(SecondActSpecies.this , BrowsePet.class);
                        intent.putExtra("Position" , position );
                        intent.putExtra(BrowsePet.EXTRA_SPECIE2 ,nameSpecie);

                startActivity(intent);
            }
        });

}
}
