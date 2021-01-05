package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private TextView driveit;
    private Button username;
    private Button password;
    private Button signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        driveit = findViewById(R.id.txtdriveit);
        username = findViewById(R.id.btnhome);
        username.setOnClickListener(this);
        password = findViewById(R.id.btnprogress);
        password.setOnClickListener(this);
        signin = findViewById(R.id.btncontrol);
        signin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == signin) {
            Intent intent = new Intent( this,
                    ProfileActivity_S.class);
            startActivity(intent);
        }

    }
}