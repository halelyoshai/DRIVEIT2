package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoActivity_S extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sp;
    private Dialog d;
    private Button quation1, quation2, quation3, quation4, quation5, quation6, quation7, quation8, quation9, quation10;
    private View v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        d = new Dialog(this);

        d.setContentView(R.layout.answerone_dialog);
        quation1 = (Button) findViewById(R.id.btninfo1);
        quation1.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);

        d.setContentView(R.layout.answertwo_dialog);
        quation2 = (Button) findViewById(R.id.btninfo2);
        quation2.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);


        quation3 = (Button) findViewById(R.id.btninfo3);
        quation3.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);


        quation4 = (Button) findViewById(R.id.btninfo4);
        quation4.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);

        quation5 = (Button) findViewById(R.id.btninfo5);
        quation5.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);

        quation6 = (Button) findViewById(R.id.btninfo6);
        quation6.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);

        quation7 = (Button) findViewById(R.id.btninfo7);
        quation7.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);

        quation8 = (Button) findViewById(R.id.btninfo8);
        quation8.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);

        quation9 = (Button) findViewById(R.id.btninfo9);
        quation9.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);


        quation10 = (Button) findViewById(R.id.btninfo10);
        quation10.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);

    }

    public void creatAnswerDialog() {
        d.getWindow().setLayout(150, 150);
        d.setTitle("Answer");
        d.setCancelable(true);
        d.show();
    }

    @Override
    public void onClick(View v) {
        if (v == quation1) {
            d.setContentView(R.layout.answerone_dialog);
        }

        if (v == quation2) {
            d.setContentView(R.layout.answertwo_dialog);
        }
        if (v == quation3) {
            d.setContentView(R.layout.answerthree_dialog);
        }
        if (v == quation4) {
            d.setContentView(R.layout.answerfour_dialog);
        }

        if (v == quation5) {
            d.setContentView(R.layout.answerfive_dialog);
        }

       if (v == quation6) {
            creatAnswerDialog();
        }
        if (v == quation7) {
            creatAnswerDialog();
        }
        if (v == quation8) {
            creatAnswerDialog();
        }
        if (v == quation9) {
            creatAnswerDialog();
        }
        if (v == quation10) {
            creatAnswerDialog();
        }
         creatAnswerDialog();
            }
        }
    }
}