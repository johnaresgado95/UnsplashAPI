package com.example.unsplashapi.presentation.home;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.unsplashapi.BuildConfig;
import com.example.unsplashapi.data.dto.response.Photo;
import com.example.unsplashapi.data.remote.UnsplashClient;
import com.example.unsplashapi.domain.PhotoRepository;

import java.util.List;

public class UnsplashViewModel extends ViewModel {
    private MutableLiveData<List<Photo>> photos = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private PhotoRepository photoRepository;

    public UnsplashViewModel() {
        photoRepository = new PhotoRepository(new UnsplashClient().getUnsplashApi());
        fetchPhotos();
    }

    private void fetchPhotos() {
        photoRepository.getPhotos(BuildConfig.CLIENT_ID, new PhotoRepository.PhotoCallback() {
            @Override
            public void onSuccess(List<Photo> photosList) {
                Log.d(TAG, photosList.toString());
                photos.setValue(photosList);
            }

            @Override
            public void onError(String message) {
                Log.d(TAG, message);
                errorMessage.setValue(message);
            }
        });
    }

    public MutableLiveData<List<Photo>> getPhotos() {
        return photos;
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }
}
