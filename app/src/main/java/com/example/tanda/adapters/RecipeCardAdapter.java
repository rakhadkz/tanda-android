package com.example.tanda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.DownloadImagesTask;
import com.example.tanda.R;
import com.example.tanda.holders.RecipeCardHolder;
import com.example.tanda.models.RecipeCardModel;
import com.example.tanda.models.RecipeCategoryModel;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeCardAdapter extends RecyclerView.Adapter<RecipeCardHolder> implements Filterable {
    Context context;
    ArrayList<RecipeCardModel> list;
    ArrayList<RecipeCardModel> filteredList;
    public RecipeCardAdapter(Context context, ArrayList<RecipeCardModel> list) {
        this.context = context;
        this.list = list;
        this.filteredList = list;
    }

    @NonNull
    @Override
    public RecipeCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recipe, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new RecipeCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeCardHolder holder, int position) {
        RecipeCardModel model = filteredList.get(position);

        Picasso.get().load(model.getImage()).resize(400, 400).centerCrop().networkPolicy(NetworkPolicy.OFFLINE).into(holder.image);
        Picasso.get().load(model.getAuthor().getAva()).resize(100, 100).centerCrop().networkPolicy(NetworkPolicy.OFFLINE).into(holder.author_ava);


        holder.title.setText(model.getTitle());
        holder.hash.setText(model.getHash());
        holder.author_full_name.setText(model.getAuthor().getFirstName() + " " + model.getAuthor().getLastName());
        holder.author_city.setText(model.getAuthor().getCity());
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()){
                    filteredList = list;
                }else{
                    ArrayList<RecipeCardModel> filtered = new ArrayList<>();
                    for (RecipeCardModel model: list){
                        if (model.getTitle().toLowerCase().contains(charString.toLowerCase()) || model.getHash().toLowerCase().contains(charString.toLowerCase()) || model.getAuthor().getFirstName().toLowerCase().contains(charString.toLowerCase()) || model.getAuthor().getLastName().toLowerCase().contains(charString.toLowerCase())){
                            filtered.add(model);
                        }
                    }
                    filteredList = filtered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredList = (ArrayList<RecipeCardModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
