package com.example.tanda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;
import com.example.tanda.holders.MasterClassCardHolder;
import com.example.tanda.models.MasterclassModel;
import com.example.tanda.models.RecipeCardModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MasterClassCardAdapter extends RecyclerView.Adapter<MasterClassCardHolder> implements Filterable {
    Context context;
    ArrayList<MasterclassModel> list;
    ArrayList<MasterclassModel> filteredList;

    public MasterClassCardAdapter(Context context, ArrayList<MasterclassModel> list) {
        this.context = context;
        this.list = list;
        this.filteredList = list;
    }

    @NonNull
    @Override
    public MasterClassCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_masterclass, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new MasterClassCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MasterClassCardHolder holder, int position) {
        MasterclassModel model = filteredList.get(position);
        Picasso.get().load(model.getRecipeImage()).into(holder.image);

        holder.date.setText(model.getDate());
        holder.recipe.setText(model.getRecipeName());
        holder.duration.setText(model.getDuration());
        holder.requirements.setText(model.getRequirements());
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
                    ArrayList<MasterclassModel> filtered = new ArrayList<>();
                    for (MasterclassModel model: list){
                        if (model.getRecipeName().toLowerCase().contains(charString.toLowerCase())){
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
                filteredList = (ArrayList<MasterclassModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
