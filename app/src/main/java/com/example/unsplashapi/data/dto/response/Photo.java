package com.example.unsplashapi.data.dto.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo {
    @SerializedName("id")
    private String id;

    @SerializedName("urls")
    private Urls urls;

    @SerializedName("likes")
    private String likes;

    @SerializedName("alt_description")
    private String alt_description;

    @SerializedName("description")
    private String description;

    @SerializedName("liked_by_user")
    private boolean liked_by_user;

    @SerializedName("user")
    private User user;

    @SerializedName("views")
    private String views;

    @SerializedName("downloads")
    private String downloads;

    @SerializedName("tags")
    private List<Tags> tags;

    public List<Tags> getTags() {
        return tags;
    }
    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }
    public String getId() {
        return id;
    }

    public Urls getUrls() {
        return urls;
    }

    public String getLikes() {
        return likes;
    }

    public boolean isLiked_by_user() {
        return liked_by_user;
    }

    public User getUser() {
        return user;
    }

    public String getAlt_description() {
        return alt_description;
    }

    public String getViews() {
        return views;
    }

    public String getDownloads() {
        return downloads;
    }

    public String getDescription() {
        return description;
    }
}
