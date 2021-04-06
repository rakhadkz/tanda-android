package com.example.tanda.models;

public class CollectionModel {
    private String id;
    private String name;
    private String image;
    private int members;
    private ShopModel shop;

    public CollectionModel(String name, String image, int members, ShopModel shop) {
        this.name = name;
        this.image = image;
        this.members = members;
        this.shop = shop;
    }

    public CollectionModel(String image) {
        this.image = image;
    }

    public CollectionModel(){
        this.id = "";
        this.name = "";
        this.image = "";
        this.members = 0;
        this.shop = null;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public ShopModel getShop() {
        return shop;
    }

    public void setShop(ShopModel shop) {
        this.shop = shop;
    }

    public static void createCollection(String name, String cover, String shopID, String[] members){

    }
}
