package com.example.gv.mypets2.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;



import com.example.gv.mypets2.fragments.PetsListFragment;
import com.example.gv.mypets2.R;
import com.example.gv.mypets2.Session;

public class PetsListActivity extends AppCompatActivity implements PetsListFragment.DataPassListener2 {


    private Session session;
    private String menuLogin = "Login";
    private String menuLogout = "Logout";

    public static final String EXTRA_SPECIE="species.name";

    public static Intent getStartIntent(Context context, String speciesName) {
        Intent intent = new Intent(context, PetsListActivity.class);
        intent.putExtra(EXTRA_SPECIE, speciesName);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pets_list);

        session = new Session(this);

        String speciesName = getIntent().getStringExtra(EXTRA_SPECIE);
        // Create a new Fragment to be placed in the activity layout
        PetsListFragment firstFragment = PetsListFragment.newInstance(speciesName);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
           if (findViewById(R.id.fragment_container) != null){

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
           if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment)
                    .commit();
        }
        if (findViewById(R.id.layout_portrait) !=null) {
            getSupportFragmentManager().beginTransaction()
                    .remove(firstFragment)
                    .commit();

        }
}

    @Override
    public void onPetSelected(String specieName, int positionPet) {
        if (session.loggedin()) {
            Intent intent = new Intent(PetsListActivity.this, PetDetailsActivity.class);
            intent.putExtra("Position", positionPet);
            intent.putExtra(PetDetailsActivity.EXTRA_SPECIE2, specieName);
            startActivity(intent);
        } else {
            Toast.makeText(PetsListActivity.this, "You must login.", Toast.LENGTH_LONG).show();

        }
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
        Intent intent = new Intent(PetsListActivity.this, MainActivity.class);
        startActivity(intent);

    }

}
