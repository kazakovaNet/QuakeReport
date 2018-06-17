package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Kazakova_net on 06.06.2018.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(@NonNull Activity context, @NonNull List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude);
        TextView locationOffsetTextView = listItemView.findViewById(R.id.location_offset);
        TextView primaryLocationTextView = listItemView.findViewById(R.id.primary_location);
        TextView dateTextView = listItemView.findViewById(R.id.date);
        TextView timeTextView = listItemView.findViewById(R.id.time);

        Earthquake earthquake = getItem(position);
        if (earthquake != null) {
            magnitudeTextView.setText(formatMagnitude(earthquake.getMagnitude()));
            // Set the proper background color on the magnitude circle.
            // Fetch the background from the TextView, which is a GradientDrawable.
            GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
            // Get the appropriate background color based on the current earthquake magnitude
            int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());
            // Set the color on the magnitude circle
            magnitudeCircle.setColor(magnitudeColor);

            locationOffsetTextView.setText(formatLocationOffset(earthquake.getPlace()));
            primaryLocationTextView.setText(formatPrimaryLocation(earthquake.getPlace()));

            Date earthquakeDate = new Date(earthquake.getDate());

            dateTextView.setText(formatDate(earthquakeDate));
            timeTextView.setText(formatTime(earthquakeDate));
        }

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeFloor = (int) Math.floor(magnitude);
        int magnitudeColorResourceId;

        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.getDefault());
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.getDefault());
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(magnitude);
    }

    private String formatLocationOffset(String place) {
        if (place.length() == 0) {
            return "";
        }

        if (place.contains(LOCATION_SEPARATOR)) {
            return place.substring(0, place.indexOf(LOCATION_SEPARATOR) + LOCATION_SEPARATOR.length());
        }

        return getContext().getString(R.string.near_the);
    }

    private String formatPrimaryLocation(String place) {
        if (place.length() == 0) {
            return "";
        }

        if (place.contains(LOCATION_SEPARATOR)) {
            return place.substring(place.indexOf(LOCATION_SEPARATOR) + LOCATION_SEPARATOR.length(), place.length());
        }

        return place;
    }
}
