package com.example.tanda;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.adapters.CollectionCardAdapter;
import com.example.tanda.adapters.RecipeCardAdapter;
import com.example.tanda.models.AddressModel;
import com.example.tanda.models.ChefModel;
import com.example.tanda.models.CollectionModel;
import com.example.tanda.models.RecipeCardModel;
import com.example.tanda.models.ShopModel;

import java.util.ArrayList;
import java.util.Objects;

public class CollectionFragment extends Fragment {
    RecyclerView collectionRecycler, savedRecycler;
    CollectionCardAdapter collectionCardAdapter;
    RecipeCardAdapter recipeCardAdapter;
    Context context = getActivity();
    Button createCollection;
    Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_collection, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.fragment_collection_toolbar);
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        collectionCardAdapter = new CollectionCardAdapter(getActivity(), getCollectionList());
        collectionRecycler = view.findViewById(R.id.collections_recycler);
        collectionRecycler.setLayoutManager(new LinearLayoutManager(context));
        collectionRecycler.setAdapter(collectionCardAdapter);

        recipeCardAdapter = new RecipeCardAdapter(context, getRecipeList());
        savedRecycler = view.findViewById(R.id.saved_recycler);
        savedRecycler.setLayoutManager(new LinearLayoutManager(context));
        savedRecycler.setAdapter(recipeCardAdapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.add_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_add) {
            Objects.requireNonNull(getActivity()).startActivity(new Intent(getActivity(), Products.class));
            getActivity().overridePendingTransition(R.anim.slide_up_info,R.anim.no_change);

        }

        return super.onOptionsItemSelected(item);
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

    private ArrayList<CollectionModel> getCollectionList(){
        ArrayList<CollectionModel> collectionList = new ArrayList<>();
        ShopModel firstShop = new ShopModel("magnum-id","Magnum", "https://pbs.twimg.com/profile_images/970973085531885568/Y4ZbcmWk.jpg", new AddressModel("Prospect Qabanbay 80"));
        ShopModel secondShop = new ShopModel("small-id", "Small", "https://wikicity.kz/fotos_ms/Company_29717_Q9GlPfGGdsbYea2i1KBKLe.png", new AddressModel("Prospect Nazarbaeva 120"));

        collectionList.add(new CollectionModel("Продукты на неделю", "breakfast", 5, firstShop));
        collectionList.add(new CollectionModel("Для гостей", "raspberry and vegetables", 3, secondShop));
        collectionList.add(new CollectionModel("Фрукты и овощи", "vegetables", 12, firstShop));
        return collectionList;

    }
}
