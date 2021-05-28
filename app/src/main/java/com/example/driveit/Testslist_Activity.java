package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Studentlist_Activity extends AppCompatActivity implements View.OnClickListener {
    private View v;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testslist);

    }

    @Override
    public void onClick(View v) {
        if (v == profilepic) {
            // Intent intent = new Intent(this, .class);
            //  startActivity(intent);
        }


        if (v == studentsrating) {
            Intent intent = new Intent(this, Studentslist_Activity.class);

            startActivity(intent);


        }

        if (v == schedule) {
            Intent intent = new Intent(this, SchedulingActivity.class);

            startActivity(intent);

        }

        if (v == info) {
            Intent intent = new Intent(this, Info_Activity.class);
            startActivity(intent);
        }

        if (v == setting) {
            Intent intent = new Intent(this, SignupTeacher_Activity.class);
            startActivity(intent);
        }
    }
}
