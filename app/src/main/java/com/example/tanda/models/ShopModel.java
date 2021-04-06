package com.example.tanda.models;

import java.util.ArrayList;

public class ShopModel {
    private String id;
    private String name;
    private String image;
    private AddressModel address;
    private String description;
    private ArrayList<ContactModel> contacts;
    private ArrayList<WorkingModel> working_hours;
    private int rating;

    public ShopModel(String name, String image, AddressModel address) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.address = address;
    }

    public ShopModel(String id, String name, String image, AddressModel address) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.address = address;
    }

    public ShopModel(String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public ShopModel(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public ShopModel(String id, String name, AddressModel address, String description, ArrayList<ContactModel> contacts, ArrayList<WorkingModel> working_hours, int rating, String image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.contacts = contacts;
        this.working_hours = working_hours;
        this.rating = rating;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<ContactModel> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<ContactModel> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<WorkingModel> getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(ArrayList<WorkingModel> working_hours) {
        this.working_hours = working_hours;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
