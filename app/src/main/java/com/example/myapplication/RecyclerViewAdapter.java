package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder> {

    private List<Person> data = new ArrayList<>();

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View recyclerRow = layoutInflater.inflate(R.layout.recycler_item, viewGroup, false);
        return new RecycleViewHolder(recyclerRow);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder recycleViewHolder, int position) {
        String name = data.get(position).getName();
        recycleViewHolder.carMakeTextView.setText(name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Person> personList) {
        data.clear();
        data.addAll(personList);

        notifyDataSetChanged();
        Log.d("tag", "Number of items " + data.size());
    }

    public static class RecycleViewHolder extends RecyclerView.ViewHolder {

        final TextView carMakeTextView;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            this.carMakeTextView = itemView.findViewById(R.id.car_make);
        }
    }

}
