package com.example.tanda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;
import com.example.tanda.holders.KeyValue2Holder;
import com.example.tanda.holders.KeyValueHolder;
import com.example.tanda.models.KeyValueModel;

import java.util.ArrayList;

public class KeyValue2Adapter extends RecyclerView.Adapter<KeyValue2Holder> {
    Context context;
    ArrayList<KeyValueModel> list;

    public KeyValue2Adapter(Context context, ArrayList<KeyValueModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public KeyValue2Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_item2, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new KeyValue2Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KeyValue2Holder holder, int position) {
        holder.key.setText(list.get(position).getKey());
        holder.value.setText(list.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
