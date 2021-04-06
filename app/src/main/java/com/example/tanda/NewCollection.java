package com.example.tanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tanda.adapters.CoverCardAdapter;
import com.example.tanda.adapters.FriendCardAdapter;
import com.example.tanda.models.ShopModel;
import com.example.tanda.models.UserModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class NewCollection extends AppCompatActivity {
    RecyclerView friendsRecycler, coversRecycler;
    FriendCardAdapter friendCardAdapter;
    CoverCardAdapter coverCardAdapter;
    Button btn;
    RelativeLayout shop_layout;
    ImageView shopImage;
    TextView shopName, shopAddress;
    Toolbar toolbar;
    public static ShopModel CURRENT_SHOP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_collection);
        CURRENT_SHOP = null;
        toolbar = findViewById(R.id.new_collection_toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(this.getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        friendCardAdapter = new FriendCardAdapter(this, getFriends());
        friendsRecycler = findViewById(R.id.friends_recycler);
        friendsRecycler.setLayoutManager(layoutManager);
        friendsRecycler.setAdapter(friendCardAdapter);

        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        coverCardAdapter = new CoverCardAdapter(this);
        coversRecycler = findViewById(R.id.cover_recycler);
        coversRecycler.setLayoutManager(layoutManager2);
        coversRecycler.setAdapter(coverCardAdapter);
        btn = findViewById(R.id.btn_select_shop);
        shop_layout = findViewById(R.id.in_collection_shop);
        shopImage = findViewById(R.id.in_collection_card_shop_image);
        shopName = findViewById(R.id.in_collection_card_shop_name);
        shopAddress = findViewById(R.id.in_collection_card_shop_address);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NewCollection.this, Shops.class);
                startActivityForResult(i, 13);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 13) {
            if (resultCode == Activity.RESULT_OK) {
                shop_layout.setVisibility(View.VISIBLE);
                Picasso.get().load(CURRENT_SHOP.getImage()).into(shopImage);
                shopName.setText(CURRENT_SHOP.getName());
                shopAddress.setText(CURRENT_SHOP.getAddress().getAddress());
                btn.setText("Выбрать другой магазин");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.new_collection_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.nav_create_collection) {
            Toast.makeText(this, "Created!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<UserModel> getFriends(){
        ArrayList<UserModel> users = new ArrayList<>();
        users.add(new UserModel("Shyngys", "Rakhad"));
        users.add(new UserModel("Jobs", "Steve"));
        users.add(new UserModel("Adlet", "Zeineken"));
        users.add(new UserModel("Cristiano", "Ronaldo"));
        users.add(new UserModel("Lionel", "Messi"));
        users.add(new UserModel("Lionel", "Messi"));
        return users;
    }
}