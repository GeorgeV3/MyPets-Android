package com.example.gv.mypets2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.List;

import io.objectbox.Box;
import io.objectbox.query.Query;

public class PetsListActivity extends AppCompatActivity {

    private ListView secListView;
    private BaseAdapter adapter;
    private Session session;
    private String menuLogin = "Login";
    private String menuLogout = "Logout";

    public static final String EXTRA_SPECIE="species.name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pets_list);

        session = new Session(this);


        secListView = findViewById(R.id.sec_listview);
        Box<Pet> petBox = ((MyPetsApplication) getApplication()).getBoxStore().boxFor(Pet.class);

        Query<Pet> query = petBox.query().equal(Pet_.species,getIntent().getStringExtra(EXTRA_SPECIE)).build();


        final List<Pet> specieList = query.find();

        this.adapter = new PetAdapter(this , specieList);
                this.secListView.setAdapter(this.adapter);

                secListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (session.loggedin()) {
                            String nameSpecie = specieList.get(position).getSpecies();
                            Intent intent = new Intent(PetsListActivity.this, PetDetailsActivity.class);
                            intent.putExtra("Position", position);
                            intent.putExtra(PetDetailsActivity.EXTRA_SPECIE2, nameSpecie);
                            startActivity(intent);
                        }else {
                            Toast.makeText(PetsListActivity.this,"You must login.",Toast.LENGTH_LONG).show();
                        }
            }
        });

}
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.login_logout_menu, menu);
        return true;
    }

    //When you want to change the menu.
    @Override
    public void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){

        if (session.loggedin()){
            menu.findItem(R.id.menuItem).setTitle(menuLogout);
        }else{
            menu.findItem(R.id.menuItem).setTitle(menuLogin);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){

        if (!session.loggedin()) {
            Intent intent = new Intent(PetsListActivity.this , LoginActivity.class);
            startActivity(intent);
            return true;
        } else {logout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout(){
        session.setLoggedin(false);
        finish();

    }
}
