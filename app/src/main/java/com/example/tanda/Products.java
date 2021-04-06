package com.example.tanda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.tanda.adapters.CollectionProductCardAdapter;
import com.example.tanda.adapters.FCProductAdapter;
import com.example.tanda.adapters.QuantityCardAdapter;
import com.example.tanda.models.CollectionProductModel;
import com.example.tanda.models.FCProductModel;
import com.example.tanda.models.QuantityModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.Objects;

public class Products extends AppCompatActivity {
    RecyclerView productsRecycler, productsInCollectionRecycler;
    FCProductAdapter fcProductAdapter;
    CollectionProductCardAdapter collectionProductCardAdapter;
    Toolbar toolbar;
    BottomSheetBehavior sheetBehavior;
    LinearLayout layoutBottomSheet;
    ToggleButton toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        toolbar = findViewById(R.id.products_toolbar);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        layoutBottomSheet = findViewById(R.id.bottom_sheet);
        toggle = findViewById(R.id.bottom_sheet_toggle);
        setSupportActionBar(toolbar);

        fcProductAdapter = new FCProductAdapter(this, getProducts());
        productsRecycler = findViewById(R.id.fc_products_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        productsRecycler.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(productsRecycler.getContext(),
                linearLayoutManager.getOrientation());
        productsRecycler.addItemDecoration(dividerItemDecoration);
        productsRecycler.setAdapter(fcProductAdapter);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        sheetBehavior.setHideable(false);

        collectionProductCardAdapter = new CollectionProductCardAdapter(this, getProductsInCollection());

        productsInCollectionRecycler = findViewById(R.id.product_ic_recycler);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        productsInCollectionRecycler.setLayoutManager(linearLayoutManager2);
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(productsInCollectionRecycler.getContext(),
                linearLayoutManager2.getOrientation());
        productsInCollectionRecycler.addItemDecoration(dividerItemDecoration1);
        productsInCollectionRecycler.setAdapter(collectionProductCardAdapter);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(Products.this, String.valueOf(CollectionProductModel.selectedProductsHash.size()), Toast.LENGTH_SHORT).show();
                if (b){
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    sheetBehavior.setDraggable(false);
                }else{
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    sheetBehavior.setDraggable(true);
                }
            }
        });

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED){
                    FCProductAdapter.isClickable = false;
                    toggle.setChecked(true);
                }else{
                    FCProductAdapter.isClickable = true;
                    toggle.setChecked(false);
                }
                fcProductAdapter.notifyDataSetChanged();
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    private ArrayList<CollectionProductModel> getProductsInCollection(){
        ArrayList<CollectionProductModel> productsInCollection = new ArrayList<>();
        for (String key: CollectionProductModel.selectedProductsHash.keySet()){
            productsInCollection.add(CollectionProductModel.selectedProductsHash.get(key));
        }
        return productsInCollection;
    }

    @Override
    public void onBackPressed() {
        if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED){
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            return;
        }
        super.onBackPressed();
    }

    private ArrayList<FCProductModel> getProducts(){

        /*QuantityModel.hashPrice.put("id3", 3);
        QuantityModel.hashPrice.put("id1", 1);
        QuantityModel.hashPrice.put("id5", 5);
        QuantityCardAdapter.hashMap = QuantityModel.hashPrice;*/

        ArrayList<FCProductModel> list = new ArrayList<>();
        ArrayList<QuantityModel> quantityModels1 = new ArrayList<>();
        quantityModels1.add(new QuantityModel("id1", 320, "килограмм", 3));
        quantityModels1.add(new QuantityModel("id2", 1200, "коробка"));
        quantityModels1.add(new QuantityModel("id3", 50, "штука", 4));
        list.add(new FCProductModel("1", "https://www.timeboil.ru/img/site/vegetables/potatoes.png", "Картошка", quantityModels1));

        ArrayList<QuantityModel> quantityModels2 = new ArrayList<>();
        quantityModels2.add(new QuantityModel("id4", 240, "литр"));
        quantityModels2.add(new QuantityModel("id5", 2400, "коробка"));
        list.add(new FCProductModel("2", "https://images.kz.prom.st/85656133_koka-kola-1-l.jpg", "Coca-Cola 1л", quantityModels2));

        ArrayList<QuantityModel> quantityModels3 = new ArrayList<>();
        quantityModels3.add(new QuantityModel("id6", 15000, "Штука"));
        list.add(new FCProductModel("3", "https://st.depositphotos.com/1024764/1769/i/450/depositphotos_17697177-stock-photo-snickers-candy-chocolat-bar.jpg", "Сникерс 50гр", quantityModels3));
        return list;
    }
}