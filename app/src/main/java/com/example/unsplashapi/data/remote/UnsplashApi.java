package com.example.unsplashapi.data.remote;

import com.example.unsplashapi.data.dto.response.Photo;
import com.example.unsplashapi.data.dto.response.Search;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UnsplashApi {
    @GET("photos/")
    Call<List<Photo>> getPhotos(@Query("client_id") String clientId);

    @GET("photos/{id}")
    Call<Photo> getPhotoDetail(
            @Path("id") String id,
            @Query("client_id") String clientId
    );

    @GET("search/photos")
    Call<Search> getSearchedPhotos(
            @Query("query") String query,
            @Query("client_id") String clientId
    );
}
