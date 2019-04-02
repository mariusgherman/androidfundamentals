package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder> {


    private final List<String> data;

    public RecyclerViewAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View recyclerRow = layoutInflater.inflate(R.layout.recycler_item, viewGroup, false);
        return new RecycleViewHolder(recyclerRow);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder recycleViewHolder, int position) {
        String carmake = data.get(position);
        recycleViewHolder.carMakeTextView.setText(carmake);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class RecycleViewHolder extends RecyclerView.ViewHolder {

        final TextView carMakeTextView;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            this.carMakeTextView = itemView.findViewById(R.id.car_make);
        }
    }

}
