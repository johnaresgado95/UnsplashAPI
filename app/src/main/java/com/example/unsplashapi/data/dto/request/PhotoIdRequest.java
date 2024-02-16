package com.example.unsplashapi.data.dto.request;

import com.google.gson.annotations.SerializedName;

public class PhotoIdRequest {

    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
