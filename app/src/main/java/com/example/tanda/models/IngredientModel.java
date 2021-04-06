package com.example.tanda.models;

import com.example.tanda.ConcreteIngredient;

import java.util.ArrayList;

public class IngredientModel {
    private String title;
    private ArrayList<ConcreteIngredient> list;

    public IngredientModel(String title, ArrayList<ConcreteIngredient> list) {
        this.title = title;
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ConcreteIngredient> getList() {
        return list;
    }

    public void setList(ArrayList<ConcreteIngredient> list) {
        this.list = list;
    }
}
