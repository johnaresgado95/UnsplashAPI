package com.example.unsplashapi.presentation.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unsplashapi.R;
import com.example.unsplashapi.data.dto.response.Photo;
import com.example.unsplashapi.data.dto.response.Tags;

import java.util.List;

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.ViewHolder> {

    private Context context;
    private List<Tags> tags;

    public void setTags(List<Tags> tags, Context context) {
        this.context = context;
        this.tags = tags;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TagsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tags, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tags tagsView = tags.get(position);
        holder.tagTitle.setText(tagsView.getTitle());
    }

    @Override
    public int getItemCount() {
        return tags != null ? tags.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tagTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tagTitle = itemView.findViewById(R.id.textTags);
        }
    }
}
