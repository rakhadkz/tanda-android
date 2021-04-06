package com.example.tanda.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.CollectionProducts;
import com.example.tanda.R;
import com.example.tanda.holders.CollectionProductCardHolder;
import com.example.tanda.models.CollectionProductModel;

import java.util.ArrayList;

public class CollectionProductCardAdapter extends RecyclerView.Adapter<CollectionProductCardHolder> {
    Context context;
    ArrayList<CollectionProductModel> list;
    ArrayList<CollectionProductModel> selected;

    public CollectionProductCardAdapter(Context context, ArrayList<CollectionProductModel> list) {
        this.context = context;
        this.list = list;
        selected = new ArrayList<>();
    }

    @NonNull
    @Override
    public CollectionProductCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_collection_product, null);
        return new CollectionProductCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CollectionProductCardHolder holder, int position) {
        final CollectionProductModel product = list.get(position);
        if (CollectionProducts.mode == 2)
            holder.checked.setVisibility(View.GONE);
        else
            holder.checked.setVisibility(View.VISIBLE);
        if (product.getQuantity() > 1){
            holder.decrease.setVisibility(View.VISIBLE);
            holder.delete.setVisibility(View.GONE);
        }
        else{
            holder.decrease.setVisibility(View.GONE);
            holder.delete.setVisibility(View.VISIBLE);
        }
        holder.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.setQuantity(product.getQuantity() + 1);
                product.setTotal(product.getTotal() + product.getPrice());
                notifyDataSetChanged();
            }
        });
        holder.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.setQuantity(product.getQuantity() - 1);
                product.setTotal(product.getTotal() - product.getPrice());
                notifyDataSetChanged();
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle("Вы уверены?");
                alertDialog.setMessage("Удаление " + product.getName());
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        list.remove(product);
                        notifyDataSetChanged();
                    }
                });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(context.getResources().getColor(R.color.design_default_color_error));
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.GRAY);
            }
        });
        holder.name.setText(product.getName());
        String quantity = String.valueOf(product.getQuantity());
        String replacement = product.getReplacement() + " замен";
        holder.count.setText(quantity);
        String price = product.getPrice() + context.getResources().getString(R.string.tenge_symbol) + " / шт.";
        holder.price.setText(price);
        String total = product.getTotal() + context.getResources().getString(R.string.tenge_symbol);
        holder.total.setText(total);
        holder.replacement.setText(replacement);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Detail", Toast.LENGTH_SHORT).show();
            }
        });
        holder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    selected.add(product);
                else
                    selected.remove(product);
            }
        });
    }

    public ArrayList<CollectionProductModel> getSelected(){
        return selected;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public int getTotal(){
        int total = 0;
        for (CollectionProductModel productModel: list){
            total += productModel.getTotal();
        }
        return total;
    }

}
