package com.example.unsplashapi.data.dto.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchUser {
    @SerializedName("id")
    private String id;

    @SerializedName("username")
    private String username;

    @SerializedName("twitter_username")
    private String twitterUsername;

    @SerializedName("portfolio_url")
    private String portfolioUrl;

    @SerializedName("location")
    private String location;

    @SerializedName("profile_image")
    private ProfileImage profileImage;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public String getLocation() {
        return location;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }


}
