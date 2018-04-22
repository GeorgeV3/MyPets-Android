package com.example.gv.mypets2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActSpecies extends AppCompatActivity {

    private ListView secListView;
    private BaseAdapter adapter;

    public static final String EXTRA_SPECIE="species.name";
    private List<Pet> specieList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_act_species);

        secListView = findViewById(R.id.sec_listview);
        List<Pet> mPets = ((CostumApp) getApplication()).getmPets();

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
