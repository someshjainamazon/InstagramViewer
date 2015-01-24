package com.example.somesh.instagramviewer;

import android.text.format.DateUtils;

import java.util.ArrayList;

/**
 * Created by somesh on 1/22/15.
 */
public class Photo {

    private String username;
    private String caption;
    private String photoUrl;
    private String timeElapsed;
    private int likesCount;
    private Comment comment;


    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }


    public String getLocationName() {
        if(locationName==null || locationName=="") return "";
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    private String locationName;


    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }



    public String getTimeElapsed() {

        if(timeElapsed.contains("seconds")){
            String [] arrList = timeElapsed.split(" ");
            return arrList[0]+" sec";
        }
        return timeElapsed;
    }

    public void setTimeElapsed(long time) {
        this.timeElapsed = (String)DateUtils.getRelativeTimeSpanString(time, System.currentTimeMillis()/1000,DateUtils.SECOND_IN_MILLIS);
    }


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
        if(caption==null) return "";
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
