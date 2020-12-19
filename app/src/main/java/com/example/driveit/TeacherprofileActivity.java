package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TeacherprofileActivity extends AppCompatActivity {
        private View v;
        private TextView profileteacher;
        private Button name;
        private Button school;
        private Button city;
        private Button freelesson;
        private Button waitingtest;
        private Button studentcounting;
        private Button nowinclass;
        private Button nextlesson;
        private Button nextlessontime;
        private Button editpersonalprofile;
        private Button schedule;
        private Button payments;
        private Button studentprogress;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherprofile);
        profileteacher = findViewById(R.id.txtteacherprofile);
        name = findViewById(R.id.btnname);
        name.setOnClickListener(this);
        school = findViewById(R.id.btnschool);
        school.setOnClickListener(this);
        city = findViewById(R.id.btncity);
        city.setOnClickListener(this);
        freelesson = findViewById(R.id.availble);
        freelesson.setOnClickListener(this);
        waitingtest = findViewById(R.id.waitingtest);
        waitingtest.setOnClickListener (this);
        studentcounting = findViewById(R.id.numstudent);
        studentcounting.setOnClickListener (this);
        nowinclass = findViewById(R.id.nowinclass);
        nowinclass.setOnClickListener(this);
        nextlesson = findViewById(R.id.nextlesson);
        nextlesson.setOnClickListener (this);
        nextlessontime = findViewById(R.id.nextlessontime);
        nextlessontime.setOnClickListener (this);
        editpersonalprofile = findViewById(R.id.btnpersonalprofile);
        editpersonalprofile.setOnClickListener (this);
        schedule = findViewById(R.id.btnschedule);
        schedule.setOnClickListener (this);
        payments = findViewById(R.id.btnpayments);
        payments.setOnClickListener(this);
        studentprogress = findViewById(R.id.btnstudentsprogress);
        studentprogress.setOnClickListener (this);

    }
    @Override
    public void onClick(View v) {
        if (v == editpersonalprofile ) {
            Intent intent = new Intent( this, = SignupteachersActivity.class);
            startActivity(intent);

            if (v == schedule ) {
                Intent intent = new Intent( this, חסר אקטיביטי.class);
                startActivity(intent);

                if (v == payments ) {
                    Intent intent = new Intent( this, חסר אקטיביטי.class);
                    startActivity(intent);

                    if (v == studentprogress ) {
                        Intent intent = new Intent( this, חסר אקטיביטי.class);
                        startActivity(intent);


}
