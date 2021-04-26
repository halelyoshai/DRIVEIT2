package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentsProfile_Activity extends AppCompatActivity {
    private View v;
    private TextView studentprofile;
    private Button name;
    private Button city;
    private Button teacher;
    private Button school;
    private Button editprofile;
    private Button info;
    private Button scheduling;
    private Button progress;
    private TextView lessonsnum, smalltest, bigtest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofile__s);
        studentprofile = findViewById(R.id.txtstudentprofile);
         = findViewById(R.id.btnname);
        city = findViewById(R.id.btncity);
        teacher = findViewById(R.id.btnteacher);
        school = findViewById(R.id.btnschool);
        editprofile = findViewById(R.id.btndefinitions);
        info = findViewById(R.id.btninfo);
        scheduling = findViewById(R.id.btnscheduling);
        progress = findViewById(R.id.btnprogress);

        name.setOnClickListener(this);
        city.setOnClickListener(this);
        teacher.setOnClickListener(this);
        school.setOnClickListener(this);
        editprofile.setOnClickListener (this);
        info.setOnClickListener (this);
        scheduling.setOnClickListener(this);
        progress.setOnClickListener (this);




    }
    @Override
    public void onClick(View v) {
        if (v == editprofile ) {
            Intent intent = new Intent(this, Setting_Activity.class);
            startActivity(intent);
        }

        if (Intent intent = new Intent( this, StudentsInfo_Activity.class);{
            startActivity(intent);
        }



        if (v == scheduling ) {
            Intent intent = new Intent( this, חסר אקטיביטי.class);
            startActivity(intent)
        }
    }
}

                       
                        
                    