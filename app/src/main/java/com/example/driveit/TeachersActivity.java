package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeachersActivity extends AppCompatActivity {
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);

        next = findViewById(R.id.btnnext);
        next.setOnClickListener(this::onClick);
    }
    public void onClick(View v){
        if(v==next){
            Intent intent= new Intent(this, StudentsProfile_Activity.class);
            startActivity(intent);
        }
    }
}