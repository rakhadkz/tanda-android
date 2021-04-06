package com.example.tanda.models;

public class RecipeImagesModel {
    private String url;
    private int step;
    private int priority;

    public RecipeImagesModel(String url, int step, int priority) {
        this.url = url;
        this.step = step;
        this.priority = priority;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
