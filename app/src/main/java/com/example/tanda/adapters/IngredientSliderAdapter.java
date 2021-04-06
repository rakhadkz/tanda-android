package com.example.tanda.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.models.IngredientModel;
import com.example.tanda.MyAdapter3;
import com.example.tanda.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class IngredientSliderAdapter extends
        SliderViewAdapter<IngredientSliderAdapter.IngredientHolder>{
    private Context context;
    private ArrayList<IngredientModel> mSliderItems = new ArrayList<>();

    public IngredientSliderAdapter(Context context, ArrayList<IngredientModel> list) {
        this.mSliderItems = list;
        this.context = context;
    }

    public void renewItems(ArrayList<IngredientModel> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(IngredientModel sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }

    @Override
    public IngredientHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_ingredients, null);
        return new IngredientSliderAdapter.IngredientHolder(inflate);
    }

    @Override
    public void onBindViewHolder(IngredientHolder viewHolder, int position) {
        viewHolder.title.setText(mSliderItems.get(position).getTitle());

        viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context));

        MyAdapter3 myAdapter = new MyAdapter3(context, mSliderItems.get(position).getList());
        viewHolder.recyclerView.setAdapter(myAdapter);
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    static class IngredientHolder extends SliderViewAdapter.ViewHolder {

        View itemView;
        TextView title;
        RecyclerView recyclerView;

        public IngredientHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.ingredient_title);
            recyclerView = itemView.findViewById(R.id.list_ingredients);
            this.itemView = itemView;
        }
    }
}
