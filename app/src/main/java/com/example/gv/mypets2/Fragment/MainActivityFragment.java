package com.example.gv.mypets2.Fragment;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


import com.example.gv.mypets2.Activities.PetsListActivity;
import com.example.gv.mypets2.MyPetsApplication;
import com.example.gv.mypets2.Pet;
import com.example.gv.mypets2.Pet_;
import com.example.gv.mypets2.R;

import java.util.Arrays;
import java.util.List;

import io.objectbox.Box;


public class MainActivityFragment extends Fragment {

    private DataPassListener mListener;


    public interface DataPassListener {
        void onSpeciesSelected(String speciesName);
    }

    //axristo..!
    public static MainActivityFragment newInstance() {
        return new MainActivityFragment();
    }

    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_species_list, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Box<Pet> petBox = ((MyPetsApplication) getActivity().getApplication()).getBoxStore().boxFor(Pet.class);

        final List<String> speciesList= Arrays.asList(petBox.query().build().property(Pet_.species).distinct().findStrings());

        ListAdapter adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,speciesList);

        ListView listView = getActivity().findViewById(R.id.list_species);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String speciesName= speciesList.get(position);
               mListener.onSpeciesSelected(speciesName);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DataPassListener) {
            mListener = (DataPassListener) context;
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
