package com.example.tanda;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ChefViewPager extends FragmentPagerAdapter {
    private String mSearchTerm;
    //integer to count number of tabs
    public ChefViewPager(@NonNull FragmentManager fm, String searchTerm) {
        super(fm);
        this.mSearchTerm = searchTerm;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0){
            fragment = new ChefRecipesFragment();
        }else if (position == 1){
            fragment = new ChefMasterClassesFragment();
        }
        else if (position == 2){
            fragment = new ChefCommentsFragment();
        }
        assert fragment != null;
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    public void setTextQueryChanged(String newText) {
        mSearchTerm = newText;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Рецепты";
        }
        else if (position == 1)
        {
            title = "Уроки";
        }
        else if (position == 2)
        {
            title = "Отзывы";
        }
        return title;
    }
    public static SearchView.OnQueryTextListener onQueryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {

            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };
}
