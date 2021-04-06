package com.example.tanda;

public class ConcreteIngredient {
    private String title;
    private String detail;
    private Boolean required;
    private ConcreteIngredient replacement;

    public ConcreteIngredient(String title, String detail) {
        this.title = title;
        this.detail = detail;
        this.required = true;
    }

    public ConcreteIngredient(String title, String detail, Boolean required) {
        this.title = title;
        this.detail = detail;
        this.required = required;
    }

    public ConcreteIngredient getReplacement() {
        return replacement;
    }

    public void setReplacement(ConcreteIngredient replacement) {
        this.replacement = replacement;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
