package com.example.unsplashapi.domain;

import com.example.unsplashapi.BuildConfig;
import com.example.unsplashapi.data.dto.response.Search;
import com.example.unsplashapi.data.remote.UnsplashApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPhotoRepository {
    private UnsplashApi unsplashApi;
    public static String queryRequest;

    public SearchPhotoRepository(UnsplashApi unsplashApi, String queryRequest) {
        this.unsplashApi = unsplashApi;
        SearchPhotoRepository.queryRequest = queryRequest;
    }

    public static void setQueryRequest(String queryRequest) {
        SearchPhotoRepository.queryRequest = queryRequest;
    }

    public static String getQueryRequest() {
        return queryRequest;
    }

    public void getSearchPhotoDetail(final SearchPhotoDetailCallback callback) {
        unsplashApi.getSearchedPhotos(SearchPhotoRepository.queryRequest, BuildConfig.CLIENT_ID).enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to fetch photos");
                }
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    public interface SearchPhotoDetailCallback {
        void onSuccess(Search searchResult);
        void onError(String message);
    }
}
