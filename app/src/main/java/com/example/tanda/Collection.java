package com.example.tanda;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.tanda.adapters.MemberCardAdapter;
import com.example.tanda.models.AddressModel;
import com.example.tanda.models.CollectionModel;
import com.example.tanda.models.ShopModel;
import com.example.tanda.models.UserModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class Collection extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView membersRecycler;
    MemberCardAdapter memberCardAdapter;
    CollectionModel collectionModel;
    ImageView cover, shopImage;
    TextView shopName, shopAddress;
    CollapsingToolbarLayout toolBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection2);

        collectionModel = CollectionProducts.collectionModel;

        toolbar = findViewById(R.id.toolbar);
        cover = findViewById(R.id.collection_image);
        shopName = findViewById(R.id.in_collection_shop_name);
        shopAddress = findViewById(R.id.in_collection_shop_address);
        shopImage = findViewById(R.id.in_collection_shop_image);
        setSupportActionBar(toolbar);
        toolBarLayout = findViewById(R.id.toolbar_layout);

        toolBarLayout.setTitle(collectionModel.getName());
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                cover.setImageDrawable(getResources().getDrawable(CollectionCover.getCover(collectionModel)));
            }
        });

        Picasso.get().load(collectionModel.getShop().getImage()).networkPolicy(NetworkPolicy.OFFLINE).into(shopImage);

        shopName.setText(collectionModel.getShop().getName());
        shopAddress.setText(collectionModel.getShop().getAddress().getAddress());


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCollectionName();
            }
        });

        membersRecycler = findViewById(R.id.collection_members_recycler);
        memberCardAdapter = new MemberCardAdapter(getMembers(), this);
        membersRecycler.setLayoutManager(new LinearLayoutManager(this));
        membersRecycler.setAdapter(memberCardAdapter);
    }

    private void updateCollectionName(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Collection.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.alert_dialog_edit_text,null);
        builder.setCancelable(true);
        builder.setView(dialogView);

        final EditText editName = dialogView.findViewById(R.id.collection_new_name);
        Button btnUpdate = dialogView.findViewById(R.id.btn_update_collection_name);
        Button btnCancel = dialogView.findViewById(R.id.btn_update_collection_name_cancel);
        final AlertDialog dialog = builder.create();
        editName.setText(collectionModel.getName());
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                collectionModel.setName(editName.getText().toString());
                CollectionProducts.collectionModel.setName(editName.getText().toString());
                updateCollection();
                Toast.makeText(Collection.this, "Updated!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                setResult(Activity.RESULT_OK);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void updateCollection(){
        toolBarLayout.setTitle(collectionModel.getName());
        cover.setImageDrawable(getResources().getDrawable(CollectionCover.getCover(collectionModel)));
    }

    private CollectionModel getCollection(){
        ShopModel shopModel = new ShopModel("Magnum", "https://wikicity.kz/fotos_ms/Company_190_AnZnmnXaCDou3MdqV25hdd.png");
        shopModel.setAddress(new AddressModel("Prospect Nazarbaeva"));
        return new CollectionModel("Продукты питания", "second", 3, shopModel);
    }

    private ArrayList<UserModel> getMembers(){
        ArrayList<UserModel> list = new ArrayList<>();
        list.add(new UserModel("Shyngys", "Rakhad"));
        list.add(new UserModel("Adlet", "Zeineken"));
        list.add(new UserModel("Jobs", "Steve"));
        list.add(new UserModel("Cristiano", "Ronaldo"));
        return list;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_collection, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.nav_edit_collection) {
            updateCollectionName();
            return true;
        }
        else if (item.getItemId() == R.id.nav_share_collection){
            Toast.makeText(this, "Share!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}