package com.example.unsplashapi.domain;

import com.example.unsplashapi.data.dto.response.Photo;
import com.example.unsplashapi.data.remote.UnsplashApi;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRepository {
    private UnsplashApi unsplashApi;

    public PhotoRepository(UnsplashApi unsplashApi) {
        this.unsplashApi = unsplashApi;
    }

    public void getPhotos(String clientId, final PhotoCallback callback) {
        unsplashApi.getPhotos(clientId).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to fetch photos");
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public interface PhotoCallback {
        void onSuccess(List<Photo> photos);
        void onError(String message);
    }
}

