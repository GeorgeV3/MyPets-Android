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
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.gv.mypets2.Activities.PetDetailsActivity;
import com.example.gv.mypets2.Activities.PetsListActivity;
import com.example.gv.mypets2.MyPetsApplication;
import com.example.gv.mypets2.Pet;
import com.example.gv.mypets2.PetAdapter;
import com.example.gv.mypets2.Pet_;
import com.example.gv.mypets2.R;
import com.example.gv.mypets2.Session;

import java.util.Arrays;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.query.Query;

public class PetsListFragment extends Fragment {

    private BaseAdapter adapter;
    private String speciesName;

    public static final String EXTRA_TEXT = "species.name";


    public static PetsListFragment newInstance(String speciesName) {
        PetsListFragment fragment = new PetsListFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_TEXT, speciesName);
        fragment.setArguments(args);
        return fragment;
    }

    private PetsListFragment.DataPassListener2 mListener;


    public interface DataPassListener2 {
        void onPetSelected(String specieName , int positionPet);
    }


    public PetsListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

           speciesName = getArguments().getString(EXTRA_TEXT);


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


                Box<Pet> petBox = ((MyPetsApplication) getActivity().getApplication()).getBoxStore().boxFor(Pet.class);

                Query<Pet> query = petBox.query().equal(Pet_.species,speciesName).build();

                final List<Pet> specieList = query.find();

                this.adapter = new PetAdapter(getContext(), specieList);

                ListView listView = getActivity().findViewById(R.id.sec_listview);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String nameSpecie = specieList.get(position).getSpecies();
                        mListener.onPetSelected(nameSpecie , position);


                    }
                });
            }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PetsListFragment.DataPassListener2) {
            mListener = (PetsListFragment.DataPassListener2) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement DataPassListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

        }





