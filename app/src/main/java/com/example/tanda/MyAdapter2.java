package com.example.tanda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.models.IngredientModel;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyHolder2> {

    Context context;
    ArrayList<IngredientModel> list;

    public MyAdapter2(Context context, ArrayList<IngredientModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient, null);
        return new MyHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder2 holder, int position) {
        holder.title.setText(list.get(position).getTitle());

        holder.listView.setLayoutManager(new LinearLayoutManager(context));

        MyAdapter3 myAdapter = new MyAdapter3(context, list.get(position).getList());
        holder.listView.setAdapter(myAdapter);

    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
