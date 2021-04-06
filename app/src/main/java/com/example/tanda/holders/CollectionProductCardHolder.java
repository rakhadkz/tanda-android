package com.example.tanda.holders;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;

public class CollectionProductCardHolder extends RecyclerView.ViewHolder {
    public TextView name, price, replacement;
    public CheckBox checked;
    public ImageButton delete, increase, decrease;
    public TextView count, total;
    public CollectionProductCardHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.collection_product_name);
        this.price = itemView.findViewById(R.id.collection_product_price);
        this.replacement = itemView.findViewById(R.id.collection_product_replacement);
        this.checked = itemView.findViewById(R.id.collection_product_checked);
        this.total = itemView.findViewById(R.id.collection_product_price_total);

        this.delete = itemView.findViewById(R.id.btn_collection_product_delete);
        this.increase = itemView.findViewById(R.id.btn_collection_product_increase);
        this.decrease = itemView.findViewById(R.id.btn_collection_product_decrease);
        this.count = itemView.findViewById(R.id.collection_product_count);
    }
}
