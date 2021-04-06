package com.example.tanda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tanda.adapters.CollectionProductCardAdapter;
import com.example.tanda.adapters.FCProductAdapter;
import com.example.tanda.adapters.QuantityCardAdapter;
import com.example.tanda.models.CollectionModel;
import com.example.tanda.models.CollectionProductModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class CollectionProducts extends AppCompatActivity {
    RecyclerView collection_products_recycler;
    CollectionProductCardAdapter collectionProductCardAdapter;
    Button btnToBasket, btnSaveCollection, btnAcceptCollection;
    RelativeLayout layoutBtnBasket;
    Toolbar toolbar;
    TextView toolbarTitle, shopName, shopTime;
    ImageView shopImage;
    TextView total;
    public static CollectionModel collectionModel;
    public static int mode = 0;
    ArrayList<CollectionProductModel> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_products);
        getMode();
        toolBarSetting();
        viewInitialization();
        setModeParams(); //mode 1 -> by link, 2 -> request, def -> own

        //collectionModel = getCollection();

        getShopInfo();
        updateTitle();
        String totalString = collectionProductCardAdapter.getTotal() + " " + getResources().getString(R.string.tenge_symbol);
        total.setText(totalString);
        toolbarTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mode == 1 || mode == 2)
                    return;
                startActivityForResult(new Intent(new Intent(CollectionProducts.this, Collection.class)), 13);
            }
        });

        btnSaveCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToCollection();
            }
        });

        btnAcceptCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acceptCollection();
            }
        });

        btnToBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*for (CollectionProductModel model: collectionProductCardAdapter.getSelected()){
                    Toast.makeText(CollectionProducts.this, model.getName(), Toast.LENGTH_SHORT).show();
                }*/
                Toast.makeText(CollectionProducts.this, String.valueOf(collectionProductCardAdapter.getTotal()), Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void toolBarSetting(){
        setTitle("");
        toolbar = findViewById(R.id.collection_products_toolbar);
        toolbarTitle = findViewById(R.id.collection_products_toolbar_title);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    private void viewInitialization(){
        list = getProducts();
        collectionProductCardAdapter = new CollectionProductCardAdapter(this, list);
        collection_products_recycler = findViewById(R.id.collection_products_recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        collection_products_recycler.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(collection_products_recycler.getContext(),
                linearLayoutManager.getOrientation());
        collection_products_recycler.addItemDecoration(dividerItemDecoration);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(collection_products_recycler);
        collection_products_recycler.setAdapter(collectionProductCardAdapter);
        btnToBasket = findViewById(R.id.btn_collection_products_to_basket);
        btnSaveCollection = findViewById(R.id.btn_collection_save);
        btnAcceptCollection = findViewById(R.id.btn_collection_accept);
        layoutBtnBasket = findViewById(R.id.layout_btn_collection);
        shopName = findViewById(R.id.collection_products_shop_name);
        shopImage = findViewById(R.id.collection_products_shop_image);
        shopTime = findViewById(R.id.collection_products_shop_time);
        total = findViewById(R.id.collection_products_total);
    }

    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            final CollectionProductModel product = list.get(viewHolder.getAdapterPosition());
            AlertDialog alertDialog = new AlertDialog.Builder(CollectionProducts.this).create();
            alertDialog.setTitle("Вы уверены?");
            alertDialog.setMessage("Удаление " + product.getName());
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Да", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    list.remove(product);
                    collectionProductCardAdapter.notifyDataSetChanged();
                }
            });
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Отмена",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            collectionProductCardAdapter.notifyDataSetChanged();
                        }
                    });
            alertDialog.show();
            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.design_default_color_error));
            alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.GRAY);
        }
    };

    private void getMode(){
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b != null)
            mode = (int) b.get("mode");
        else
            mode = 1;
    }

    private void setModeParams(){
        switch (mode){
            case 1:
                btnSaveCollection.setVisibility(View.VISIBLE);
                layoutBtnBasket.setVisibility(View.GONE);
                btnAcceptCollection.setVisibility(View.GONE);
                break;
            case 2:
                btnSaveCollection.setVisibility(View.GONE);
                layoutBtnBasket.setVisibility(View.GONE);
                btnAcceptCollection.setVisibility(View.VISIBLE);
                break;
            default:
                btnSaveCollection.setVisibility(View.GONE);
                layoutBtnBasket.setVisibility(View.VISIBLE);
                btnAcceptCollection.setVisibility(View.GONE);
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 13) {
            if (resultCode == Activity.RESULT_OK) {
                updateTitle();
            }
        }
    }

    private void acceptCollection(){
        CollectionModel model = new CollectionModel();
        Toast.makeText(this, "Collection accepted!", Toast.LENGTH_SHORT).show();
    }

    private void saveToCollection(){
        ArrayList<CollectionProductModel> list = collectionProductCardAdapter.getSelected();
        if (list.isEmpty())
            Toast.makeText(this, "Please, select products", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Collection saved!", Toast.LENGTH_SHORT).show();
    }

    private void updateTitle(){
        toolbarTitle.setText(collectionModel.getName());
    }

    private void getShopInfo(){
        shopName.setText(collectionModel.getShop().getName());
        shopTime.setText(collectionModel.getShop().getAddress().getAddress());
        Picasso.get().load(collectionModel.getShop().getImage()).into(shopImage);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (mode == 1 || mode == 2)
            return false;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.nav_add) {
            Toast.makeText(this, "Created!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private ArrayList<CollectionProductModel> getProducts(){
        ArrayList<CollectionProductModel> list = new ArrayList<>();
        list.add(new CollectionProductModel("Яблоко 1кг", 1, 2, 200));
        list.add(new CollectionProductModel("Coca-cola 1л", 1, 1, 150));
        list.add(new CollectionProductModel("Рис 1кг", 2, 0, 195));
        list.add(new CollectionProductModel("Орбит Арбуз", 4, 3, 150));
        return list;
    }
}