package com.example.android.quakereport;

/**
 * Created by Kazakova_net on 06.06.2018.
 */
public class Earthquake {
    private double magnitude;
    private String place;
    private long time;
    private String url;
    
    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param place     is the city location of the earthquake
     * @param time      is the time in milliseconds (from the Epoch) when the earthquake happened
     * @param url       is the URL for earthquake
     */
    Earthquake(double magnitude, String place, long time, String url) {
        this.magnitude = magnitude;
        this.place = place;
        this.time = time;
        this.url = url;
    }
    
    public double getMagnitude() {
        return magnitude;
    }
    
    public String getPlace() {
        return place;
    }
    
    public long getDate() {
        return time;
    }
    
    public String getUrl() {
        return url;
    }
}
