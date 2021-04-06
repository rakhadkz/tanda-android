package com.example.tanda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;
import com.example.tanda.holders.CoverCardHolder;
import com.example.tanda.models.CoverModel;

import java.util.ArrayList;

public class CoverCardAdapter extends RecyclerView.Adapter<CoverCardHolder> {
    Context context;
    ArrayList<CoverModel> covers;
    int currentIndex = -1;
    public CoverCardAdapter(Context context) {
        this.context = context;
        this.covers = new ArrayList<>();

        covers.add(new CoverModel("a", R.drawable.ava));
        covers.add(new CoverModel("b", R.drawable.ava));
        covers.add(new CoverModel("c", R.drawable.ava));
        covers.add(new CoverModel("d", R.drawable.ava));
        covers.add(new CoverModel("e", R.drawable.ava));
    }

    @NonNull
    @Override
    public CoverCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_cover, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new CoverCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CoverCardHolder holder, final int position) {
        holder.cover.setImageDrawable(context.getResources().getDrawable(covers.get(position).getImage()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = position;
                notifyDataSetChanged();
            }
        });
        if (currentIndex == position)
            highlightView(holder);
        else
            unHighlightView(holder);
    }

    public String getCover(){
        return covers.get(currentIndex).getName();
    }

    void unHighlightView(CoverCardHolder holder){
        holder.checked.setVisibility(View.GONE);
    }
    void highlightView(CoverCardHolder holder){
        holder.checked.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return covers.size();
    }
}
