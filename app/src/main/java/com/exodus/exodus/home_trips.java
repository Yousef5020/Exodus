package com.exodus.exodus;

public class home_trips {
    private int trip;
    private String trip_name;
    private String url;

    public home_trips(int trip, String trip_name, String url) {
        this.trip = trip;
        this.trip_name = trip_name;
        this.url = url;
    }

    int getTrip() {
        return trip;
    }

    String getTrip_name() {
        return trip_name;
    }

    String getUrl() {
        return url;
    }
}
