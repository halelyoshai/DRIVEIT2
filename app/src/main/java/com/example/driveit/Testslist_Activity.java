package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Testslist_Activity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    SharedPreferences sp;
    private Dialog d;
    private TextView testslist;
    private TextView studentname;
    private Button plus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessonslist);

        d = new Dialog(this);
        testslist= findViewById(R.id.btntests);
        studentname=findViewById(R.id.txtstudentname);

        d.setContentView(R.layout.answerone_dialog);
        plus = (Button) findViewById(R.id.btnplus);
        plus.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);

        testslist.setOnClickListener(this);
        studentname.setOnClickListener(this);
        plus.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v == plus) {
            d.setContentView(R.layout.newlesson_dialog);
        }


    }

    }


