package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupStudent_Activity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private EditText fullname;
    private EditText phonenumber;
    private EditText mailadress;
    private EditText studyarea;
    private EditText city;
    private EditText manualorautomatic;
    private EditText username;
    private EditText password;
    private EditText passwordagain;
    private Button finish;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullname = findViewById(R.id.btnfullname);
        phonenumber = findViewById(R.id.btnphonenumber);
        mailadress = findViewById(R.id.btnmailadress);
        studyarea = findViewById(R.id.btnstudyarea);
        city = findViewById(R.id.btncity);
        manualorautomatic = findViewById(R.id.btnmanualorautomatic);
        username = findViewById(R.id.btnusername);
        password = findViewById(R.id.btnpassword);
        passwordagain = findViewById(R.id.btnpasswordagain);
        finish = findViewById(R.id.btnfinish3);
        firebaseAuth = FirebaseAuth.getInstance();
        finish.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == finish) {
            if (password==passwordagain)
                Student S= new Student();
            firebaseAuth.createUserWithEmailAndPassword(mailadress.getText().toString(), password.getText().toString()).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(SignupStudent_Activity.this, TeacherProfile_Activity.class);
                                startActivity(intent);
                            }
                        }

                    });
        }
    }
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_student_);
    }
}