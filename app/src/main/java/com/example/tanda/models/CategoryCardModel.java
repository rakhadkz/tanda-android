package com.example.tanda.models;

public class CategoryCardModel {
    private String image;
    private String title;
    private String count;

    public CategoryCardModel(String image, String title, String count) {
        this.image = image;
        this.title = title;
        this.count = count;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
