package com.exodus.exodus;


import java.util.Date;

public class Trip {

    private int trip;
    private String agency_name;
    private int going_to;
    private String trip_name;
    private String from_location;
    private String to_location;
    private Date date_from;
    private Date date_to;
    private Date deadline;
    private String meals;
    private double price;
    private String description;
    private int views;
    private int rate;
    private String url;

    public Trip(int trip, String agency_name, int going_to, String trip_name, String from_location, String to_location, Date date_from, Date date_to, Date deadline, String meals, double price, String description, int views, int rate, String url) {
        this.trip = trip;
        this.agency_name = agency_name;
        this.going_to = going_to;
        this.trip_name = trip_name;
        this.from_location = from_location;
        this.to_location = to_location;
        this.date_from = date_from;
        this.date_to = date_to;
        this.deadline = deadline;
        this.meals = meals;
        this.price = price;
        this.description = description;
        this.views = views;
        this.rate = rate;
        this.url = url;
    }

    int getTrip_id() {
        return trip;
    }

    String getAgency_name() {
        return agency_name;
    }

    int getGoing_to() {
        return going_to;
    }

    String getName() {
        return trip_name;
    }

    String getFrom_location() {
        return from_location;
    }

    String getTo_location() {
        return to_location;
    }

    Date getDate_from() {
        return date_from;
    }

    Date getDate_to() {
        return date_to;
    }

    Date getDeadline() {
        return deadline;
    }

    String getMeals() {
        return meals;
    }

    double getPrice() {
        return price;
    }

    String getDescription() {
        return description;
    }

    String getViews() {
        return String.valueOf(views);
    }

    public int getRate() {
        return rate;
    }

    String getUrl() {
        return url;
    }
}