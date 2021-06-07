package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lessonslist_Activity extends AppCompatActivity implements View.OnClickListener {
    private Dialog d;
    private TextView lessonlist;
    private TextView studentname;
    private Button plus;
    private Button tests;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessonslist);

        d = new Dialog(this);
        lessonlist= findViewById(R.id.txtlessons);
        studentname=findViewById(R.id.txtstudentname);

        d.setContentView(R.layout.answerone_dialog);
        plus = (Button) findViewById(R.id.btnplus);
        plus.setOnClickListener(this);

        tests= findViewById(R.id.btntests);
        tests.setOnClickListener(this);

        lessonlist.setOnClickListener(this);
        studentname.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v == tests) {
            Intent intent = new Intent( this, Testslist_Activity.class);
             startActivity(intent);
        }
        if (v == plus) {
            d.setContentView(R.layout.newtest_dialog);
        }


        }

    }
