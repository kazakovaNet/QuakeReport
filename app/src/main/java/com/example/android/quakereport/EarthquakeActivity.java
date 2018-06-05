/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakeArrayList = new ArrayList<>();
        earthquakeArrayList.add(new Earthquake(7.2, "San Francisco", "2016-02-02"));
        earthquakeArrayList.add(new Earthquake(6.1, "London", "2015-07-20"));
        earthquakeArrayList.add(new Earthquake(3.9, "Tokyo", "2014-11-10"));
        earthquakeArrayList.add(new Earthquake(5.4, "Mexico City", "2014-05-03"));
        earthquakeArrayList.add(new Earthquake(2.8, "Moscow", "2013-01-31"));
        earthquakeArrayList.add(new Earthquake(4.9, "Rio de Janeiro", "2012-08-19"));
        earthquakeArrayList.add(new Earthquake(1.6, "Paris", "2011-10-30"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakeArrayList
        EarthquakeArrayAdapter earthquakeArrayAdapter = new EarthquakeArrayAdapter(EarthquakeActivity.this, earthquakeArrayList);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(earthquakeArrayAdapter);
    }
}
