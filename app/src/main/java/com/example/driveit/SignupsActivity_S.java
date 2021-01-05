package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignupstudentsActivity extends AppCompatActivity implements View.OnClickListener {

    private View v2;
    private TextView fullname;
    private Button phonenumber;
    private Button mailadress;
    private Button studyarea;
    private TextView city;
    private Button manualorautomatic;
    private Button username;
    private Button password;
    private Button passwordagain;
    private Button finish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupstudent);
        fullname = findViewById(R.id.btnfullname);
        fullname.setOnClickListener(this);
        phonenumber = findViewById(R.id.btnphonenumber);
        phonenumber.setOnClickListener(this);
        mailadress = findViewById(R.id.btnmailadress);
        mailadress.setOnClickListener(this);
        studyarea = findViewById(R.id.btnstudyarea);
        studyarea.setOnClickListener(this);
        city = findViewById(R.id.btncity);
        city.setOnClickListener(this);
        manualorautomatic = findViewById(R.id.btnmanualorautomatic);
        manualorautomatic.setOnClickListener(this);
        username = findViewById(R.id.btnusername);
        username.setOnClickListener(this);
        password = findViewById(R.id.btnpassword);
        password.setOnClickListener(this);
        passwordagain = findViewById(R.id.btnpasswordagain);
        passwordagain.setOnClickListener(this);
        finish = findViewById(R.id.btnfinish);
        finish.setOnClickListener(this);


    }


    @Override
    public void onClick(View v2) {
        if (v2 == finish) {
            Intent intent = new Intent( this, StudentprofileActivity.class);
            startActivity(intent);
        }

    }
}

