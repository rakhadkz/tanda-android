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

import com.example.tanda.adapters.MasterClassCardAdapter;
import com.example.tanda.models.MasterclassModel;

import java.util.ArrayList;

public class ChefMasterClassesFragment extends Fragment implements ISearch, IDataCallback{
    RecyclerView masterclassRecycler;
    MasterClassCardAdapter adapter;

    private static final String ARG_SEARCHTERM = "search_term";
    private String mSearchTerm = null;

    ArrayList<String> strings = null;
    private IFragmentListener mIFragmentListener = null;
    ArrayAdapter<String> arrayAdapter = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chef_masterclasses, container, false);
        masterclassRecycler = view.findViewById(R.id.chef_masterclasses_recycler);
        adapter = new MasterClassCardAdapter(getActivity(), getMasterclassList());
        ((Chef) getActivity()).setiDataCallback(this);
        if(getArguments()!=null) {
            mSearchTerm = (String) getArguments().get(ARG_SEARCHTERM);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        masterclassRecycler.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(masterclassRecycler.getContext(),
                linearLayoutManager.getOrientation());
        masterclassRecycler.addItemDecoration(dividerItemDecoration);
        masterclassRecycler.setAdapter(adapter);
        return view;
    }
    private ArrayList<MasterclassModel> getMasterclassList(){
        ArrayList<MasterclassModel> list = new ArrayList<>();
        list.add(new MasterclassModel("1", "https://cdn.pixabay.com/photo/2020/07/01/23/23/music-5361245_1280.jpg", "Английский завтрак", "16 июня, 22:00", "0+", "1.5 часов"));
        list.add(new MasterclassModel("2", "https://cdn.pixabay.com/photo/2019/11/06/05/15/bridge-4605202_1280.jpg", "Фисташковый рулет с малиной", "20 июня, 19:00", "18+, только женщины", "2 часов"));
        list.add(new MasterclassModel("2", "https://cdn.pixabay.com/photo/2020/01/20/20/58/building-4781384_1280.jpg", "Business Lunch", "21 июня, 18:00", "21+, только мужчины", "5 часов"));
        return list;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (null != mSearchTerm) {
            onTextQuery(mSearchTerm);
        }
    }

    public static ChefMasterClassesFragment newInstance(String searchTerm){
        ChefMasterClassesFragment fragment = new ChefMasterClassesFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_SEARCHTERM, searchTerm);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onTextQuery(String text) {
        adapter.getFilter().filter(text);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIFragmentListener = (IFragmentListener) context;
        mIFragmentListener.addiSearch(ChefMasterClassesFragment.this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (null != mIFragmentListener)
            mIFragmentListener.removeISearch(ChefMasterClassesFragment.this);
    }

    @Override
    public void onFragmentCreated(ArrayList<String> listData) {
        strings = listData;
    }
}
