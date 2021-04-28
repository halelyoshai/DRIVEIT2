package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;

public class SchedulingActivity extends AppCompatActivity {
    CalendarView simpleCalendarView = (CalendarView) findViewById(R.id.CalendarView);
    long selectedDate = simpleCalendarView.getDate();
    CalendarView simpleCalendarView = (CalendarView) findViewById(R.id.CalendarView);
simpleCalendarView.setFirstDayOfWeek(1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduling);

    }

}

