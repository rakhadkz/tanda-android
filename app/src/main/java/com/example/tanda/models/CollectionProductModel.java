package com.example.tanda.models;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectionProductModel {
    private String id;
    private String name;
    private int quantity;
    private int replacement;
    private int price;
    private int total;

    public static ArrayList<CollectionProductModel> selectedProducts = new ArrayList<>();
    public static HashMap<String, CollectionProductModel> selectedProductsHash = new HashMap<>();

    public CollectionProductModel(String name, int quantity, int replacement, int price) {
        this.name = name;
        this.quantity = quantity;
        this.replacement = replacement;
        this.price = price;
        this.total = this.price * quantity;
    }

    public CollectionProductModel(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.replacement = 0;
        this.price = price;
        this.total = this.price * quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReplacement() {
        return replacement;
    }

    public void setReplacement(int replacement) {
        this.replacement = replacement;
    }
}
