package com.example.tanda.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanda.Collection;
import com.example.tanda.R;
import com.example.tanda.holders.MemberCardHolder;
import com.example.tanda.models.UserModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MemberCardAdapter extends RecyclerView.Adapter<MemberCardHolder> {
    ArrayList<UserModel> list;
    Context context;
    public MemberCardAdapter(ArrayList<UserModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MemberCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_member, null);
        return new MemberCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MemberCardHolder holder, final int position) {
        final UserModel model = list.get(position);
        Picasso.get().load(model.getAva()).networkPolicy(NetworkPolicy.OFFLINE).into(holder.ava, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                holder.ava.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
                holder.avaLetter.setVisibility(View.VISIBLE);
                holder.avaLetter.setText(String.valueOf(model.getFirstName().charAt(0)) + model.getLastName().charAt(0));
            }
        });
        final String fullName = model.getFirstName() + " " + model.getLastName();
        holder.fullName.setText(fullName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(fullName, position);
            }
        });
    }

    private void showDialog(String fullName, final int position){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Вы уверены?");
        alertDialog.setMessage("Удаление " + fullName);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                removeMember(position);
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Отмена",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(context.getResources().getColor(R.color.design_default_color_error));
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.GRAY);
    }

    private void removeMember(int position){
        UserModel user = list.get(position);
        list.remove(user);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
