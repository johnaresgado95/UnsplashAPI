package com.example.unsplashapi.data.dto.response;

import com.google.gson.annotations.SerializedName;

public class Urls {
    @SerializedName("regular")
    private String regular;

    public String getRegular() {
        return regular;
    }
}
