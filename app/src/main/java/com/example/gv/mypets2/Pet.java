package com.example.gv.mypets2;


import java.util.Date;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Gv on 16/3/2018.
 */

@Entity
public class Pet {

    @Id
     long id;

     String name;
     Date dateOfBirth;
     String gender;
     String species;
     String breed;
     String colour;
     String distinguishingMarks;
     String chipID;
     String ownerName;
     String ownerAddress;
     String ownerPhone;
     String vetName;
     String vetAddress;
     String vetPhone;
     String comments;
     String imageUrl;

     public Pet(){

     }


    public Pet(long id , String name, Date dateOfBirth, String gender, String species, String breed, String colour, String distinguishingMarks, String chipID, String ownerName, String ownerAddress, String ownerPhone, String vetName, String vetAddress, String vetPhone, String comments , String imageUrl) {

        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.species = species;
        this.breed = breed;
        this.colour = colour;
        this.distinguishingMarks = distinguishingMarks;
        this.chipID = chipID;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.ownerPhone = ownerPhone;
        this.vetName = vetName;
        this.vetAddress = vetAddress;
        this.vetPhone = vetPhone;
        this.comments = comments;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDistinguishingMarks() {
        return distinguishingMarks;
    }

    public void setDistinguishingMarks(String distinguishingMarks) {
        this.distinguishingMarks = distinguishingMarks;
    }

    public String getChipID() {
        return chipID;
    }

    public void setChipID(String chipID) {
        this.chipID = chipID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public String getVetAddress() {
        return vetAddress;
    }

    public void setVetAddress(String vetAddress) {
        this.vetAddress = vetAddress;
    }

    public String getVetPhone() {
        return vetPhone;
    }

    public void setVetPhone(String vetPhone) {
        this.vetPhone = vetPhone;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", species='" + species + '\'' +
                ", breed='" + breed + '\'' +
                ", colour='" + colour + '\'' +
                ", distinguishingMarks='" + distinguishingMarks + '\'' +
                ", chipID='" + chipID + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerAddress='" + ownerAddress + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                ", vetName='" + vetName + '\'' +
                ", vetAddress='" + vetAddress + '\'' +
                ", vetPhone='" + vetPhone + '\'' +
                ", comments='" + comments + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
