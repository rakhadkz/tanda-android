package com.example.tanda;

public class CommentModel {
    private String ava;
    private String content;
    private String author;
    private String date;
    private float rating;

    public CommentModel(String ava, String author, String content, String date) {
        this.ava = ava;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public CommentModel(String ava, String author, String content, String date, float rating) {
        this.ava = ava;
        this.content = content;
        this.author = author;
        this.date = date;
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getAva() {
        return ava;
    }

    public void setAva(String ava) {
        this.ava = ava;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
