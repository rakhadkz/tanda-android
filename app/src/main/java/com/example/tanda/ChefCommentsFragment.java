package com.example.tanda;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.adapters.CommentCardAdapter;
import com.example.tanda.models.ChefModel;

import java.util.ArrayList;

public class ChefCommentsFragment extends Fragment implements ISearch{
    RecyclerView commentsRecycler;
    CommentCardAdapter adapter;

    private static final String ARG_SEARCHTERM = "search_term";
    private String mSearchTerm = null;

    private IFragmentListener mIFragmentListener = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comments, container, false);
        commentsRecycler = view.findViewById(R.id.chef_comments_recycler);
        adapter = new CommentCardAdapter(getContext(), getComments());
        if(getArguments()!=null) {
            mSearchTerm = (String) getArguments().get(ARG_SEARCHTERM);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        commentsRecycler.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(commentsRecycler.getContext(),
                linearLayoutManager.getOrientation());
        commentsRecycler.addItemDecoration(dividerItemDecoration);
        commentsRecycler.setAdapter(adapter);
        return view;
    }

    private ArrayList<CommentModel> getComments(){
        ArrayList<CommentModel> list = new ArrayList<>();
        list.add(new CommentModel("https://outset.co.za/wp-content/uploads/2020/06/happy-male-chef-preparing-beef-steak-with-vegetable-decoration_23-2147863783.jpg", "Куна Анарбай", "У меня всё получилось. Отличный рецепт, всем рекомендую", "5 минут назад", (float) 4.6));
        list.add(new CommentModel("https://www.escoffier.edu/wp-content/uploads/2015/11/Culinary-Arts-Program.png", "Чингис Рахад", "Почему так соли много? Но у меня всё получилось, спасибо", "2 дня назад", (float) 4.3));
        list.add(new CommentModel("https://anytimechefs.com.au/wp-content/uploads/2018/12/perth-chef-hire.jpg", "Адлет Зейнекен", "Очень вкусно вышло, всей семье понравилось. Спасибо 5 из 5", "3 дня назад", (float) 5.0));
        return list;
    }

    @Override
    public void onTextQuery(String text) {

    }

    @Override
    public void onResume() {
        super.onResume();
        if(null!=mSearchTerm) {
            onTextQuery(mSearchTerm);
        }
    }

    public static ChefCommentsFragment newInstance(String searchTerm){
        ChefCommentsFragment fragment = new ChefCommentsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_SEARCHTERM, searchTerm);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIFragmentListener = (IFragmentListener) context;
        mIFragmentListener.addiSearch(ChefCommentsFragment.this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(null!=mIFragmentListener)
            mIFragmentListener.removeISearch(ChefCommentsFragment.this);
    }
}
