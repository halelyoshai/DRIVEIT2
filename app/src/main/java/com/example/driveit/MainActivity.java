package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private TextView driveit;
    private Button signin;
    private Button signups;
    private Button signup;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        driveit = findViewById(R.id.driveit);
        signin = findViewById(R.id.btnsignin);
        signups = findViewById(R.id.btnsignups);
        signup = findViewById(R.id.btnsignup);
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        firebaseAuth = FirebaseAuth.getInstance();
        signin.setOnClickListener(this);
        signups.setOnClickListener(this);
        signup.setOnClickListener(this);

    }

    @Override

    public void onClick(View v) {
        if (v == signin) {
            if (firebaseAuth.getCurrentUser() != null) {
                databaseReference.child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            boolean isTeacher = snapshot.child("isTeacher").getValue(Boolean.class);
                            if (isTeacher) {
                                Intent intent = new Intent(MainActivity.this, TeacherProfile_Activity.class);
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(MainActivity.this, StudentsProfile_Activity.class);
                                startActivity(intent);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });
            } else {
                Intent intent = new Intent(this, SigninActivity.class);
                startActivity(intent);
            }
        }

            if (v == signups) {
                Intent intent = new Intent(this, SignupStudent_Activity.class);
                startActivity(intent);
            }
            if (v == signup) {
                Intent intent = new Intent(this, SignupTeacher_Activity.class);
                startActivity(intent);
            }

        }
    }









