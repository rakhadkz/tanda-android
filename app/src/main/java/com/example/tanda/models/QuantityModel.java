package com.example.tanda.models;

import java.util.HashMap;

public class QuantityModel {
    private String id;
    private int price;
    private String type;
    private int count;

    public static HashMap<String, Integer> hashPrice = new HashMap<>();

    public QuantityModel(String id, int price, String type) {
        this.id = id;
        this.price = price;
        this.type = type;
        if (hashPrice.containsKey(id) && hashPrice.get(id) != null) this.count = hashPrice.get(id);
        else this.count = 0;
    }

    public QuantityModel(String id, int price, String type, int count) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
