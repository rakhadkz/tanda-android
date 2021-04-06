package com.example.tanda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;
import com.example.tanda.holders.KeyValueHolder;
import com.example.tanda.models.KeyValueModel;

import java.util.ArrayList;

public class KeyValueAdapter extends RecyclerView.Adapter<KeyValueHolder> {
    Context context;
    ArrayList<KeyValueModel> list;

    public KeyValueAdapter(Context context, ArrayList<KeyValueModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public KeyValueHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_item, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new KeyValueHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KeyValueHolder holder, int position) {
        if (list.get(position).getValue() == null){
            holder.value.setVisibility(View.GONE);
        }
        holder.key.setText(list.get(position).getKey());
        holder.value.setText(list.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
