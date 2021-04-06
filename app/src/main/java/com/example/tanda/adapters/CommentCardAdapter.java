package com.example.tanda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.CommentModel;
import com.example.tanda.R;
import com.example.tanda.holders.CommentCardHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CommentCardAdapter extends RecyclerView.Adapter<CommentCardHolder> {
    Context context;
    ArrayList<CommentModel> list;

    public CommentCardAdapter(Context context, ArrayList<CommentModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CommentCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_comment, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new CommentCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentCardHolder holder, int position) {
        holder.author.setText(list.get(position).getAuthor());
        holder.content.setText(list.get(position).getContent());
        holder.date.setText(list.get(position).getDate());
        Picasso.get().load(list.get(position).getAva()).into(holder.ava);
        holder.ratingBar.setRating(list.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
