package com.example.tanda;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.adapters.RecipeCardAdapter;
import com.example.tanda.models.ChefModel;
import com.example.tanda.models.RecipeCardModel;

import java.util.ArrayList;

public class ChefRecipesFragment extends Fragment implements ISearch{
    RecyclerView recipesRecycler;
    RecipeCardAdapter adapter;

    private static final String ARG_SEARCHTERM = "search_term";
    private String mSearchTerm = null;

    ArrayList<String> strings = null;
    private IFragmentListener mIFragmentListener = null;
    ArrayAdapter<String> arrayAdapter = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chef_recipes, container, false);
        recipesRecycler = view.findViewById(R.id.chef_recipes_recycler);
        adapter = new RecipeCardAdapter(getActivity(), getRecipeList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        Chef chef = (Chef) getActivity();
        chef.getDataFromFragment_one(strings);
        if (getArguments() != null) {
            mSearchTerm = (String) getArguments().get(ARG_SEARCHTERM);
        }

        recipesRecycler.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recipesRecycler.getContext(),
                linearLayoutManager.getOrientation());
        recipesRecycler.addItemDecoration(dividerItemDecoration);
        recipesRecycler.setAdapter(adapter);
        return view;
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
    public void onResume() {
        super.onResume();
        if (null != mSearchTerm) {
            onTextQuery(mSearchTerm);
        }
    }

    @Override
    public void onTextQuery(String text) {
        adapter.getFilter().filter(text);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (null != mIFragmentListener)
            mIFragmentListener.removeISearch(ChefRecipesFragment.this);
    }

    public static ChefRecipesFragment newInstance(String searchTerm) {
        ChefRecipesFragment fragment = new ChefRecipesFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_SEARCHTERM, searchTerm);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIFragmentListener = (IFragmentListener) context;
        mIFragmentListener.addiSearch(ChefRecipesFragment.this);
    }
}
