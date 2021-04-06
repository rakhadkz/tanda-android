package com.example.tanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tanda.adapters.RecipeCategoryCardAdapter;
import com.example.tanda.models.RecipeCategoryModel;

import java.util.ArrayList;

public class RecipeCategory extends AppCompatActivity {
    RecyclerView recipeCategoryRecycler;
    RecipeCategoryCardAdapter adapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_category);
        toolbar = findViewById(R.id.recipe_category_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        adapter = new RecipeCategoryCardAdapter(this, getCategoryList());
        recipeCategoryRecycler = findViewById(R.id.recipe_category_recycler);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recipeCategoryRecycler.setLayoutManager(gridLayoutManager);
        recipeCategoryRecycler.addItemDecoration(new GridSpacingItemDecoration(2, 30, true));
        recipeCategoryRecycler.setAdapter(adapter);

    }
    private ArrayList<RecipeCategoryModel> getCategoryList(){
        ArrayList<RecipeCategoryModel> list = new ArrayList<>();
        list.add(new RecipeCategoryModel("Завтрак", "https://cdn.pixabay.com/photo/2020/07/01/23/23/music-5361245_1280.jpg", 14));
        list.add(new RecipeCategoryModel("Десерт", "https://cdn.pixabay.com/photo/2019/11/06/05/15/bridge-4605202_1280.jpg", 10));
        list.add(new RecipeCategoryModel("Обед", "https://cdn.pixabay.com/photo/2020/01/20/20/58/building-4781384_1280.jpg",  9));
        return list;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
        mSearchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        mSearchView.setQueryHint("Search");
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}