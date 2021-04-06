package com.example.tanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.example.tanda.adapters.RecipeCategoryCardAdapter;
import com.example.tanda.adapters.ChefCardAdapter;
import com.example.tanda.adapters.RecipeCardAdapter;
import com.example.tanda.implementations.RecyclerItemClickListener;
import com.example.tanda.models.CategoryCardModel;
import com.example.tanda.models.ChefCardModel;
import com.example.tanda.models.ChefModel;
import com.example.tanda.models.RecipeCardModel;
import com.example.tanda.models.RecipeCategoryModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, chefRecycler, recipeRecycler;
    RecipeCategoryCardAdapter recipeCategoryCardAdapter;
    ChefCardAdapter chefCardAdapter;
    RecipeCardAdapter recipeCardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.category_recycler);
        categoryRecycler.setLayoutManager(layoutManager);

        recipeCategoryCardAdapter = new RecipeCategoryCardAdapter(this, getCategoryList());
        categoryRecycler.setAdapter(recipeCategoryCardAdapter);

        chefRecycler = findViewById(R.id.chef_recycler);
        chefRecycler.setLayoutManager(new LinearLayoutManager(this));

        chefCardAdapter = new ChefCardAdapter(this, getChefList());
        chefRecycler.setAdapter(chefCardAdapter);

        recipeRecycler = findViewById(R.id.recipe_recycler);
        recipeRecycler.setLayoutManager(new LinearLayoutManager(this));

        recipeCardAdapter = new RecipeCardAdapter(this, getRecipeList());
        recipeRecycler.setAdapter(recipeCardAdapter);

        recipeRecycler.addOnItemTouchListener(new RecyclerItemClickListener(this, recipeRecycler, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);

        return true;
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

    private ArrayList<ChefModel> getChefList(){
        ArrayList<ChefModel> list = new ArrayList<>();
        list.add(new ChefModel("Куна", "Анарбай", "https://outset.co.za/wp-content/uploads/2020/06/happy-male-chef-preparing-beef-steak-with-vegetable-decoration_23-2147863783.jpg",
                2000, 4.5));
        list.add(new ChefModel("Чингис","Рахад", "https://www.escoffier.edu/wp-content/uploads/2015/11/Culinary-Arts-Program.png",
                1500, 5.0));
        list.add(new ChefModel("Адлет","Зейнекен", "https://anytimechefs.com.au/wp-content/uploads/2018/12/perth-chef-hire.jpg",
                9000, 4.0));
        return list;
    }

    private ArrayList<RecipeCategoryModel> getCategoryList() {
        ArrayList<RecipeCategoryModel> list = new ArrayList<>();
        list.add(new RecipeCategoryModel("https://cdn.pixabay.com/photo/2020/07/01/23/23/music-5361245_1280.jpg", "Завтрак", 14));
        list.add(new RecipeCategoryModel("https://cdn.pixabay.com/photo/2019/11/06/05/15/bridge-4605202_1280.jpg", "Десерт", 10));
        list.add(new RecipeCategoryModel("https://cdn.pixabay.com/photo/2020/01/20/20/58/building-4781384_1280.jpg", "Обед", 9));
        return list;
    }
}
