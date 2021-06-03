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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentslist__t);

        d.setContentView(R.layout.newstudent_dialog);
        plus = (Button) findViewById(R.id.btnplus);

        studentnum = findViewById(R.id.txtstudentsnumber);
        namestudent = findViewById(R.id.txtstudentname);

        plus.setOnClickListener (this);






    }
    @Override
    public void onClick(View v) {
        if (v== plus){
            d.setContentView(R.layout.newstudent_dialog);
        }

            }
        }



