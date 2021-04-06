package com.example.tanda.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.R;
import com.example.tanda.holders.FriendCardHolder;
import com.example.tanda.models.UserModel;

import java.util.ArrayList;
import java.util.Random;
import java.util.zip.Inflater;

public class FriendCardAdapter extends RecyclerView.Adapter<FriendCardHolder> {
    Context context;
    ArrayList<UserModel> users, selected;

    public FriendCardAdapter(Context context, ArrayList<UserModel> users) {
        this.context = context;
        this.users = users;
        selected = new ArrayList<>();
    }

    @NonNull
    @Override
    public FriendCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_friend, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new FriendCardHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final FriendCardHolder holder, int position) {
        final UserModel user = users.get(position);
        Drawable unwrappedDrawable = context.getResources().getDrawable(R.drawable.ic_user);
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        //Random rnd = new Random();
        DrawableCompat.setTint(wrappedDrawable, Color.parseColor("#90cafd"));
        holder.ava.setImageDrawable(wrappedDrawable);

        String fullName = user.getFirstName() + " " + user.getLastName();
        holder.name.setText(fullName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected.contains(user)){
                    selected.remove(user);
                    unHighlightView(holder);
                }else{
                    selected.add(user);
                    highlightView(holder);
                }
            }
        });

        if (selected.contains(user))
            highlightView(holder);
        else
            unHighlightView(holder);
    }

    private void highlightView(FriendCardHolder holder) {
        holder.checked.setVisibility(View.VISIBLE);
    }

    private void unHighlightView(FriendCardHolder holder) {
        holder.checked.setVisibility(View.GONE);
    }


    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
    public ArrayList<UserModel> getSelected() {
        return selected;
    }
}
