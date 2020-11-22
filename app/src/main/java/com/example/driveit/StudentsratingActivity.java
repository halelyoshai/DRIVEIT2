package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentsratingActivity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private TextView rating;
    private Button home;
    private Button hitkadmut;
    private Button shlita;
    private Button parking;
    private Button zehirut;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentsrating);

        TextView rating = findViewById(R.id.text1);
         home = findViewById(R.id.back);
         home.setOnClickListener(this);
         hitkadmut = findViewById(R.id.button);
         hitkadmut.setOnClickListener(this);
         shlita = findViewById(R.id.buttonsh);
         shlita.setOnClickListener(this);
         parking = findViewById(R.id.buttonh);
         parking.setOnClickListener(this);
         zehirut = findViewById(R.id.buttonz);
         zehirut.setOnClickListener (this);
         save = findViewById(R.id.save);
         save.setOnClickListener (this);


}

    @Override
    public void onClick(View v) {
        if (v == home) {
            Intent intent = new Intent( this, studentprofile.class);
            startActivity(intent);
        }

    }
}