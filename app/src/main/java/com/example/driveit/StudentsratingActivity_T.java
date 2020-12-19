package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentsratingActivity_T extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private TextView rating;
    private Button home;
    private Button progress;
    private Button control;
    private Button parking;
    private Button caution;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentsrating);

         rating = findViewById(R.id.txtstudentsrating);
         home = findViewById(R.id.btnhome);
         home.setOnClickListener(this);
         progress = findViewById(R.id.btnprogress);
         progress.setOnClickListener(this);
         control = findViewById(R.id.btncontrol);
         control.setOnClickListener(this);
         parking = findViewById(R.id.btnparking);
         parking.setOnClickListener(this);
         caution = findViewById(R.id.btncaution);
         caution.setOnClickListener (this);
        save = findViewById(R.id.save);
        save.setOnClickListener (this);

}

    @Override
    public void onClick(View v) {
        if (v == home) {
            Intent intent = new Intent( this, TeacherprofileActivity.class);
            startActivity(intent);
        }

    }
}