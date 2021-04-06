package com.example.tanda.models;

public class ChefCardModel {
    private String fullName;
    private String ava;
    private int price;
    private double rating;

    public ChefCardModel(String fullName, String ava, int price, double rating) {
        this.fullName = fullName;
        this.ava = ava;
        this.price = price;
        this.rating = rating;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAva() {
        return ava;
    }

    public void setAva(String ava) {
        this.ava = ava;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
