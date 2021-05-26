package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;

public class SchedulingActivity extends AppCompatActivity {
   private CalendarView simpleCalendarView;
    private long selectedDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduling);
        simpleCalendarView = (CalendarView) findViewById(R.id.CalendarView);
        selectedDate = simpleCalendarView.getDate();
        simpleCalendarView.setFirstDayOfWeek(1);
    }

}

