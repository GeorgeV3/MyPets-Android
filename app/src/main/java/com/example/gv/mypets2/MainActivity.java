package com.example.gv.mypets2;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;


import io.objectbox.Box;
import io.objectbox.query.QueryBuilder;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private BaseAdapter adapter;
    private String menuLogin = "Login";
    private String menuLogout = "Logout";
    private Session session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);
        listView = findViewById(R.id.list_species);


        Box<Pet> petBox = ((MyPetsApplication) getApplication()).getBoxStore().boxFor(Pet.class);

        final List<String> speciesList= Arrays.asList(petBox.query().build().property(Pet_.species).distinct().findStrings());


            this.adapter = new ArrayAdapter<>(this,R.layout.activity_main_specieslist , R.id.species_layout , speciesList);
            this.listView.setAdapter(this.adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (session.loggedin()){
                        String nameSpecie = speciesList.get(position);
                        Intent intent = new Intent(MainActivity.this , PetsListActivity.class);
                        intent.putExtra(PetsListActivity.EXTRA_SPECIE , nameSpecie );
                        startActivity(intent);

                    } else{
                        Toast.makeText(MainActivity.this,"You must login",Toast.LENGTH_LONG).show();

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

        if (!session.loggedin())
        {
            Intent intent = new Intent(MainActivity.this , LoginActivity.class);
        startActivity(intent);
        return true;
    }
    else {logout();

        }

        return super.onOptionsItemSelected(item);
    }

    private void logout(){
        session.setLoggedin(false);
        finish();

    }


}
