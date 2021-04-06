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
import com.example.tanda.holders.RecipeCategoryCardHolder;
import com.example.tanda.models.RecipeCategoryModel;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeCategoryCardAdapter extends RecyclerView.Adapter<RecipeCategoryCardHolder> implements Filterable {

    Context context;
    ArrayList<RecipeCategoryModel> list;
    ArrayList<RecipeCategoryModel> filteredList;

    public RecipeCategoryCardAdapter(Context context, ArrayList<RecipeCategoryModel> list) {
        this.context = context;
        this.list = list;
        this.filteredList = list;
    }

    @NonNull
    @Override
    public RecipeCategoryCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_category, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new RecipeCategoryCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeCategoryCardHolder holder, int position) {
        RecipeCategoryModel recipeCategoryModel = filteredList.get(position);
        Picasso.get().load(recipeCategoryModel.getImage()).resize(400, 400).centerCrop().networkPolicy(NetworkPolicy.OFFLINE).into(holder.image);
        holder.title.setText(recipeCategoryModel.getName());
        String ofRec = " " + context.getResources().getString(R.string.of_recipes);
        holder.count.setText(recipeCategoryModel.getCount() + ofRec);
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
                    ArrayList<RecipeCategoryModel> filtered = new ArrayList<>();
                    for (RecipeCategoryModel model: list){
                        if (model.getName().toLowerCase().contains(charString.toLowerCase()) || String.valueOf(model.getCount()).toLowerCase().contains(charString.toLowerCase())){
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
                filteredList = (ArrayList<RecipeCategoryModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
