package com.example.tanda;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder2 extends RecyclerView.ViewHolder{

    TextView title;
    RecyclerView listView;


    public MyHolder2(@NonNull View itemView) {
        super(itemView);
        this.title = itemView.findViewById(R.id.ingredient_title);
        this.listView = itemView.findViewById(R.id.list_ingredients);
    }
}
