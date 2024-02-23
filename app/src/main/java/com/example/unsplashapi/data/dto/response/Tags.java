package com.example.unsplashapi.data.dto.response;

import com.google.gson.annotations.SerializedName;

public class Tags {

    @SerializedName("type")
    private String types;

    @SerializedName("title")
    private String title;

    public String getTypes() {
        return types;
    }

    public String getTitle() {
        return title;
    }
}
