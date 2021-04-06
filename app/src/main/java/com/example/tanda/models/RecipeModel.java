package com.example.tanda.models;

import java.util.ArrayList;

public class RecipeModel {
    private String name;
    private ArrayList<RecipeImagesModel> images;
    private ChefModel author;
    private String noteText;
    private String noteLink;
    private String createdAt;
    private String updateAt;
    private int likes;
    private int comments;
    private ArrayList<StepModel> steps;
    private ArrayList<Integer> prices;
    private ShopModel shop;
    private int meal_price;
    private int consulting_price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<RecipeImagesModel> getImages() {
        return images;
    }

    public void setImages(ArrayList<RecipeImagesModel> images) {
        this.images = images;
    }

    public ChefModel getAuthor() {
        return author;
    }

    public void setAuthor(ChefModel author) {
        this.author = author;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getNoteLink() {
        return noteLink;
    }

    public void setNoteLink(String noteLink) {
        this.noteLink = noteLink;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public ArrayList<StepModel> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<StepModel> steps) {
        this.steps = steps;
    }

    public ArrayList<Integer> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<Integer> prices) {
        this.prices = prices;
    }

    public ShopModel getShop() {
        return shop;
    }

    public void setShop(ShopModel shop) {
        this.shop = shop;
    }

    public int getMeal_price() {
        return meal_price;
    }

    public void setMeal_price(int meal_price) {
        this.meal_price = meal_price;
    }

    public int getConsulting_price() {
        return consulting_price;
    }

    public void setConsulting_price(int consulting_price) {
        this.consulting_price = consulting_price;
    }
}
