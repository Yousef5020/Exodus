package com.exodus.exodus;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class home extends Fragment {

    public home() {

    }

    private RecyclerView votes;
    private RecyclerView trips;
    private RecyclerView agencies;

    private RecyclerView.LayoutManager triplm;

    private RecyclerView.Adapter tripad;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        trips = view.findViewById(R.id.most_rec_trips);
        triplm = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false);
        tripad = new vote_Adapter(test());

        trips.setHasFixedSize(true);
        trips.setLayoutManager(triplm);
        trips.setAdapter(tripad);

        return view;
    }
    ArrayList<trip_recycler> test(){
        ArrayList<trip_recycler> te = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            trip_recycler t = new trip_recycler();
            BitmapDrawable d = (BitmapDrawable) getResources().getDrawable(R.drawable.appbackground);
            Bitmap b = d.getBitmap();
            t.setImg(b);
            t.setTitle(""+(i+1));

            te.add(t);
        }
        return te;
    }
}
