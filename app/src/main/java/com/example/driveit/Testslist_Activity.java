package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Testslist_Activity extends AppCompatActivity implements View.OnClickListener {
    private Dialog d;
    private TextView testslist;
    private TextView studentname;
    private Button plus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testslist);

        testslist= findViewById(R.id.txttestlist);
        studentname=findViewById(R.id.txtstudentname);

        plus = (Button) findViewById(R.id.btnplus);
        plus.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == plus) {
            d = new Dialog(this);
            d.setContentView(R.layout.newtest_dialog);
            d.getWindow().setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            d.setCancelable(true);
            d.show();
        }

    }

    }


