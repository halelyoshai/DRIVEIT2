package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TeacherProfile_Activity extends AppCompatActivity {
    private View v;
    private TextView teacherprofile;
    private Button profilepic;
    private TextView teachername;
    private TextView studyarea;
    private TextView school;
    private TextView studentsnum;
    private TextView waitingfortest;
    private TextView availablelessons;
    private Button studentsrating;
    private Button schedule;
    private Button info;
    private Button setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile_);
        teacherprofile = findViewById(R.id.txtstudentprofile);
        findViewById(R.id.btnprofilepic);
        teachername = findViewById(R.id.txtteachername);
        studyarea = findViewById(R.id.txtstudyarea);
        school = findViewById(R.id.txtschool);
        studentsnum = findViewById(R.id.txtstudentsnum);
        waitingfortest = findViewById(R.id.txtwaitingfortest);
        availablelessons = findViewById(R.id.txtavailablelessons);
        findViewById(R.id.btnprogress);
        findViewById(R.id.btnschedule);
        findViewById(R.id.btninfo);
        findViewById(R.id.btnsetting);

    }
    @Override
    public void onClick(View v)
    {
        if (v == profilepic ) {
            Intent intent = new Intent(this, גלריה.class);
            startActivity(intent);
        }


        if (v == studentsrating){
        Intent intent = new Intent(this, StudentslistActivity_T.class);{
            startActivity(intent);
        }

    }

        if (v == schedule) {
            Intent intent = new Intent( this, SchedulingActivity.class);{
        startActivity(intent);
    }


        if (v == info) {
            intent = new Intent(this, Info_Activity.class);
            startActivity(intent);
        }

            if (v == setting){
                intent = new Intent(this, SignupTeacher_Activity.class);
                startActivity(intent);
            }
    }
}