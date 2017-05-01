package com.example.sample.assignment4.model;

/**
 * Created by darknight on 1/5/17.
 */

public class Network {

    private String city;
    private float ratings;
    private int image;
    private String name;


    /**
     * @param image   : image resource
     * @param name    : name
     * @param city    : city
     * @param ratings : ratings
     */
    public Network(final int image, final String name, final String city, final float ratings) {
        this.image = image;
        this.name = name;
        this.city = city;
        this.ratings = ratings;
    }

    /**
     * Getter for image resource
     *
     * @return image
     */
    public int getImage() {
        return image;
    }

    /**
     * Getter for name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for city
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Getter for ratings
     *
     * @return ratings
     */
    public float getRatings() {
        return ratings;
    }

}
