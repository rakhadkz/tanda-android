package com.example.tanda.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.CollectionCover;
import com.example.tanda.CollectionProducts;
import com.example.tanda.DownloadImagesTask;
import com.example.tanda.R;
import com.example.tanda.holders.CollectionCardHolder;
import com.example.tanda.models.CollectionModel;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CollectionCardAdapter extends RecyclerView.Adapter<CollectionCardHolder>{
    Context context;
    ArrayList<CollectionModel> list;

    public CollectionCardAdapter(Context context, ArrayList<CollectionModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CollectionCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_collection, null);
        return new CollectionCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionCardHolder holder, int position) {
        final CollectionModel collection = list.get(position);
        holder.shopName.setText(collection.getShop().getName());
        String members = collection.getMembers() + " участников";
        holder.members.setText(members);
        //Picasso.get().load(CollectionCover.getCover(collection)).resize(400, 400).centerCrop().into(holder.cover);
        holder.cover.setImageBitmap(CollectionCover.decodeSampledBitmapFromResource(context.getResources(), CollectionCover.getCover(collection), 300, 300));
        //holder.cover.setImageDrawable(context.getResources().getDrawable(CollectionCover.getCover(collection)));

        Picasso.get().load(collection.getShop().getImage()).resize(100, 100).centerCrop().networkPolicy(NetworkPolicy.OFFLINE).into(holder.shopImage);


        holder.title.setText(collection.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CollectionProducts.class);
                intent.putExtra("mode", 0);
                CollectionProducts.collectionModel = collection;
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
