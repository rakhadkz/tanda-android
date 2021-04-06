package com.example.tanda.models;

import com.example.tanda.RecipeCategory;

public class RecipeCategoryModel {
    private String id;
    private String name;
    private String description;
    private String image;
    private String lastMonday;
    private int count;
    private int orders;
    private int lessons;

    public RecipeCategoryModel(String name, String image, int count){
        this.name = name;
        this.image = image;
        this.count = count;
    }

    public RecipeCategoryModel(String id, String name, String image, String description, int count){
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.count = count;
    }

    public RecipeCategoryModel(String name, String description, String image, String lastMonday, int count, int orders, int lessons) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.lastMonday = lastMonday;
        this.count = count;
        this.orders = orders;
        this.lessons = lessons;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLastMonday() {
        return lastMonday;
    }

    public void setLastMonday(String lastMonday) {
        this.lastMonday = lastMonday;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getLessons() {
        return lessons;
    }

    public void setLessons(int lessons) {
        this.lessons = lessons;
    }
}
