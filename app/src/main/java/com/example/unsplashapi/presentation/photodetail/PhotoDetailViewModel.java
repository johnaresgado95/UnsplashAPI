package com.example.unsplashapi.presentation.photodetail;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.unsplashapi.data.dto.response.Photo;
import com.example.unsplashapi.data.remote.UnsplashClient;
import com.example.unsplashapi.domain.PhotoDetailRepository;

public class PhotoDetailViewModel extends ViewModel {
    private final MutableLiveData<Photo> photodetail = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final PhotoDetailRepository photoDetailRepository;

    public PhotoDetailViewModel() {
        photoDetailRepository = new PhotoDetailRepository(new UnsplashClient().getUnsplashApi(), PhotoDetailRepository.getPhotoId());
        photoDetailRepository.getPhotoDetail(new PhotoDetailRepository.PhotoDetailCallback() {
            @Override
            public void onSuccess(Photo photoDetail) {
                Log.d(TAG, photoDetail.toString());
                photodetail.setValue(photoDetail);
            }

            @Override
            public void onError(String message) {
                Log.d(TAG, message);
                errorMessage.setValue(message);
            }
        });
    }

    public MutableLiveData<Photo> getPhotoDetail() {
        return photodetail;
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }

}
