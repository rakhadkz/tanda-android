package com.example.tanda.models;

public class RecipeCardModel {
    private String image;
    private String title;
    private String hash;
    private ChefModel author;

    public RecipeCardModel(String image, String title, String hash, ChefModel author) {
        this.image = image;
        this.title = title;
        this.hash = hash;
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public ChefModel getAuthor() {
        return author;
    }

    public void setAuthor(ChefModel author) {
        this.author = author;
    }
}
