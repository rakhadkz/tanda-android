package com.example.tanda.models;

import com.example.tanda.R;

public class CoverModel {
    public static int CURRENT_COVER = -1;
    public static int[] COVER_IMAGES = {R.drawable.back1, R.drawable.back2, R.drawable.back3, R.drawable.back4};


    private String name;
    private int image;

    public CoverModel(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
