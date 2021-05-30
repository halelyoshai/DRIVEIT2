package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class TeacherProfile_Activity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private TextView teacherprofile;
    private ImageButton profilepic;
    private TextView teachername;
    private TextView studyarea;
    private TextView school;
    private TextView studentsnum;
    private ImageButton students;
    private ImageButton info;
    private ImageButton setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile_);

        teacherprofile = findViewById(R.id.txtteacherprofile);
        findViewById(R.id.btnprofilepic);
        teachername = findViewById(R.id.txtteachername);
        studyarea = findViewById(R.id.txtstudyarea);
        school = findViewById(R.id.txtschool);
        studentsnum = findViewById(R.id.txtstudentsnum);
        students= findViewById(R.id.btnstudents);
        students.setOnClickListener(this);
        info= findViewById(R.id.btninfo);
        info.setOnClickListener(this);
        setting= findViewById(R.id.btnsetting);
        setting.setOnClickListener(this);


        teacherprofile.setOnClickListener(this);
        profilepic.setOnClickListener(this);
        teachername.setOnClickListener(this);
        studyarea.setOnClickListener(this);
        school.setOnClickListener(this);
        studyarea.setOnClickListener(this);
        studentsnum.setOnClickListener(this);
        students.setOnClickListener(this);
        info.setOnClickListener(this);
        setting.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == profilepic) {
            // Intent intent = new Intent(this, galary.class);
            //  startActivity(intent);
        }


        if (v == students) {
            Intent intent = new Intent(this, Studentslist_Activity.class);
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
