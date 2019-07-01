package com.exodus.exodus;

import java.util.Date;

public class Trip {

    private int trip_id;
    private String name;
    private  String agency_name;
    private String from_location;
    private String to_location;
    private Date date_from;
    private Date date_to;
    private Date deadline;
    private String meals;
    private double price;
    private String describtion;
    private int views;
    private double rate;
    private int agency;

    public int getTrip_id() {
        return trip_id;
    }

    public String getAgency_name() {
        return agency_name;
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

    public String getDescribtion() {
        return describtion;
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

    public Trip(String name, String from_location, String to_location) {
        this.name = name;
        this.from_location = from_location;
        this.to_location = to_location;
    }

    public String getName() {
        return name;
    }

    public String getFrom_location() {
        return from_location;
    }

    public String getTo_location() {
        return to_location;
    }
}
