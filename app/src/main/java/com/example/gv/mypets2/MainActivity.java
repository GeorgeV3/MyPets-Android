package com.example.gv.mypets2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private BaseAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_species);

        List<Pet> mPets = ((CostumApp) getApplication()).getmPets();

        final List<String> speciesList = new ArrayList<>();
        for (Pet pet : mPets){
            speciesList.add(pet.getSpecies());
        }
        Set<String> species = new LinkedHashSet<>(speciesList);
        speciesList.clear();
        speciesList.addAll(species);

            this.adapter = new ArrayAdapter<>(this,R.layout.activity_main_specieslist , R.id.species_layout , speciesList);
            this.listView.setAdapter(this.adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String nameSpecie = speciesList.get(position);
                    Intent intent = new Intent(MainActivity.this , SecondActSpecies.class);
                    intent.putExtra(SecondActSpecies.EXTRA_SPECIE , nameSpecie );

                    startActivity(intent);
                    }
            });

    }
}
