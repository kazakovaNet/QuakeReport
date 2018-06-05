package com.example.android.quakereport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kazakova_net on 06.06.2018.
 */
public class Earthquake {
    private double magnitude;
    private String place;
    private Date date;

    Earthquake(double magnitude, String place, String date) {
        this.magnitude = magnitude;
        this.place = place;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            this.date = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, YYYY", Locale.getDefault());

        return simpleDateFormat.format(date);
    }
}
