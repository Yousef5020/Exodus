package com.exodus.exodus;

public class trips_recycler {

    private int trip;
    private String agency_name;
    private String trip_name;
    private String url;
    private int going;

    public trips_recycler(int trip, String agency_name, String trip_name, String url, int going) {
        this.trip = trip;
        this.agency_name = agency_name;
        this.trip_name = trip_name;
        this.url = url;
        this.going = going;
    }

    public int getTrip() {
        return trip;
    }

    String getAgency_name() {
        return agency_name;
    }

    String getName() {
        return trip_name;
    }

    String getUrl() {
        return url;
    }

    String getGoing() {
        return String.valueOf(going);
    }
}
