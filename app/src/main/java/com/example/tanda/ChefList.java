package com.example.tanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tanda.adapters.ChefCardAdapter;
import com.example.tanda.models.ChefCardModel;
import com.example.tanda.models.ChefModel;

import java.util.ArrayList;

public class ChefList extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView chefRecycler;
    ChefCardAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_list);
        toolbar = findViewById(R.id.chef_list_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        chefRecycler = findViewById(R.id.chefs_recycler);
        adapter = new ChefCardAdapter(this, getChefList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        chefRecycler.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(chefRecycler.getContext(),
                linearLayoutManager.getOrientation());
        chefRecycler.addItemDecoration(dividerItemDecoration);
        chefRecycler.setAdapter(adapter);

    }
    private ArrayList<ChefModel> getChefList(){
        ArrayList<ChefModel> list = new ArrayList<>();
        list.add(new ChefModel("Куна", "Анарбай", "https://outset.co.za/wp-content/uploads/2020/06/happy-male-chef-preparing-beef-steak-with-vegetable-decoration_23-2147863783.jpg",
                2000, 4.5));
        list.add(new ChefModel("Чингис", "Рахад", "https://www.escoffier.edu/wp-content/uploads/2015/11/Culinary-Arts-Program.png",
                1500, 5.0));
        list.add(new ChefModel("Адлет", "Зейнекен", "https://anytimechefs.com.au/wp-content/uploads/2018/12/perth-chef-hire.jpg",
                9000, 4.0));
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