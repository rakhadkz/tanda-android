package com.example.tanda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.models.StepModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StepAdapter extends RecyclerView.Adapter<StepHolder>{

    Context context;
    ArrayList<StepModel> list;

    public StepAdapter(Context context, ArrayList<StepModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public StepHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_step, null);
        return new StepHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StepHolder holder, int position) {
        holder.content.setText(list.get(position).getContent());
        if (list.get(position).getNote().equals("")){
            holder.note.setVisibility(View.GONE);
        }else{
            holder.note.setText(list.get(position).getNote());
        }
        holder.number.setText(String.valueOf(position + 1));
        Picasso.get().load(list.get(position).getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
