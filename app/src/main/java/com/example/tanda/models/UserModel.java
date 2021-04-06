package com.example.tanda.models;

import com.example.tanda.config.Images;


public class UserModel {
    private String firstName;
    private String lastName;
    private String ava;

    public UserModel(String firstName, String lastName, String ava) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ava = ava;
    }

    public UserModel(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ava = Images.DEFAULT_AVA;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAva() {
        return ava;
    }

    public void setAva(String ava) {
        this.ava = ava;
    }
}
