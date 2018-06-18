package com.example.gv.mypets2.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.Toast;

import com.example.gv.mypets2.fragments.MainActivityFragment;
import com.example.gv.mypets2.fragments.PetsListFragment;
import com.example.gv.mypets2.R;
import com.example.gv.mypets2.Session;


public class MainActivity extends AppCompatActivity implements MainActivityFragment.DataPassListener,PetsListFragment.DataPassListener2 {



    private String menuLogin = "Login";
    private String menuLogout = "Logout";
    private Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (session.loggedin()) {
            menu.findItem(R.id.menuItem).setTitle(menuLogout);
        } else {
            menu.findItem(R.id.menuItem).setTitle(menuLogin);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (!session.loggedin()) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            return true;
        } else {
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        session.setLoggedin(false);
        finish();

    }

    @Override
    public void onSpeciesSelected(String speciesName) {

        if (findViewById(R.id.layout_portrait) !=null){

            startActivity(PetsListActivity.getStartIntent(this, speciesName));
        }

        /*View fragmentContainer = findViewById(R.id.fragment_container);
        boolean isDualPane = fragmentContainer != null &&
                fragmentContainer.getVisibility() == View.VISIBLE;*/

        if (findViewById(R.id.layout_landscape) !=null) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, PetsListFragment.newInstance(speciesName))
                    .addToBackStack(null)
                    .commit();
        }
        /*else {
            getSupportFragmentManager().beginTransaction()
                    .remove(PetsListFragment.newInstance(speciesName))
                    .commit();
        }*/


    }

    @Override
    public void onPetSelected(String specieName, int positionPet) {

        if (session.loggedin()) {
            Intent intent = new Intent(MainActivity.this, PetDetailsActivity.class);
            intent.putExtra("Position", positionPet);
            intent.putExtra(PetDetailsActivity.EXTRA_SPECIE2, specieName);
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this,"You must login.",Toast.LENGTH_LONG).show();
        }
    }
}
