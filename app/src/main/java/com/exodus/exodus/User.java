package com.exodus.exodus;

public class User {

    private int id;
    private String name, e_mail, phone, city, password, photo_url;

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return e_mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public User(int id, String name, String e_mail, String phone, String city, String password) {
        this.id = id;
        this.name = name;
        this.e_mail = e_mail;
        this.phone = phone;
        this.city = city;
        this.password = password;
    }
}
