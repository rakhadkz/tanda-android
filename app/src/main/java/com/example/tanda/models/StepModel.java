package com.example.tanda.models;

public class StepModel {
    private String image;
    private String content;
    private String note;

    public StepModel(String image, String content, String note) {
        this.image = image;
        this.content = content;
        this.note = note;
    }

    public StepModel(String image, String content) {
        this.image = image;
        this.content = content;
        this.note = "";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
