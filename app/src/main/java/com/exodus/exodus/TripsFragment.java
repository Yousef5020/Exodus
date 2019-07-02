package com.exodus.exodus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TripsFragment extends android.support.v4.app.Fragment implements trips_Adapter.onRecyclerClickListener{

    public TripsFragment() {
        // Required empty public constructor
    }

    UniversalImageLoader universalImageLoader;

    trips_Adapter.onRecyclerClickListener listener = this;

    private RecyclerView trips_recycler;

    private RecyclerView.Adapter tripsAD;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trips, container, false);

        initImageLoader();

        trips_recycler = v.findViewById(R.id.trips_recycler);

        RecyclerView.LayoutManager tripLM = new LinearLayoutManager(v.getContext(), LinearLayoutManager.VERTICAL, false);

        getTrips();

        trips_recycler.setHasFixedSize(true);
        trips_recycler.setLayoutManager(tripLM);

        return v;
    }

    static List<trips_recycler> trips = new ArrayList<>();

    void getTrips(){

        Call<List<trips_recycler>> call = RetrofitClient.getInstance().getApi().getTrips();

        call.enqueue(new Callback<List<trips_recycler>>() {
            @Override
            public void onResponse(@NonNull Call<List<trips_recycler>> call, @NonNull Response<List<trips_recycler>> response) {
                if (response.isSuccessful()){
                    trips = response.body();

                    tripsAD = new trips_Adapter(trips,universalImageLoader, listener);
                    trips_recycler.setAdapter(tripsAD);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<trips_recycler>> call, @NonNull Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initImageLoader(){
        universalImageLoader = new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }



    public void onClick(int i) {
        Toast.makeText(getContext(),trips.get(i).getTrip(),Toast.LENGTH_LONG).show();
    }
}
