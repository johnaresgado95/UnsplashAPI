package com.example.unsplashapi.data.dto.response;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("location")
    private String location;

    @SerializedName("name")
    private String name;

    @SerializedName("instagram_username")
    private String instagramUsername;

    @SerializedName("profile_image")
    private ProfileImage profileImage;

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getInstagramUsername() {
        return instagramUsername;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }
}
