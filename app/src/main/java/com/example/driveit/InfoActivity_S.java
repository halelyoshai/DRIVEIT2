package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InfoActivity_S extends AppCompatActivity {
    SharedPreferences sp;
    private Dialog d;
    private Button quation1, quation2, quation3, btnout;
    private View v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        quation1 = (Button) findViewById(R.id.btninfo1);
        quation1.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);

        quation2 = (Button) findViewById(R.id.btninfo2);
        quation2.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);

        quation3 = (Button) findViewById(R.id.btninfo3);
        quation3.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);

        btnout = (Button) findViewById(R.id.btnout);
        btnout.setOnClickListener(this);
        sp = getSharedPreferences("details1", 0);
    }

    public void creatInfoDialog() {
        d = new Dialog(this);
        d.setContentView(R.layout.info_dialog);
        d.setTitle("Answer");
        d.setCancelable(true);
        quation1 = (Button) findViewById(R.id.btninfo1);
        quation2 = (Button) findViewById(R.id.btninfo2);
        quation3 = (Button) findViewById(R.id.btninfo3);
        d.show();
    }

    @Override
    public void onClick(View v) {
        if (v == quation1) {
            creatInfoDialog();
        } else if (v == btnout) {
            d.dismiss();
        }

    }
}
