package com.example.tanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tanda.adapters.ShopCardAdapter;
import com.example.tanda.implementations.RecyclerItemClickListener;
import com.example.tanda.models.AddressModel;
import com.example.tanda.models.ShopModel;

import java.util.ArrayList;

public class Shops extends AppCompatActivity {
    RecyclerView shopRecycler;
    ShopCardAdapter shopCardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);
        shopCardAdapter = new ShopCardAdapter(this, getShopList());
        shopRecycler = findViewById(R.id.shops_recycler);
        shopRecycler.setLayoutManager(new LinearLayoutManager(this));
        shopRecycler.setAdapter(shopCardAdapter);

        shopRecycler.addOnItemTouchListener(new RecyclerItemClickListener(this, shopRecycler, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                NewCollection.CURRENT_SHOP = shopCardAdapter.getShop(position);
                setResult(Activity.RESULT_OK);
                finish();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

    }
    private ArrayList<ShopModel> getShopList(){
        ArrayList<ShopModel> list = new ArrayList<>();
        AddressModel address1 = new AddressModel("Prospect Nazarbaeva 31");
        AddressModel address2 = new AddressModel("Ulitsya Gagarina 82");
        AddressModel address3 = new AddressModel("Ulitsya Kamzina 169");
        list.add(new ShopModel("magnum-id","Magnum", "https://wikicity.kz/fotos_ms/Company_190_AnZnmnXaCDou3MdqV25hdd.png", address1));
        list.add(new ShopModel("small-id","Small", "https://wikicity.kz/fotos_ms/Company_5925_ELytcUuvoaaLXnbRpCDtVNum.png", address2));
        list.add(new ShopModel("ramstore-id","Ramstore", "https://lh3.googleusercontent.com/QdvOsdzPYb6mpr6jOiVWCEW1ElKM8bvLZMd65rdgG_9gt6joJYT6z1MtQE62k_i9Aw", address3));
        return list;
    }
}