package com.exodus.exodus;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class trip_Adapter extends RecyclerView.Adapter<trip_Adapter.ViewHolder> {

    private List<home_trips> list;
    private UniversalImageLoader loader;
    private onRecyclerClickListener listener;

    trip_Adapter(List<home_trips> list, UniversalImageLoader loader, onRecyclerClickListener listener) {
        this.list = list;
        this.loader = loader;
        this.listener = listener;
    }

    @NonNull
    @Override
    public trip_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view,viewGroup,false);
        return new ViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        loader.setImage(list.get(i).getUrl() ,viewHolder.image);
        viewHolder.text.setText(list.get(i).getTrip_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView text;

        onRecyclerClickListener listener;

        private ViewHolder(@NonNull View itemView, onRecyclerClickListener listener) {
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
