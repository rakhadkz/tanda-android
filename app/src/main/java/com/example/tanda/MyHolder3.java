package com.example.tanda;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder3 extends RecyclerView.ViewHolder {
    TextView title, detail, required;
    public MyHolder3(@NonNull View itemView) {
        super(itemView);
        this.title = itemView.findViewById(R.id.concrete_title);
        this.detail = itemView.findViewById(R.id.concrete_detail);
        this.required = itemView.findViewById(R.id.concrete_required);
    }
}
