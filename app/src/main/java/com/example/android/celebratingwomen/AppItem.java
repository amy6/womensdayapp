package com.example.android.celebratingwomen;

/**
 * Created by mahima on 9/3/18.
 */

public class AppItem {

    int imageID;
    String title;
    String description;
    String playStoreID;

    public AppItem(int imageID, String title, String description, String playStoreID) {
        this.imageID = imageID;
        this.title = title;
        this.description = description;
        this.playStoreID = playStoreID;
    }

    public int getImageID() {
        return imageID;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getPlayStoreID() {
        return playStoreID;
    }
}
