package com.example.tanda.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class KeyValue2Holder extends RecyclerView.ViewHolder {
    public TextView key, value;
    public KeyValue2Holder(@NonNull View itemView) {
        super(itemView);
        this.key = itemView.findViewById(R.id.item_key);
        this.value = itemView.findViewById(R.id.item_value);
    }
}
