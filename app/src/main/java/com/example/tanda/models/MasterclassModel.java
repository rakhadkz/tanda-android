package com.example.tanda.models;

import java.util.ArrayList;
import java.util.Date;

public class MasterclassModel {
    private String id;
    private String recipeImage;
    private String date;
    private int price;
    private String platform;
    private String requirements;
    private String duration;
    private String recipeName;
    private ArrayList<KeyValueModel> requirementsList;
    private ArrayList<KeyValueModel> termsList;
    private ChefModel author;
    private int members;
    private Date date1;

    public MasterclassModel(String id, String recipeImage, String date, int price, String platform, String duration, int members, String recipeName, ArrayList<KeyValueModel> requirementsList, ArrayList<KeyValueModel> termsList, ChefModel author) {
        this.id = id;
        this.recipeImage = recipeImage;
        this.author = author;
        this.date = date;
        this.price = price;
        this.platform = platform;
        this.duration = duration;
        this.recipeName = recipeName;
        this.requirementsList = requirementsList;
        this.termsList = termsList;
        this.members = members;
    }

    public MasterclassModel(String id, String recipeImage, Date date, int price, String platform, String duration, int members, String recipeName, ArrayList<KeyValueModel> requirementsList, ArrayList<KeyValueModel> termsList, ChefModel author) {
        this.id = id;
        this.recipeImage = recipeImage;
        this.author = author;
        this.date1 = date;
        this.price = price;
        this.platform = platform;
        this.duration = duration;
        this.recipeName = recipeName;
        this.requirementsList = requirementsList;
        this.termsList = termsList;
        this.members = members;
    }

    public MasterclassModel(String id, String recipeImage, String recipeName, String date, String requirements, String duration) {
        this.id = id;
        this.recipeImage = recipeImage;
        this.date = date;
        this.requirements = requirements;
        this.duration = duration;
        this.recipeName = recipeName;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public ChefModel getAuthor() {
        return author;
    }

    public void setAuthor(ChefModel author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public ArrayList<KeyValueModel> getRequirementsList() {
        return requirementsList;
    }

    public void setRequirementsList(ArrayList<KeyValueModel> requirementsList) {
        this.requirementsList = requirementsList;
    }

    public ArrayList<KeyValueModel> getTermsList() {
        return termsList;
    }

    public void setTermsList(ArrayList<KeyValueModel> termsList) {
        this.termsList = termsList;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(String recipeImage) {
        this.recipeImage = recipeImage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
