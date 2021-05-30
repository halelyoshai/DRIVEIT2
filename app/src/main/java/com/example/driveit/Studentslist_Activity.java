package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Studentslist_Activity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sp;
    private View v;
    private Dialog d;
    private TextView studentnum;
    private Button plus;
    private TextView namestudent;
    private Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentslist__t);

        d.setContentView(R.layout.answerone_dialog);
        plus = (Button) findViewById(R.id.btnplus);
        plus.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);

        studentnum = findViewById(R.id.txtstudentsnumber);
        namestudent = findViewById(R.id.txtstudentname);
        home = findViewById(R.id.btnhome);
        home.setOnClickListener(this);

        studentnum.setOnClickListener (this);
        plus.setOnClickListener (this);
        namestudent.setOnClickListener (this);
        home.setOnClickListener (this);




    }
    @Override
    public void onClick(View v) {
        if (v== plus){
            d.setContentView(R.layout.newstudent_dialog);
        }
        if (v == home) {
            Intent intent = new Intent( this, StudentsProfile_Activity.class);
            startActivity(intent);
        }

            }
        }



