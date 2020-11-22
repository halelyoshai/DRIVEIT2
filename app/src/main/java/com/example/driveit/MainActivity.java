package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private View v1;
    private TextView driveit;
    private Button btnsignin;
    private Button btnsignups;
    private Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentsrating);

        TextView driveit = findViewById(R.id.text1);
        driveit = findViewById(R.id.back);
        driveit.setOnClickListener(this);
        btnsignin = findViewById(R.id.button);
        btnsignin.setOnClickListener(this);
        btnsignups = findViewById(R.id.buttonsh);
        btnsignups.setOnClickListener(this);
        btnsignup = findViewById(R.id.buttonh);
        btnsignup.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
    }

    if ( v1 == btnsignin){
        Intent intent = new Intent(this, signin.class);
        startActivity(intent);
    }

        if (v1 == btnsignups) {
            Intent intent1 = new Intent(this, signupstudent.class);
            startActivity(intent1);
        }

        if (v1== btnsignup) {
            Intent intent2 = new Intent(this, signupteacher.class);
            startActivity(intent2);

        }
    }
