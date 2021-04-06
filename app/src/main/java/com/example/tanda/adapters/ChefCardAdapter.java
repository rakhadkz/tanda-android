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
import com.example.tanda.holders.ChefCardHolder;
import com.example.tanda.models.ChefModel;
import com.example.tanda.models.RecipeCardModel;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChefCardAdapter extends RecyclerView.Adapter<ChefCardHolder> implements Filterable {
    Context context;
    ArrayList<ChefModel> list;
    ArrayList<ChefModel> filteredList;

    public ChefCardAdapter(Context context, ArrayList<ChefModel> list) {
        this.context = context;
        this.list = list;
        this.filteredList = list;
    }

    @NonNull
    @Override
    public ChefCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_chef, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ChefCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChefCardHolder holder, int position) {
        ChefModel model = filteredList.get(position);
        Picasso.get().load(model.getAva()).resize(100, 100).centerCrop().networkPolicy(NetworkPolicy.OFFLINE).into(holder.ava);
        String fullName = model.getFirstName() + " " + model.getLastName();
        holder.fullName.setText(fullName);
        String price = model.getPrice() + context.getResources().getString(R.string.tenge_symbol);
        holder.price.setText(price);
        String rating = String.valueOf(model.getRating());
        holder.rating.setText(rating);
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
                    ArrayList<ChefModel> filtered = new ArrayList<>();
                    for (ChefModel model: list){
                        if (model.getFirstName().toLowerCase().contains(charString.toLowerCase()) || model.getLastName().toLowerCase().contains(charString.toLowerCase())){
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
                filteredList = (ArrayList<ChefModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
