package com.example.gv.mypets2.Activities;


import android.content.Intent;
import android.support.media.ExifInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

import com.example.gv.mypets2.Fragment.MainActivityFragment;
import com.example.gv.mypets2.Fragment.PetsListFragment;
import com.example.gv.mypets2.MyPetsApplication;
import com.example.gv.mypets2.Pet;
import com.example.gv.mypets2.Pet_;
import com.example.gv.mypets2.R;
import com.example.gv.mypets2.Session;

import java.util.List;
import java.util.Arrays;


import io.objectbox.Box;


public class MainActivity extends AppCompatActivity implements MainActivityFragment.DataPassListener,PetsListFragment.DataPassListener2 {


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
       /* if (findViewById(R.id.layout_portrait) !=null){

            startActivity(PetsListActivity.getStartIntent(this, speciesName));
        }*/
        View fragmentContainer = findViewById(R.id.fragment_container);
        boolean isDualPane = fragmentContainer != null &&
                fragmentContainer.getVisibility() == View.VISIBLE;

        if (isDualPane) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, PetsListFragment.newInstance(speciesName));
            fragmentTransaction.commit();
        } else {
            startActivity(PetsListActivity.getStartIntent(this, speciesName));
        }


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
