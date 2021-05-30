package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupStudent_Activity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private EditText fullname;
    private EditText phonenumber;
    private EditText mailadress;
    private EditText password;
    private EditText passwordagain;
    private Button finish;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private Student student;
 
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullname = findViewById(R.id.btnfullname);
        phonenumber = findViewById(R.id.btnphonenumber);
        mailadress = findViewById(R.id.btnmailadress);
        password = findViewById(R.id.btnpassword);
        passwordagain = findViewById(R.id.btnpasswordagain);
        finish = findViewById(R.id.btnfinish3);
        finish.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Students");

        fullname.setOnClickListener (this);
        phonenumber.setOnClickListener (this);
        mailadress.setOnClickListener (this);
        password.setOnClickListener (this);
        passwordagain.setOnClickListener (this);
        finish.setOnClickListener (this);
    }


    @Override
    public void onClick(View v) {
        if (v == finish) {
            if (password == passwordagain) {
                student = new Student(fullname, phonenumber, mailadress, password, passwordagain, );

                firebaseAuth.createUserWithEmailAndPassword(mailadress.getText().toString(), password.getText().toString()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    databaseReference.child(firebaseAuth.getCurrentUser().getUid()).setValue(student);
                                    Intent intent = new Intent(SignupStudent_Activity.this, StudentsProfile_Activity.class);
                                    startActivity(intent);
                                }
                            }

                        });
            }
        }
    }
}


