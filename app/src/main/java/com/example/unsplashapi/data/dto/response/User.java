package com.example.unsplashapi.data.dto.response;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("location")
    private String location;

    @SerializedName("name")
    private String name;
    @SerializedName("bio")
    private String bio;

    @SerializedName("instagram_username")
    private String instagramUsername;

    @SerializedName("profile_image")
    private ProfileImage profileImage;

    @SerializedName("social")
    private Social social;

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getInstagramUsername() {
        return instagramUsername;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }

    public Social getSocial() {
        return social;
    }

    public class Social {

        @SerializedName("instagram_username")
        private String instagram_username;

        @SerializedName("portfolio_url")
        private String portfolio_url;

        @SerializedName("twitter_username")
        private String twitter_username;

        @SerializedName("paypal_email")
        private String paypal_email;

        public String getInstagram_username() {
            return instagram_username;
        }

        public String getPortfolio_url() {
            return portfolio_url;
        }

        public String getTwitter_username() {
            return twitter_username;
        }

        public String getPaypal_email() {
            return paypal_email;
        }
    }

}
