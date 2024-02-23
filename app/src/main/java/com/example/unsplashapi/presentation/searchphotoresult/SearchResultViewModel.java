package com.example.unsplashapi.presentation.searchphotoresult;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.unsplashapi.data.dto.response.Photo;
import com.example.unsplashapi.data.dto.response.Search;
import com.example.unsplashapi.data.remote.UnsplashClient;
import com.example.unsplashapi.domain.PhotoDetailRepository;
import com.example.unsplashapi.domain.SearchPhotoRepository;

import java.util.List;

public class SearchResultViewModel extends ViewModel {
    private final MutableLiveData<Search> searchDetail = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final SearchPhotoRepository searchPhotoRepository;

    public SearchResultViewModel() {
        searchPhotoRepository = new SearchPhotoRepository(new UnsplashClient().getUnsplashApi(), SearchPhotoRepository.getQueryRequest());
        searchPhotoRepository.getSearchPhotoDetail(new SearchPhotoRepository.SearchPhotoDetailCallback() {
            @Override
            public void onSuccess(Search searchResult) {
                Log.d(TAG, searchResult.toString());
                searchDetail.setValue(searchResult);
            }

            @Override
            public void onError(String message) {
                Log.d(TAG, message);
                errorMessage.setValue(message);
            }
        });
    }

    public MutableLiveData<Search> getSearchlist() {
        return searchDetail;
    }

    public MutableLiveData<String> getErrorMessage() {
        return errorMessage;
    }
}
