package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity_S extends AppCompatActivity {
    private View v;
    private TextView studentprofile;
    private Button name;
    private Button city;
    private Button teacher;
    private Button school;
    private Button nextlesson;
    private Button connectteacher;
    private Button definitions;
    private Button info;
    private Button scheduling;
    private Button progress;
    private TextView lessonsnum, smalltest, bigtest;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofile__s);
        studentprofile = findViewById(R.id.txtstudentprofile);
        name = findViewById(R.id.btnname);
        name.setOnClickListener(this);
        city = findViewById(R.id.btncity);
        city.setOnClickListener(this);
        teacher = findViewById(R.id.btnteacher);
        teacher.setOnClickListener(this);
        school = findViewById(R.id.btnschool);
        school.setOnClickListener(this);
        nextlesson = findViewById(R.id.btnnextlesson);
        nextlesson.setOnClickListener (this);
        connectteacher = findViewById(R.id.connectteacher);
        connectteacher.setOnClickListener (this);
        definitions = findViewById(R.id.btndefinitions);
        definitions.setOnClickListener (this);
        info = findViewById(R.id.btninfo);
        info.setOnClickListener (this);
        scheduling = findViewById(R.id.btnscheduling);
        scheduling.setOnClickListener(this);
        progress = findViewById(R.id.btnprogress);
        progress.setOnClickListener (this);


    }
    @Override
    public void onClick(View v) {
        if (v == editpersonalprofile ) {
            Intent intent = new Intent( this, SignupsActivity_S.class);
            startActivity(intent);

            if (v == info ) {
                Intent intent = new Intent( this, חסר אקטיביטי.class);
                startActivity(intent);

                if (v == teacherinfo ) {
                    Intent intent = new Intent( this, חסר אקטיביטי.class);
                    startActivity(intent);

                    if (v == scheduling ) {
                        Intent intent = new Intent( this, חסר אקטיביטי.class);
                        startActivity(intent)

                        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofile);
    }
}