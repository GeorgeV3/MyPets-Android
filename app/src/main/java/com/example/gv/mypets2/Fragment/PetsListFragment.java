package com.example.gv.mypets2.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.gv.mypets2.Activities.PetDetailsActivity;
import com.example.gv.mypets2.Activities.PetsListActivity;
import com.example.gv.mypets2.MyPetsApplication;
import com.example.gv.mypets2.Pet;
import com.example.gv.mypets2.PetAdapter;
import com.example.gv.mypets2.Pet_;
import com.example.gv.mypets2.R;
import com.example.gv.mypets2.Session;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.query.Query;

public class PetsListFragment extends Fragment {

    private Session session;

    private static final String ARG_SPECIES_POSITION_IN_lIST = "species.name";

    public static PetsListFragment newInstance(int speciesLocationInList) {
        PetsListFragment fragment = new PetsListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SPECIES_POSITION_IN_lIST, speciesLocationInList);
        fragment.setArguments(args);
        return fragment;
    }

    Box<Pet> petBox = ((MyPetsApplication) getActivity().getApplication()).getBoxStore().boxFor(Pet.class);

    Query<Pet> query = petBox.query().equal(Pet_.species,getArguments().getInt(ARG_SPECIES_POSITION_IN_lIST)).build();


    public final List<Pet> specieList = query.find();


    //axristo...!!
    /* public static PetsListFragment newInstance() {
        return new PetsListFragment();
    }*/



    public PetsListFragment() {
        // Required empty public constructor
    }
    private int speciesLocationInList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        session = new Session(getActivity());
        if (getArguments() != null) {
            speciesLocationInList = getArguments().getInt(ARG_SPECIES_POSITION_IN_lIST);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pets_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        PetAdapter adapter = new PetAdapter(getContext(),R.layout.layout_pets_adapter,specieList);

        ListView listView =getActivity().findViewById(R.id.sec_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (session.loggedin()) {
                    String nameSpecie = specieList.get(position).getSpecies();
                    Intent intent = new Intent(getActivity(), PetDetailsActivity.class);
                    intent.putExtra("Position", position);
                    intent.putExtra(PetDetailsActivity.EXTRA_SPECIE2, nameSpecie);
                    startActivity(intent);
                }else {
                    Toast.makeText(getActivity(),"You must login.",Toast.LENGTH_LONG).show();
                }
            }

        });
    }

}



