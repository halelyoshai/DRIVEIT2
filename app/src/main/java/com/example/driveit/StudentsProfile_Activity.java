package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentsProfile_Activity extends AppCompatActivity {
    private View v;
    private Button studentprofile;
    private TextView name;
    private TextView city;
    private TextView teacher;
    private TextView school;
    private TextView bigtest;
    private TextView smalltest;
    private TextView lessonsnum;
    private Button info;
    private Button scheduling;
    private Button progress;
    private Button setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofile__s);

        studentprofile = findViewById(R.id.btnstudentprufile);
        name = findViewById(R.id.txtname);
        city = findViewById(R.id.txtcity);
        teacher = findViewById(R.id.txtteacher);
        school = findViewById(R.id.txtschool);
        bigtest = findViewById(R.id.txtbigtest);
        smalltest = findViewById(R.id.txtsmalltest);
        lessonsnum = findViewById(R.id.txtlessonscounting);
        progress = findViewById(R.id.btnprogress);
        scheduling = findViewById(R.id.btnscheduling);
        info = findViewById(R.id.btninfo);
        setting = findViewById(R.id.btnsetting);

        studentprofile.setOnClickListener (this);
        name.setOnClickListener(this);
        city.setOnClickListener(this);
        teacher.setOnClickListener(this);
        school.setOnClickListener(this);
        bigtest.setOnClickListener(this);
        smalltest.setOnClickListener(this);
        lessonsnum.setOnClickListener(this);
        progress.setOnClickListener (this);
        scheduling.setOnClickListener(this);
        info.setOnClickListener (this);
        setting.setOnClickListener(this);




    }
    @Override
    public void onClick(View v) {
        if (v == studentprofile ) {
            Intent intent = new Intent(this, גלריה.class);
            startActivity(intent);
        }

        if (v == progress){
        Intent intent = new Intent ( this, RatingActivity_S.class);
            startActivity(intent);
        }



        if (v == scheduling ) {
            Intent intent = new Intent( this, SchedulingActivity.class);
            startActivity(intent);
        }


        if (v == setting){
            Intent intent = new Intent ( this, SignupStudent_Activity.class);
            startActivity(intent);
        }

    }
}

                       
                        
                    