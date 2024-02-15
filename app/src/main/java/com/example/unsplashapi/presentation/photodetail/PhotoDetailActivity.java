package com.example.unsplashapi.presentation.photodetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.unsplashapi.R;
import com.example.unsplashapi.data.util.DisplayUtil;
import com.example.unsplashapi.data.util.NoInternetDialog;
import com.example.unsplashapi.domain.PhotoDetailRepository;
import com.facebook.shimmer.ShimmerFrameLayout;

public class PhotoDetailActivity extends AppCompatActivity {

    private CardView cViewMain;
    private PhotoDetailViewModel photoDetailViewModel;
    private ImageView imageMain, userImage;
    private RelativeLayout backButton;
    private LinearLayout pLL;
    private TextView title, name, likes, views, downloads, description;

    private ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        pLL = findViewById(R.id.pLL);
        cViewMain = findViewById(R.id.cViewMain);
        imageMain = findViewById(R.id.imageMain);
        userImage = findViewById(R.id.user_profile_image);
        backButton = findViewById(R.id.backButton);
        title = findViewById(R.id.title);
        name = findViewById(R.id.name);
        likes = findViewById(R.id.likes);
        views = findViewById(R.id.total_views);
        downloads = findViewById(R.id.total_downloads);
        description = findViewById(R.id.description);
        shimmerFrameLayout = findViewById(R.id.shimmer_view_support_detail);
        shimmerFrameLayout.startShimmer();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        PhotoDetailRepository.setPhotoId(bundle.getString("id"));
        photoDetailViewModel = new ViewModelProvider(this).get(PhotoDetailViewModel.class);
        photoDetailViewModel.getPhotoDetail().observe(this, photoDetail -> {

            Glide.with(this)
                    .load(photoDetail.getUrls().getRegular())
                    .into(imageMain);
            Glide.with(this)
                    .load(photoDetail.getUser().getProfileImage().getSmall())
                    .into(userImage);
            title.setText(photoDetail.getUser().getLocation() == null ? "No Content" : photoDetail.getUser().getLocation());
            name.setText(photoDetail.getUser().getName());
            likes.setText(photoDetail.getLikes());
            views.setText(photoDetail.getViews());
            downloads.setText(photoDetail.getDownloads());
            description.setText(photoDetail.getDescription() == null ? "No content to display" : photoDetail.getDescription());

            shimmerFrameLayout.setVisibility(View.GONE);
            cViewMain.setVisibility(View.VISIBLE);
            backButton.setVisibility(View.VISIBLE);
            pLL.setVisibility(View.VISIBLE);
            shimmerFrameLayout.stopShimmer();
        });

        photoDetailViewModel.getErrorMessage().observe(this, errorMessage -> {
            NoInternetDialog noInternetDialog = new NoInternetDialog(this, errorMessage);
            noInternetDialog.show();
        });

        backButton.setOnClickListener(view -> {
            finish();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}