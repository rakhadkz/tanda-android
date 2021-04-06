package com.example.tanda.models;

public class KeyValueModel {
    private String key;
    private String value;

    public KeyValueModel(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public KeyValueModel(String key){
        this.key = key;
        this.value = null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
