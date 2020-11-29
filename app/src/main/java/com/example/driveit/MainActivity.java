package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private View v1;
    private TextView driveit;
    private Button signin;
    private Button signups;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        driveit = findViewById(R.id.driveit);
        signin = findViewById(R.id.btnsignin);
        signin.setOnClickListener(this);
        signups = findViewById(R.id.btnsignups);
        signups.setOnClickListener(this);
        signup = findViewById(R.id.btnsignup);
        signup.setOnClickListener(this);


    }


    @Override
    public void onClick(View v1) {
        if (v1 == signin) {
            Intent intent = new Intent( this, SigninActivity.class);
            startActivity(intent);
        }

            if (v1 == signups) {
                Intent intent = new Intent( this, SignupstudentsActivity.class);
                startActivity(intent);
            }

            if (v1 == signup) {
                Intent intent = new Intent( this, SignupteachersActivity.class);
                startActivity(intent);
            }
    }
}