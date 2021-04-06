package com.example.tanda;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StepHolder extends RecyclerView.ViewHolder{

    ImageView image;
    TextView content, note, number;

    public StepHolder(@NonNull View itemView) {
        super(itemView);
        this.image = itemView.findViewById(R.id.step_image);
        this.content = itemView.findViewById(R.id.step_content);
        this.note = itemView.findViewById(R.id.step_note);
        this.number = itemView.findViewById(R.id.step_no);
    }
}
