package com.example.sample.assignment4.model;

/**
 * Created by darknight on 30/4/17.
 */

public class Discover {

    private String mCityName;
    private String mName;
    private String mDuration;
    private String mReviews;
    private String mText;
    private float mRating;

    /**
     * @param mCityName name of city
     * @param mDuration duration
     * @param mReviews  reviews
     * @param mText     text
     */
    public Discover(final String mCityName, final String mDuration, final String mReviews, final String mText) {
        this.mCityName = mCityName;
        this.mDuration = mDuration;
        this.mReviews = mReviews;
        this.mText = mText;
    }



    /**
     * @param mCityName name of city
     * @param mName     name of user
     * @param mDuration duration
     * @param mReviews  reviews
     * @param mText     text
     * @param mRating   ratings
     */
    public Discover(final String mCityName, final String mName, final String mDuration, final String mReviews,
                    final String mText, final float mRating) {
        this.mCityName = mCityName;
        this.mName = mName;
        this.mDuration = mDuration;
        this.mReviews = mReviews;
        this.mText = mText;
        this.mRating = mRating;
    }


    /**
     * Getter method
     *
     * @return mCityName
     */
    public String getmCityName() {
        return mCityName;
    }

    /**
     * Getter method
     *
     * @return mName
     */
    public String getmName() {
        return mName;
    }

    /**
     * Getter method
     *
     * @return mDuration
     */
    public String getmDuration() {
        return mDuration;
    }

    /**
     * Getter method
     *
     * @return mReviews
     */
    public String getmReviews() {
        return mReviews;
    }

    /**
     * Getter method
     *
     * @return mRating
     */
    public float getmRating() {
        return mRating;
    }

    /**
     * Getter method
     *
     * @return mText
     */
    public String getmText() {
        return mText;
    }

}
