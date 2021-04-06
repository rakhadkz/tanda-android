package com.example.tanda.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class CommentCardHolder extends RecyclerView.ViewHolder {
    public ImageView ava;
    public TextView author, date, content;
    public AppCompatRatingBar ratingBar;
    public CommentCardHolder(@NonNull View itemView) {
        super(itemView);
        this.ava = itemView.findViewById(R.id.comment_author_image);
        this.author = itemView.findViewById(R.id.comment_author);
        this.date = itemView.findViewById(R.id.comment_date);
        this.content = itemView.findViewById(R.id.comment_content);
        this.ratingBar = itemView.findViewById(R.id.comment_author_rate);
        this.ratingBar.setNumStars(5);
    }
}
