package com.example.tanda.models;

public class ChefModel extends UserModel{
    private String ava;
    private String city;
    private int price;
    private double rating;

    public ChefModel(String ava, String firstName, String lastName, String city) {
        super(firstName, lastName, ava);
        this.ava = ava;
        this.city = city;
    }

    public ChefModel(String firstName, String lastName, String ava, String city, int price, double rating) {
        super(firstName, lastName, ava);
        this.ava = ava;
        this.city = city;
        this.price = price;
        this.rating = rating;
    }

    public ChefModel(String firstName, String lastName, String ava, int price, double rating) {
        super(firstName, lastName, ava);
        this.ava = ava;
        this.price = price;
        this.rating = rating;
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

    @Override
    public String getAva() {
        return ava;
    }

    @Override
    public void setAva(String ava) {
        this.ava = ava;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
