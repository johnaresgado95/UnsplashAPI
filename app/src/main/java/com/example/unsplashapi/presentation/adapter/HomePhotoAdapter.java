package com.example.unsplashapi.presentation.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.unsplashapi.R;
import com.example.unsplashapi.data.dto.response.Photo;
import com.example.unsplashapi.presentation.photodetail.PhotoDetailActivity;

import java.util.List;

public class HomePhotoAdapter extends RecyclerView.Adapter<HomePhotoAdapter.PhotoViewHolder> {

    private Context context;
    private List<Photo> photos;

    public void setPhotos(List<Photo> photos, Context context) {
        this.context = context;
        this.photos = photos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        Photo photo = photos.get(position);

        Glide.with(context)
                .load(photo.getUrls().getRegular())
                .into(holder.photoImageView);

        if (photo.isLiked_by_user()) {
            holder.likeByUserTrue.setVisibility(View.VISIBLE);
        } else {
            holder.likeByUserFalse.setVisibility(View.VISIBLE);
        }

        holder.photoName.setText(photo.getUser().getLocation() == null ? "No Content" : photo.getUser().getLocation());
        holder.photoTaken.setText(photo.getUser().getName() == null ? "No Content" : photo.getUser().getName());
        holder.likes.setText(photo.getLikes() == null ? "0" : photo.getLikes());
    }

    @Override
    public int getItemCount() {
        return photos != null ? photos.size() : 0;
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView photoImageView, likeByUserTrue, likeByUserFalse;
        TextView photoName, photoTaken, likes;

        CardView pCard;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            pCard = itemView.findViewById(R.id.pi_card);
            photoImageView = itemView.findViewById(R.id.image_photo);
            likeByUserTrue = itemView.findViewById(R.id.like_by_user_true);
            likeByUserFalse = itemView.findViewById(R.id.like_by_user_false);
            photoName = itemView.findViewById(R.id.photo_name);
            photoTaken = itemView.findViewById(R.id.photo_taken);
            likes = itemView.findViewById(R.id.likes);
            pCard.setOnClickListener((View.OnClickListener) this);
        }

        @Override
        public void onClick(View view) {
            Photo photo = photos.get(getAdapterPosition());
            Intent i = new Intent(context, PhotoDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("id", photo.getId());
            i.putExtras(bundle);
            context.startActivity(i);
        }
    }
}
