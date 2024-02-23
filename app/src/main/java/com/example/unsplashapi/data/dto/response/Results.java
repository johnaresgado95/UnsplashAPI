package com.example.unsplashapi.data.dto.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {
    @SerializedName("id")
    private String id;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("description")
    private String description;

    @SerializedName("alt_description")
    private String altDescription;

    @SerializedName("likes")
    private int likes;

    @SerializedName("liked_by_user")
    private Boolean likedByUser;

    @SerializedName("user")
    private SearchUser user;

    @SerializedName("urls")
    private Urls urls;

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public int getLikes() {
        return likes;
    }

    public Boolean getLikedByUser() {
        return likedByUser;
    }

    public String getDescription() {
        return description;
    }

    public SearchUser getUser() {
        return user;
    }

    public String getAltDescription() {
        return altDescription;
    }

    public Urls getUrls() {
        return urls;
    }
}
