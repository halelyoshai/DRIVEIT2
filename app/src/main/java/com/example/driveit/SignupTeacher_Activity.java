package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class SignupTeacher_Activity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private Button fullname;
    private Button phonenumber;
    private Button mailadress;
    private Button school;
    private Button studyarea;
    private Button manualorautomatic;
    private Button lessonslength;
    private Button priceperlesson;
    private Button username;
    private Button password;
    private Button passwordagain;
    private Button finish;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullname = findViewById(R.id.btnfullname);
        phonenumber = findViewById(R.id.btnphonenumber);
        mailadress = findViewById(R.id.btnmailadress);
        studyarea = findViewById(R.id.btnstudyarea);
        school = findViewById(R.id.btnschool);
        manualorautomatic = findViewById(R.id.btnmanualorautomatic);
        lessonslength = findViewById(R.id.btnlessonlength);
        priceperlesson = findViewById(R.id.btnpriceperlesson);
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
            Teacher t = new Teacher();
            firebaseAuth.createUserWithEmailAndPassword(mailadress.getText().toString(), password.getText().toString()).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(SignupTeacher_Activity.this, TeacherProfile_Activity.class);
                                startActivity(intent);
                            }
                        }

                    });
        }
    }
}