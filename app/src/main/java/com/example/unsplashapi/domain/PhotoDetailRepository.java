package com.example.unsplashapi.domain;

import com.example.unsplashapi.BuildConfig;
import com.example.unsplashapi.data.dto.response.Photo;
import com.example.unsplashapi.data.remote.UnsplashApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoDetailRepository {
    private UnsplashApi unsplashApi;

    public static String photoId;

    public PhotoDetailRepository(UnsplashApi unsplashApi, String photoId) {
        this.unsplashApi = unsplashApi;
        PhotoDetailRepository.photoId = photoId;
    }

    public static void setPhotoId(String photoId) {
        PhotoDetailRepository.photoId = photoId;
    }

    public static String getPhotoId() {
        return photoId;
    }

    public void getPhotoDetail(final PhotoDetailRepository.PhotoDetailCallback callback) {
        unsplashApi.getPhotoDetail(PhotoDetailRepository.photoId, BuildConfig.CLIENT_ID).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to fetch photos");
                }
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public interface PhotoDetailCallback {
        void onSuccess(Photo photos);
        void onError(String message);
    }
}
