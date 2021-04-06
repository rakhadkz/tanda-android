package com.example.tanda.models;

import java.util.ArrayList;

public class FCProductModel {
    private String id;
    private String image;
    private String name;
    private ArrayList<QuantityModel> quantities;

    public FCProductModel(String id, String image, String name, ArrayList<QuantityModel> quantities) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.quantities = quantities;
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

    public ArrayList<QuantityModel> getQuantities() {
        return quantities;
    }

    public void setQuantities(ArrayList<QuantityModel> quantities) {
        this.quantities = quantities;
    }
}
