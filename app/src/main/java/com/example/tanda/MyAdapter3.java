package com.example.tanda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter3 extends RecyclerView.Adapter<MyHolder3> {

    Context context;
    ArrayList<ConcreteIngredient> list;

    public MyAdapter3(Context context, ArrayList<ConcreteIngredient> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_concrete_ingredient, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new MyHolder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder3 holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.detail.setText(list.get(position).getDetail());
        if (!list.get(position).getRequired())
            holder.required.setVisibility(View.VISIBLE);
        else
            holder.required.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
