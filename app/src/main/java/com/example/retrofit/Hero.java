package com.example.retrofit;

public class Hero {
    String name, imageUrl;
    private int id;

    public Hero(int id,String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getId() {
        return id;
    }
}