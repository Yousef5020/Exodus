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
    private onRecyclerClickListener listener;

    vote_Adapter(ArrayList<trip_recycler> list, UniversalImageLoader loader, onRecyclerClickListener listener) {
        this.list = list;
        this.loader = loader;
        this.listener = listener;
    }

    @NonNull
    @Override
    public vote_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view,viewGroup,false);
        return new ViewHolder(v, listener);
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

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView text;

        onRecyclerClickListener listener;

        public ViewHolder(@NonNull View itemView, onRecyclerClickListener listener) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
            this.listener = listener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(getAdapterPosition());
        }
    }

    public interface onRecyclerClickListener {
        void onClick(int i);
    }
}
