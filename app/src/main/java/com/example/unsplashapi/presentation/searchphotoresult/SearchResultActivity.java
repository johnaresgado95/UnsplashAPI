package com.example.unsplashapi.presentation.searchphotoresult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unsplashapi.R;
import com.example.unsplashapi.data.util.NoInternetDialog;
import com.example.unsplashapi.domain.SearchPhotoRepository;
import com.example.unsplashapi.presentation.adapter.SearchResultAdapter;

public class SearchResultActivity extends AppCompatActivity {

    private SearchResultViewModel searchResultViewModel;
    private RecyclerView recyclerView;
    private TextView title;
    private ImageView back;
    private SearchResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        recyclerView = findViewById(R.id.recycler_view_search_result);
        title = findViewById(R.id.searchtitle);
        back = findViewById(R.id.back);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SearchPhotoRepository.setQueryRequest(bundle.getString("id"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        title.setText(bundle.getString("id"));
        adapter = new SearchResultAdapter();
        recyclerView.setAdapter(adapter);

        searchResultViewModel = new ViewModelProvider(this).get(SearchResultViewModel.class);
        searchResultViewModel.getSearchlist().observe(this, searchList -> {
            adapter.setResults(this, searchList.getResults());
        });

        searchResultViewModel.getErrorMessage().observe(this, errorMessage -> {
            NoInternetDialog noInternetDialog = new NoInternetDialog(this, errorMessage);
            noInternetDialog.show();
        });

        back.setOnClickListener(view -> {
            finish();
        });
    }
}