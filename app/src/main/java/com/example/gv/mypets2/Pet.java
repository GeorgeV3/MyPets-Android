package com.example.gv.mypets2;

import java.util.Date;

/**
 * Created by Gv on 16/3/2018.
 */

public class Pet {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String species;
    private String breed;
    private String colour;
    private String distinguishingMarks;
    private String chipID;
    private String ownerName;
    private String ownerAddress;
    private String ownerPhone;
    private String vetName;
    private String vetAddress;
    private String vetPhone;
    private String comments;


    public Pet(String name, String dateOfBirth, String gender, String species, String breed, String colour, String distinguishingMarks, String chipID, String ownerName, String ownerAddress, String ownerPhone, String vetName, String vetAddress, String vetPhone, String comments) {
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
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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


    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
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
                '}';
    }
}
