package com.example.unsplashapi.presentation.fragments;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.unsplashapi.R;
import com.example.unsplashapi.data.util.NoInternetDialog;
import com.example.unsplashapi.presentation.adapter.HomePhotoAdapter;
import com.example.unsplashapi.presentation.home.UnsplashViewModel;
import com.facebook.shimmer.ShimmerFrameLayout;

public class HomeFragment extends Fragment {

    private UnsplashViewModel photoViewModel;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private HomePhotoAdapter photoAdapter;

    private ShimmerFrameLayout shimmerLayout;

    public HomeFragment() {}

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        swipeRefreshLayout = view.findViewById(R.id.swipeContainer);
        recyclerView = view.findViewById(R.id.recycler_view_photos);
        shimmerLayout = view.findViewById(R.id.shimmer_view_support);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        shimmerLayout.startShimmer();
        photoAdapter = new HomePhotoAdapter();
        recyclerView.setAdapter(photoAdapter);

        photoViewModel = new ViewModelProvider(this).get(UnsplashViewModel.class);
        photoViewModel.getPhotos().observe(getViewLifecycleOwner(), photos -> {
            photoAdapter.setPhotos(photos, this.getContext());
            shimmerLayout.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            shimmerLayout.stopShimmer();

        });

        photoViewModel.getErrorMessage().observe(getViewLifecycleOwner(), errorMessage -> {
            NoInternetDialog noInternetDialog=new NoInternetDialog(this.getActivity(), errorMessage);
            noInternetDialog.show();
        });

        swipeRefreshLayout.setOnRefreshListener(() -> {
            shimmerLayout.startShimmer();
            shimmerLayout.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(null);
            recyclerView.setAdapter(photoAdapter);
            swipeRefreshLayout.setRefreshing(false);
            shimmerLayout.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        });

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }
}

