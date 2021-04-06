package com.example.tanda;

public class Model {
    private String title;
    private String description;
    private String image;
    private String author;
    private String username;

    public Model(String title, String description, String image, String author, String username) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
