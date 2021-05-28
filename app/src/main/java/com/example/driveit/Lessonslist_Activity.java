package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lessonslist_Activity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessonslist);

        home = findViewById(R.id.btnhome);
        home.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        if (v == home) {
            Intent intent = new Intent( this, StudentsProfile_Activity.class);
            startActivity(intent);
        }

    }
}