package com.exodus.exodus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class vote_Adapter extends RecyclerView.Adapter<vote_Adapter.ViewHolder> {

    private ArrayList<trip_recycler> list;
    private UniversalImageLoader loader;
    vote_Adapter(ArrayList<trip_recycler> list, UniversalImageLoader loader) {
        this.list = list;
        this.loader = loader;
    }

    @NonNull
    @Override
    public vote_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        loader.setImage(list.get(i).getImgURL() ,viewHolder.image);
        viewHolder.text.setText(list.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
        }
    }
}
