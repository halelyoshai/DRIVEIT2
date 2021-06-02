package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Info_Activity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sp;
    private Dialog d;
    private Button quation1, quation2, quation3, quation4, quation5, quation6, quation7, quation8, quation9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        quation1 = (Button) findViewById(R.id.btninfo1);
        quation1.setOnClickListener(this);

        quation2 = (Button) findViewById(R.id.btninfo2);
        quation2.setOnClickListener(this);

        quation3 = (Button) findViewById(R.id.btninfo3);
        quation3.setOnClickListener(this);

        quation4 = (Button) findViewById(R.id.btninfo4);
        quation4.setOnClickListener(this);

        quation5 = (Button) findViewById(R.id.btninfo5);
        quation5.setOnClickListener(this);

        quation6 = (Button) findViewById(R.id.btninfo6);
        quation6.setOnClickListener(this);

        quation7 = (Button) findViewById(R.id.btninfo7);
        quation7.setOnClickListener(this);

        quation8 = (Button) findViewById(R.id.btninfo8);
        quation8.setOnClickListener(this);

        quation9 = (Button) findViewById(R.id.btninfo9);
        quation9.setOnClickListener(this);
        sp=getSharedPreferences("details1",0);
    }

    public void creatAnswerDialog(int layout) {
        d= new Dialog(this);
        d.setContentView(layout);
        d.getWindow().setLayout(150, 150);
        d.setTitle("Answer");
        d.setCancelable(true);
        d.show();
    }

    @Override
    public void onClick(View v) {
        if (v == quation1) {
           d.show();
        }

        if (v == quation2) {
            creatAnswerDialog(R.layout.answertwo_dialog);
        }
        if (v == quation3) {
            creatAnswerDialog(R.layout.answerthree_dialog);
        }
        if (v == quation4) {
            creatAnswerDialog(R.layout.answerfour_dialog);
        }

        if (v == quation5) {
            creatAnswerDialog(R.layout.answerfive_dialog);
        }

       if (v == quation6) {
           creatAnswerDialog(R.layout.answersix_dialog);
        }
        if (v == quation7) {
            creatAnswerDialog(R.layout.answerseven_dialog);
        }
        if (v == quation8) {
            creatAnswerDialog(R.layout.answereight_dialog);
        }
        if (v == quation9) {
            creatAnswerDialog(R.layout.answernine_dialog);
        }
            }
        }
