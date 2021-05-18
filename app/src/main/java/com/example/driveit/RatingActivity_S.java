package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RatingActivity_S extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private TextView rating;
    private TextView studentname;
    private TextView progress;
    private TextView control;
    private TextView parking;
    private TextView caution;
    private TextView qoute;
    private Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_s);

        rating = findViewById(R.id.txtstudentsrating);
        studentname = findViewById(R.id.text2);
        progress = findViewById(R.id.btnprogress);
        control = findViewById(R.id.btncontrol);
        parking = findViewById(R.id.btnparking);
        caution = findViewById(R.id.txtcaution);
        qoute = findViewById(R.id.txtquote);
        home = findViewById(R.id.btnhome);
        home.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        if (v == home) {
            Intent intent = new Intent( this, StudentsProfile_Activity.class);
            startActivity(intent);
        }

    }
}