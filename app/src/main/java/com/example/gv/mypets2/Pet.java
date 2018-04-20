package com.example.gv.mypets2;


import java.util.Date;

/**
 * Created by Gv on 16/3/2018.
 */

public class Pet {
    private String name;
    private Date dateOfBirth;
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
    private String imageUrl;


    public Pet(String name, Date dateOfBirth, String gender, String species, String breed, String colour, String distinguishingMarks, String chipID, String ownerName, String ownerAddress, String ownerPhone, String vetName, String vetAddress, String vetPhone, String comments , String imageUrl) {
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

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public String getColour() {
        return colour;
    }

    public String getDistinguishingMarks() {
        return distinguishingMarks;
    }

    public String getChipID() {
        return chipID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public String getVetName() {
        return vetName;
    }

    public String getVetAddress() {
        return vetAddress;
    }

    public String getVetPhone() {
        return vetPhone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setDistinguishingMarks(String distinguishingMarks) {
        this.distinguishingMarks = distinguishingMarks;
    }

    public void setChipID(String chipID) {
        this.chipID = chipID;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public void setVetAddress(String vetAddress) {
        this.vetAddress = vetAddress;
    }

    public void setVetPhone(String vetPhone) {
        this.vetPhone = vetPhone;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getComments() { return comments; }

    public String getImageUrl(){ return imageUrl; }

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
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
