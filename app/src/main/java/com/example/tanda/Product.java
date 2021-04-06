package com.example.tanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tanda.adapters.FCProductAdapter;
import com.example.tanda.adapters.KeyValue2Adapter;
import com.example.tanda.models.FCProductModel;
import com.example.tanda.models.KeyValueModel;
import com.example.tanda.models.ProductModel;
import com.example.tanda.models.QuantityModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

public class Product extends AppCompatActivity {
    Toolbar toolbar;
    LinearLayout titleLayout;
    RecyclerView detailRecycler, shopsRecycler;
    KeyValue2Adapter adapter;
    ProductModel model;
    TextView title, price;
    RelativeLayout stock_layout;
    FCProductAdapter fcProductAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        toolbar = findViewById(R.id.product_toolbar);
        titleLayout = findViewById(R.id.layout_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setTitle("Продукт");
        model = getProduct();
        detailRecycler = findViewById(R.id.product_detail_recycler);
        shopsRecycler = findViewById(R.id.product_shops_recycler);
        fcProductAdapter = new FCProductAdapter(this, getProducts());
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        shopsRecycler.setLayoutManager(linearLayoutManager1);
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(shopsRecycler.getContext(),
                linearLayoutManager1.getOrientation());
        shopsRecycler.addItemDecoration(dividerItemDecoration1);
        shopsRecycler.setAdapter(fcProductAdapter);
        title = findViewById(R.id.product_name);
        price = findViewById(R.id.product_price);
        stock_layout = findViewById(R.id.stock_layout);
        if (model.isStock())
            stock_layout.setVisibility(View.VISIBLE);
        adapter = new KeyValue2Adapter(this, getDetail());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        detailRecycler.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(detailRecycler.getContext(),
                linearLayoutManager.getOrientation());
        detailRecycler.addItemDecoration(dividerItemDecoration);
        detailRecycler.setAdapter(adapter);
    }
    private ProductModel getProduct(){
        return new ProductModel(
                "product1",
                "Говядина Семейный бюджет тушеная богатырская по-старорусски 325 г",
                320,
                false,
                "Мясное",
                "Говядина Семейный бюджет тушеная богатырская по-старорусски",
                "Очень вкусно короче",
                "Детали данной продукции");
    }

    private ArrayList<KeyValueModel> getDetail(){
        ArrayList<KeyValueModel> list = new ArrayList<>();
        list.add(new KeyValueModel("Категория", model.getCategory()));
        list.add(new KeyValueModel("Короткое название", model.getShortName()));
        list.add(new KeyValueModel("Описание", model.getDescription()));
        list.add(new KeyValueModel("Еще детали", model.getDetail()));
        return list;
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