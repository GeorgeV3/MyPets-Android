package com.example.gv.mypets2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.query.Query;

public class SecondActSpecies extends AppCompatActivity {

    private ListView secListView;
    private BaseAdapter adapter;

    public static final String EXTRA_SPECIE="species.name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_act_species);

        secListView = findViewById(R.id.sec_listview);
        Box<Pet> petBox = ((CostumApp) getApplication()).getBoxStore().boxFor(Pet.class);
        Query<Pet> query = petBox.query().equal(Pet_.species,getIntent().getStringExtra(EXTRA_SPECIE)).build();

        final List<Pet> specieList = query.find();


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
