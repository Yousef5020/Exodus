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


public class home extends android.support.v4.app.Fragment implements vote_Adapter.onRecyclerClickListener {

    public home() {

    }
    ArrayList<trip_recycler> arrayList;

    UniversalImageLoader universalImageLoader;

    private RecyclerView votes;
    private RecyclerView trips;
    private RecyclerView agencies;

    private RecyclerView.LayoutManager triplm;
    private RecyclerView.LayoutManager agencylm;

    private RecyclerView.Adapter tripad;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initImageLoader();

        trips = view.findViewById(R.id.most_rec_trips);
        triplm = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false);
        tripad = new vote_Adapter(test() ,universalImageLoader, this);

        agencies = view.findViewById(R.id.most_followed_agen);
        agencylm = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false);

        arrayList = test();

        tripad = new vote_Adapter(arrayList,universalImageLoader, this);

        trips.setHasFixedSize(true);
        trips.setLayoutManager(triplm);
        trips.setAdapter(tripad);

        agencies.setHasFixedSize(true);
        agencies.setLayoutManager(agencylm);
        agencies.setAdapter(tripad);

        return view;
    }
    ArrayList<trip_recycler> test(){
        ArrayList<trip_recycler> te = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            trip_recycler t = new trip_recycler();
            String urlString = "https://arabacademy-u8hapu3mdn.netdna-ssl.com/wp-content/uploads/2016/08/alexandria-1.jpg";

            t.setImgURL(urlString);
            t.setTitle("Trip "+(i+1));

            te.add(t);
        }
        return te;
    }

    private void initImageLoader(){
        universalImageLoader = new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }

    @Override
    public void onClick(int i) {
        Toast.makeText(getContext(),arrayList.get(i).getTitle(),Toast.LENGTH_LONG).show();
    }
}
