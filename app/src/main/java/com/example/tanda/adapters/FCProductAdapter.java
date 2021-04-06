package com.example.tanda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;
import com.example.tanda.holders.FCProductCardHolder;
import com.example.tanda.models.FCProductModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FCProductAdapter extends RecyclerView.Adapter<FCProductCardHolder> {
    Context context;
    ArrayList<FCProductModel> list;
    QuantityCardAdapter adapter;
    Context secondContext;
    public static boolean isClickable = true;
    public FCProductAdapter(Context context, ArrayList<FCProductModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FCProductCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_product_for_collection, null);
        secondContext = parent.getContext();
        return new FCProductCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FCProductCardHolder holder, int position) {
        FCProductModel product = list.get(position);
        holder.name.setText(product.getName());
        Picasso.get().load(product.getImage()).into(holder.image);
        adapter = new QuantityCardAdapter(context, product.getQuantities(), product);
        if (!isClickable){
            holder.itemView.setEnabled(false);
        }
        else{
            holder.itemView.setEnabled(true);
        }
        adapter.notifyDataSetChanged();
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.recycler.setLayoutManager(layoutManager);
        /*holder.recycler.addItemDecoration(MarginItemDecoration(
                resources.getDimension(R.dimen.default_padding).toInt()))*/
        holder.recycler.setAdapter(adapter);
        final LinearLayout layout = holder.itemView.findViewById(R.id.bottom_sheet_container);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogTheme);
                View bottomView = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.layout_bottom_sheet,
                        layout);
                bottomSheetDialog.setContentView(bottomView);
                bottomSheetDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
