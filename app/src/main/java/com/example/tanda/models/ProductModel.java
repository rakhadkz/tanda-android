package com.example.tanda.models;

public class ProductModel {
    private String id;
    private String name;
    private int price;
    private boolean isStock;
    private String category;
    private String shortName;
    private String description;
    private String detail;

    public ProductModel(String id, String name, int price, boolean isStock, String category, String shortName, String description, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isStock = isStock;
        this.category = category;
        this.shortName = shortName;
        this.description = description;
        this.detail = detail;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStock() {
        return isStock;
    }

    public void setStock(boolean stock) {
        isStock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
