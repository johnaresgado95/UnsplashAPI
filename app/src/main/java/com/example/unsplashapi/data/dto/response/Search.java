package com.example.unsplashapi.data.dto.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Search {
    @SerializedName("total")
    private int total;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("results")
    private List<Results> results;

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<Results> getResults() {
        return results;
    }
}