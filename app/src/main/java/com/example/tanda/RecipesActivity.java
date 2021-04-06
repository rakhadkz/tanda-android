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
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tanda.adapters.RecipeCardAdapter;
import com.example.tanda.models.ChefModel;
import com.example.tanda.models.RecipeCardModel;
import com.example.tanda.models.RecipeCategoryModel;
import com.google.android.material.appbar.AppBarLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipesActivity extends AppCompatActivity {
    RecipeCardAdapter adapter;
    RecyclerView recyclerView;
    Toolbar toolbar;
    AppBarLayout appBarLayout;
    TextView title, description, count;
    ImageView header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        final RecipeCategoryModel model = getRecipeCategory();
        toolbar = findViewById(R.id.toolbarBRO);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int flags = getWindow().getDecorView().getSystemUiVisibility();
        flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        getWindow().getDecorView().setSystemUiVisibility(flags);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        title = findViewById(R.id.recipe_category_name);
        description = findViewById(R.id.recipe_category_detail);
        count = findViewById(R.id.recipe_category_count);
        header = findViewById(R.id.recipe_category_header);

        title.setText(model.getName());
        description.setText(model.getDescription());
        count.setText(model.getCount() + " рецептов");
        Picasso.get().load(model.getImage()).into(header);

        adapter = new RecipeCardAdapter(this, getRecipeList());
        recyclerView = findViewById(R.id.recipes_recycler);
        appBarLayout = findViewById(R.id.app_bar);

        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.EXPANDED){
                    setTitle("");
                }else{
                    setTitle(model.getName());
                }
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);

    }

    private RecipeCategoryModel getRecipeCategory(){
        return new RecipeCategoryModel("category1", "Завтрак","https://d9hyo6bif16lx.cloudfront.net/live/img/production/detail/menu/breakfast_diner-style_meat-lovers-breakfast-bowl.jpg", "Завтрак считается самым важным приёмом пищи. Именно поэтому миллионы людей озабочены вопросом, что приготовить на завтрак", 14);
    }

    private ArrayList<RecipeCardModel> getRecipeList(){
        ArrayList<RecipeCardModel> list = new ArrayList<>();
        ChefModel chef1 = new ChefModel("https://outset.co.za/wp-content/uploads/2020/06/happy-male-chef-preparing-beef-steak-with-vegetable-decoration_23-2147863783.jpg", "Куна", "Анарбай", "Нур-Султан");
        ChefModel chef2 = new ChefModel("https://www.escoffier.edu/wp-content/uploads/2015/11/Culinary-Arts-Program.png", "Чингис", "Рахад", "Нур-Султан");
        ChefModel chef3 = new ChefModel("https://anytimechefs.com.au/wp-content/uploads/2018/12/perth-chef-hire.jpg", "Адлет", "Зейнекен", "Алматы");

        list.add(new RecipeCardModel("https://cdn.pixabay.com/photo/2020/07/01/23/23/music-5361245_1280.jpg", "Английский завтрак", "#завтрак #семья", chef1));
        list.add(new RecipeCardModel("https://cdn.pixabay.com/photo/2019/11/06/05/15/bridge-4605202_1280.jpg", "Фисташковый рулет с малиной", "#вкусно #сладость", chef2));
        list.add(new RecipeCardModel("https://cdn.pixabay.com/photo/2020/01/20/20/58/building-4781384_1280.jpg", "Сытный бизнес обед", "#сытно #бизнес", chef3));
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                appBarLayout.setExpanded(false);
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return true;
            }
        });
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        mSearchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        mSearchView.setIconifiedByDefault(true);
        mSearchView.setQueryHint("Искать блюдо");
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