package com.example.isports.activity;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {
    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
       return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
       class ViewPagerViewHolder extends RecyclerView.ViewHolder{

           public ViewPagerViewHolder(@NonNull View itemView) {
               super(itemView);
           }
       }
}
