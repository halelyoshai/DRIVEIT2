package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentslistActivity_T extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentslist__t);

    public static class TeacherprofileActivity extends AppCompatActivity implements View.OnClickListener
    {
        private View v;
        private TextView studentslist;
        private Button btnstudentname1, btnstudentname2, btnrating1, btnrating2;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_teacherprofile);
            studentslist = findViewById(R.id.txtstudentslist);
            btnstudentname1 = findViewById(R.id.btnstudentname1);
            btnstudentname1.setOnClickListener(this);
            btnstudentname2 = findViewById(R.id.btnstudentname2);
            btnstudentname2.setOnClickListener(this);
            btnrating1 = findViewById(R.id.btnrating1);
            btnrating2.setOnClickListener(this);
            btnrating2 = findViewById(R.id.btnrating2);


        }

    }
}
}