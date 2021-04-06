package com.example.tanda.holders;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class QuantityCardHolder extends RecyclerView.ViewHolder {
    public TextView price, type, count;
    public LinearLayout quantity_layout;
    public QuantityCardHolder(@NonNull View itemView) {
        super(itemView);
        this.price = itemView.findViewById(R.id.card_quantity_price);
        this.type = itemView.findViewById(R.id.card_quantity_type);
        this.count = itemView.findViewById(R.id.card_quantity_count);
        this.quantity_layout = itemView.findViewById(R.id.quantity_layout);
    }

}
