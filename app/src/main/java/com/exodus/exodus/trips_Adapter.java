package com.exodus.exodus;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class trips_Adapter extends RecyclerView.Adapter<trips_Adapter.ViewHolder> {

    private List<trips_recycler> list;
    private UniversalImageLoader loader;
    private onRecyclerClickListener listener;

    trips_Adapter(List<trips_recycler> list, UniversalImageLoader loader, onRecyclerClickListener listener) {
        this.list = list;
        this.loader = loader;
        this.listener = listener;
    }

    @NonNull
    @Override
    public trips_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trips_recycler,viewGroup,false);
        return new ViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        loader.setImage(list.get(i).getUrl() ,viewHolder.trip_image);
        viewHolder.trip_name.setText(list.get(i).getName());
        viewHolder.agency_name.setText(list.get(i).getAgency_name());
        viewHolder.going.setText(list.get(i).getGoing());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView trip_image;
        TextView trip_name;
        TextView agency_name;
        TextView going;

        onRecyclerClickListener listener;

        private ViewHolder(@NonNull View itemView, onRecyclerClickListener listener) {
            super(itemView);
            trip_image = itemView.findViewById(R.id.trips_photo);
            trip_name = itemView.findViewById(R.id.trips_name);
            agency_name = itemView.findViewById(R.id.trips_agency_name);
            going = itemView.findViewById(R.id.trips_going);

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
