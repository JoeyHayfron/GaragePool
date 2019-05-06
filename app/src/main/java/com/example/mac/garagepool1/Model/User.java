package com.example.mac.garagepool1.Model;

import java.text.DecimalFormat;

/**
 * Created by mac on 21/12/2017.
 */

public class User {
    public String email,password,name,phone,expertise;
    public float latitude,longitude,ratings;

    public User() {
    }

    public User(String email, String password, String name, String phone, float latitude,float longitude, String expertise,float ratings) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.expertise = expertise;
        this.ratings = ratings;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public float getratings() {
        return ratings;
    }

    public void setratings(float ratings) {
        this.ratings = ratings;
    }
}
