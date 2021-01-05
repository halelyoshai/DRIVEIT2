package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentprofileActivity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private TextView studentprofile;
    private Button name;
    private Button city;
    private Button teacher;
    private Button school;
    private Button lessonsnum;
    private Button smalltest;
    private Button bigtest;
    private Button nextlesson;
    private Button connectteacher;
    private Button editpersonalprofile;
    private Button info;
    private Button teacherinfo;
    private Button scheduling;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofile);
        studentprofile = findViewById(R.id.txtstudentsprodfile);
        name = findViewById(R.id.btnname);
        name.setOnClickListener(this);
        city = findViewById(R.id.btncity);
        city.setOnClickListener(this);
        teacher = findViewById(R.id.btnteacher);
        teacher.setOnClickListener(this);
        school = findViewById(R.id.btnschool);
        school.setOnClickListener(this);
        lessonsnum = findViewById(R.id.btnlessonscounting);
        lessonsnum.setOnClickListener (this);
        smalltest = findViewById(R.id.btnsmalltest);
        smalltest.setOnClickListener (this);
        bigtest = findViewById(R.id.btnbigtest);
        bigtest.setOnClickListener(this);
        nextlesson = findViewById(R.id.btnnextlesson);
        nextlesson.setOnClickListener (this);
        connectteacher = findViewById(R.id.connectteacher);
        connectteacher.setOnClickListener (this);
        editpersonalprofile = findViewById(R.id.btnpersonalprofile);
        editpersonalprofile.setOnClickListener (this);
        info = findViewById(R.id.btninfo);
        info.setOnClickListener (this);
        teacherinfo = findViewById(R.id.btnteacherinfo);
        teacherinfo.setOnClickListener(this);
        scheduling = findViewById(R.id.btnschedulingS);
        scheduling.setOnClickListener (this);

    }
    @Override
    public void onClick(View v) {
        if (v == editpersonalprofile ) {
            Intent intent = new Intent( this, SignupstudentsActivity.class);
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