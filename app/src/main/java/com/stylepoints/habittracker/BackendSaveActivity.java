package com.stylepoints.habittracker;

/**
 * Created by Brad on 2017-11-07.
 */

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

//elastic search backend implement this

public class BackendSaveActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_following);
    }


    List getEventsWithinRadius(Habit habit, Location location, int radiusKM) {
            List<HabitEvent> list = habit.getHabitEventList();
            List within = new ArrayList();

            for (int i = 0; i < list.size(); i++){
                HabitEvent event = list.get(i);
                Location eventcoord = event.getLocation();
                if (eventcoord.distanceTo(location) <= radiusKM){
                    within.add(event);
                }
            }

                return within;

    }
}
