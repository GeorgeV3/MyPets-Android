package com.example.gv.mypets2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;



public class PetAdapter extends BaseAdapter {

    private Context context;
    private List<Pet> specieList;

    public PetAdapter(Context context, List<Pet> specieList) {
        this.context = context;
        this.specieList = specieList;

    }


    @Override
    public int getCount() {
        return this.specieList.size(); }

    @Override
    public Object getItem(int position) {
        return this.specieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(R.layout.layout_pets_adapter, parent, false);
        }

        Pet pet = (Pet) getItem(position);

        TextView nameText = convertView.findViewById(R.id.name);
        TextView breedText = convertView.findViewById(R.id.breed_name);
        ImageView imageView = convertView.findViewById(R.id.imageView3);


        nameText.setText(pet.getName());
        breedText.setText(pet.getBreed());
        Picasso.get().load(specieList.get(position).getImageUrl()).resize(300,220).centerCrop().into(imageView);

        return convertView;


    }
}
