package com.example.unsplashapi.presentation.common.bottomsheet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.unsplashapi.R;
import com.example.unsplashapi.data.dto.response.User;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class UserSocialBottom extends BottomSheetDialog {

    public Context context;
    public User user;
    public  LinearLayout layoutInstagram, layoutPortfolio, layoutTwitter, layoutPaypal;
    public TextView instagram, portfolio, twitter, paypal, name, description;
    public ImageView profileImage;

    public UserSocialBottom(@NonNull Context context, User user) {
        super(context);
        this.context = context;
        this.user = user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_item_user_profile);
        profileImage = findViewById(R.id.user_profile_image);
        name = findViewById(R.id.name);
        description = findViewById(R.id.user_description);

        layoutInstagram = findViewById(R.id.layoutInstagram);
        layoutPortfolio = findViewById(R.id.layoutPortfolio);
        layoutTwitter = findViewById(R.id.layoutTwitter);
        layoutPaypal = findViewById(R.id.layoutPaypal);

        instagram = findViewById(R.id.instagram);
        portfolio = findViewById(R.id.porfolio);
        twitter = findViewById(R.id.twitter);
        paypal = findViewById(R.id.paypal);

        instagram.setText(user.getSocial().getInstagram_username());
        layoutInstagram.setVisibility(user.getSocial().getInstagram_username() != null ? View.VISIBLE : View.GONE);

        portfolio.setText(user.getSocial().getPortfolio_url());
        layoutPortfolio.setVisibility(user.getSocial().getPortfolio_url() != null ? View.VISIBLE : View.GONE);

        twitter.setText(user.getSocial().getTwitter_username());
        layoutTwitter.setVisibility(user.getSocial().getTwitter_username() != null ? View.VISIBLE : View.GONE);

        paypal.setText(user.getSocial().getPaypal_email());
        layoutPaypal.setVisibility(user.getSocial().getPaypal_email() != null ? View.VISIBLE : View.GONE);

        Glide.with(context)
                .load(user.getProfileImage().getSmall())
                .into(profileImage);

        name.setText(user.getName());
        description.setText(user.getBio());
    }
}
