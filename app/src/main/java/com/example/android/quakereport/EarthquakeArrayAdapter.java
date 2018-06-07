package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kazakova_net on 06.06.2018.
 */
public class EarthquakeArrayAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeArrayAdapter(@NonNull Activity context, @NonNull ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude_text_view);
        TextView locationOffsetTextView = listItemView.findViewById(R.id.location_offset_text_view);
        TextView primaryLocationTextView = listItemView.findViewById(R.id.primary_location_text_view);
        TextView dateTextView = listItemView.findViewById(R.id.date_text_view);
        TextView timeTextView = listItemView.findViewById(R.id.time_text_view);

        Earthquake earthquake = getItem(position);
        if (earthquake != null) {
            magnitudeTextView.setText(String.valueOf(earthquake.getMagnitude()));

            locationOffsetTextView.setText(formatLocationOffset(earthquake.getPlace()));
            primaryLocationTextView.setText(formatPrimaryLocation(earthquake.getPlace()));

            Date earthquakeDate = new Date(earthquake.getDate());

            dateTextView.setText(formatDate(earthquakeDate));
            timeTextView.setText(formatTime(earthquakeDate));
        }

        return listItemView;
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
