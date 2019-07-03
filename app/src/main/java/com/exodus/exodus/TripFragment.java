package com.exodus.exodus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TripFragment extends Fragment {

    public TripFragment() {
        // Required empty public constructor
    }

    UniversalImageLoader universalImageLoader;
    ImageView trip_photo;
    TextView trip_name, trip_agency_name, trip_price, trip_duration, trip_date,
            trip_description, trip_from, trip_to, trip_views, trip_deadline;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trip, container, false);

        trip_photo = v.findViewById(R.id.trip_photo);
        trip_name = v.findViewById(R.id.trip_name);
        trip_agency_name = v.findViewById(R.id.trip_agency_name);
        trip_price = v.findViewById(R.id.trip_price);
        trip_duration = v.findViewById(R.id.trip_duration);
        trip_date = v.findViewById(R.id.trip_date);
        trip_description = v.findViewById(R.id.trip_description);
        trip_from = v.findViewById(R.id.trip_from);
        trip_to = v.findViewById(R.id.trip_to);
        trip_views = v.findViewById(R.id.trip_views);
        trip_deadline = v.findViewById(R.id.trip_deadline);

        initImageLoader();

        getTrips();

        return v;
    }

    static List<Trip> trip = new ArrayList<>();

    void getTrips() {

        final int id = getActivity().getIntent().getIntExtra("trip_id", 0);

        Call<List<Trip>> call = RetrofitClient.getInstance().getApi().getTrip();

        call.enqueue(new Callback<List<Trip>>() {
            @Override
            public void onResponse(@NonNull Call<List<Trip>> call, @NonNull Response<List<Trip>> response) {
                if (response.isSuccessful()) {
                    trip = response.body();

                    for (Trip t : trip) {
                        if (t.getTrip_id() == id) {
                            System.out.println(t.getUrl());
                            universalImageLoader.setImage(t.getUrl(), trip_photo);
                            trip_name.setText(t.getName());
                            trip_agency_name.setText(t.getAgency_name());
                            trip_price.setText(t.getPrice() + "EGP");
                            int duration = t.getDate_to().getDate() -t.getDate_from().getDate();
                            DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getContext());
                            trip_duration.setText(duration + " Days");
                            trip_date.setText(dateFormat.format(t.getDate_from()));
                            trip_description.setText(t.getDescription());
                            trip_from.setText(t.getFrom_location());
                            trip_to.setText(t.getTo_location());
                            trip_views.setText(t.getViews());
                            trip_deadline.setText(dateFormat.format(t.getDeadline()));
                        }
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Trip>> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initImageLoader() {
        universalImageLoader = new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }
}
