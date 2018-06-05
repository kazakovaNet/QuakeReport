package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kazakova_net on 06.06.2018.
 */
public class EarthquakeArrayAdapter extends ArrayAdapter<Earthquake> {
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

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place_text_view);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);

        Earthquake earthquake = getItem(position);
        if (earthquake != null) {
            magnitudeTextView.setText(String.valueOf(earthquake.getMagnitude()));
            placeTextView.setText(earthquake.getPlace());
            dateTextView.setText(String.valueOf(earthquake.getDate()));
        }

        return listItemView;
    }
}
