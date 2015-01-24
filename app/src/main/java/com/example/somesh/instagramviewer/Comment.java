package com.example.somesh.instagramviewer;

import java.util.ArrayList;

/**
 * Created by somesh on 1/24/15.
 */
public class Comment {

    private String commentText;
    private String commenter;
    private long creationTime;

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public Comment() {

    }

    public Comment(String commentText, String commenter, long creationTime) {
        this.commentText = commentText;
        this.commenter = commenter;
        this.creationTime = creationTime;
    }

    public static Comment getLatestComment(ArrayList<Comment> comments) {

        long max=comments.get(0).getCreationTime();
        int indexMax =0;
        for (int i=1;i<comments.size();i++){
            if(comments.get(i).creationTime>max){
                max = comments.get(i).creationTime;
                indexMax = i;
            }
        }

        return comments.get(indexMax);

    }
}
