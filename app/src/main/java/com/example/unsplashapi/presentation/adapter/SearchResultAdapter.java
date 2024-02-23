package com.example.unsplashapi.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.unsplashapi.R;
import com.example.unsplashapi.data.dto.response.Results;

import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHolder> {
    private Context mContext;
    private List<Results> results;

    public void setResults(Context mContext, List<Results> results) {
        this.mContext = mContext;
        this.results = results;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_result, parent, false);
        return new SearchResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResultViewHolder holder, int position) {
        Results result = results.get(position);
        Glide.with(mContext)
                .load(result.getUrls().getRegular())
                .into(holder.image_photo);
        Glide.with(mContext)
                .load(result.getUser().getProfileImage().getSmall())
                .into(holder.photo_profile_image);
        holder.photoName.setText(result.getUser().getLocation());
        holder.photoTaken.setText(result.getUser().getUsername());
    }

    @Override
    public int getItemCount() {
        return results != null ? results.size() : 0;
    }

    public class SearchResultViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image_photo, photo_profile_image;

        private TextView title, photoName, photoTaken;

        public SearchResultViewHolder(@NonNull View itemView) {
            super(itemView);
            image_photo = itemView.findViewById(R.id.image_photo);
            photo_profile_image = itemView.findViewById(R.id.photo_profile_image);
            title = itemView.findViewById(R.id.title);
            photoName = itemView.findViewById(R.id.photo_name);
            photoTaken = itemView.findViewById(R.id.photo_taken);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
