package com.exodus.exodus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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


public class home extends android.support.v4.app.Fragment implements trip_Adapter.onRecyclerClickListener {

    public home() {

    }

    Fragment fragment = null;
    FragmentTransaction fragmentTransaction;

    UniversalImageLoader universalImageLoader;

    trip_Adapter.onRecyclerClickListener listener = this;

    private RecyclerView votes;
    private RecyclerView trips;
    private RecyclerView mostTrip;

    private RecyclerView.Adapter tripad;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initImageLoader();

        trips = view.findViewById(R.id.most_rec_trips);
        RecyclerView.LayoutManager triplm = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);

        mostTrip = view.findViewById(R.id.most_going_trips);
        RecyclerView.LayoutManager mostTripLM = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);

        getTrips();

        trips.setHasFixedSize(true);
        trips.setLayoutManager(triplm);

        getMostGoingTrips();

        mostTrip.setHasFixedSize(true);
        mostTrip.setLayoutManager(mostTripLM);


        return view;
    }

    static List<home_trips> home_trips = new ArrayList<>();

    void getTrips(){

        Call<List<home_trips>> call = RetrofitClient.getInstance().getApi().getHomeTrips();

        call.enqueue(new Callback<List<home_trips>>() {
            @Override
            public void onResponse(@NonNull Call<List<home_trips>> call, @NonNull Response<List<home_trips>> response) {
                if (response.isSuccessful()){
                    home_trips = response.body();

                    tripad = new trip_Adapter(home_trips,universalImageLoader, listener);
                    trips.setAdapter(tripad);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<home_trips>> call, @NonNull Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    void getMostGoingTrips(){

        Call<List<home_trips>> call = RetrofitClient.getInstance().getApi().getMostGoingTrips();

        call.enqueue(new Callback<List<home_trips>>() {
            @Override
            public void onResponse(@NonNull Call<List<home_trips>> call, @NonNull Response<List<home_trips>> response) {
                if (response.isSuccessful()){
                    home_trips = response.body();

                    tripad = new trip_Adapter(home_trips,universalImageLoader, listener);
                    mostTrip.setAdapter(tripad);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<home_trips>> call, @NonNull Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initImageLoader(){
        universalImageLoader = new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }

    @Override
    public void onClick(int i) {
        if (i<home_trips.size()){
            getActivity().getIntent().putExtra("trip_id",home_trips.get(i).getTrip());

            fragment = new TripFragment();

            switchFragment(fragment);
        }
    }

    private void switchFragment(Fragment fragment) {
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_frame, fragment);
        fragmentTransaction.addToBackStack(null).commit();
    }
}