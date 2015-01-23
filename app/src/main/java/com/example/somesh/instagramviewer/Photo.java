package com.example.somesh.instagramviewer;

/**
 * Created by somesh on 1/22/15.
 */
public class Photo {

    private String username;
    private String caption;
    private String photoUrl;

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    private String profilePictureUrl;


    public int getPhotoHeight() {
        return photoHeight;
    }

    public void setPhotoHeight(int photoHeight) {
        this.photoHeight = photoHeight;
    }

    private int photoHeight;


    public Photo(){

    }
    public Photo(String username, String caption, String photoUrl, int photoHeight) {
        this.username = username;
        this.caption = caption;
        this.photoUrl = photoUrl;
        this.photoHeight = photoHeight;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "image - "+getPhotoUrl();
    }
}