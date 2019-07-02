package com.exodus.exodus;

import java.util.Date;

public class Trip {

    private int trip_id;
    private String name;
    private String agency_name;
    private String from_location;
    private String to_location;
    private Date date_from;
    private Date date_to;
    private Date deadline;
    private String meals;
    private double price;
    private String description;
    private int views;
    private double rate;
    private int agency;

    public int getTrip_id() {
        return trip_id;
    }

    public String getName() {
        return name;
    }

    public String getAgency_name() {
        return agency_name;
    }

    public String getFrom_location() {
        return from_location;
    }

    public String getTo_location() {
        return to_location;
    }

    public Date getDate_from() {
        return date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getMeals() {
        return meals;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getViews() {
        return views;
    }

    public double getRate() {
        return rate;
    }

    public int getAgency() {
        return agency;
    }

    public Trip(int trip_id, String name, String agency_name, String from_location, String to_location, Date date_from, Date date_to, Date deadline, String meals, double price, String description, int views, double rate, int agency) {
        this.trip_id = trip_id;
        this.name = name;
        this.agency_name = agency_name;
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
        this.agency = agency;
    }
}