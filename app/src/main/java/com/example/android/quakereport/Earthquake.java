package com.example.android.quakereport;

/**
 * Created by Kazakova_net on 06.06.2018.
 */
public class Earthquake {
    private double magnitude;
    private String place;
    private String time;
    
    Earthquake(double magnitude, String place, String time) {
        this.magnitude = magnitude;
        this.place = place;
        this.time = time;
    }
    
    public double getMagnitude() {
        return magnitude;
    }
    
    public String getPlace() {
        return place;
    }
    
    public String getDate() {
        return time;
    }
}
