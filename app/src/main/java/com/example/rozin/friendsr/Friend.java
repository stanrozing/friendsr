package com.example.rozin.friendsr;

import java.io.Serializable;

/**
 * Created by rozin on 20-2-2018.
 */

public class Friend implements Serializable {

    // properties
    private String name, bio;
    private int drawableId;
    private float rating;

    // constructor
    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    // methods of the class
    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

}
