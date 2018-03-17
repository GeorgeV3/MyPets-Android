package com.example.gv.mypets2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gv on 16/3/2018.
 */

public class PetAdapter extends BaseAdapter {

    private Context context;
    private List<Pet> pets;

    public PetAdapter(Context context, List<Pet> pets) {
        this.context = context;
        this.pets = pets;


    }

    @Override
    public int getCount() {
        return this.pets.size(); }

    @Override
    public Object getItem(int position) {
        return this.pets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(R.layout.layout_pet, parent, false);
        }

        Pet pet = (Pet) getItem(position);

        TextView nameTextview = (TextView) convertView.findViewById(R.id.pet_name);
        TextView dateOfBirthTextview = (TextView) convertView.findViewById(R.id.pet_dateofbirth);
        TextView genderTextview = (TextView) convertView.findViewById(R.id.pet_gender);
        TextView speciesTextview = (TextView) convertView.findViewById(R.id.pet_species);
        TextView breedTextview = (TextView) convertView.findViewById(R.id.pet_breed);
        TextView colourTextview = (TextView) convertView.findViewById(R.id.pet_colour);
        TextView distinguishingMarksTextview = (TextView) convertView.findViewById(R.id.pet_distinguishingmakrs);
        TextView chipIdTextview = (TextView) convertView.findViewById(R.id.pet_chipid);
        TextView onwerNameTextview = (TextView) convertView.findViewById(R.id.pet_ownername);
        TextView ownerAddressTextview = (TextView) convertView.findViewById(R.id.pet_owneraddress);
        TextView ownerPhoneTextview = (TextView) convertView.findViewById(R.id.pet_ownerphone);
        TextView vetNameTextview = (TextView) convertView.findViewById(R.id.pet_vetname);
        TextView vetAddressTextview = (TextView) convertView.findViewById(R.id.pet_vetaddress);
        TextView vetPhoneTextview = (TextView) convertView.findViewById(R.id.pet_vetphone);
        TextView commentsTextview = (TextView) convertView.findViewById(R.id.pet_comments);

        nameTextview.setText(pet.getName());
        dateOfBirthTextview.setText(pet.getDateOfBirth());
        genderTextview.setText(pet.getGender());
        speciesTextview.setText(pet.getSpecies());
        breedTextview.setText(pet.getBreed());
        colourTextview.setText(pet.getColour());
        distinguishingMarksTextview.setText(pet.getDistinguishingMarks());
        chipIdTextview.setText(pet.getChipID());
        onwerNameTextview.setText(pet.getOwnerName());
        ownerAddressTextview.setText(pet.getOwnerAddress());
        ownerPhoneTextview.setText(pet.getOwnerPhone());
        vetNameTextview.setText(pet.getVetName());
        vetAddressTextview.setText(pet.getVetAddress());
        vetPhoneTextview.setText(pet.getVetPhone());
        commentsTextview.setText(pet.getComments());

        return convertView;


    }
}
