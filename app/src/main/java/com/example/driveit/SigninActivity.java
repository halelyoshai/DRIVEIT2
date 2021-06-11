package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username;
    private EditText password;
    private Button signin;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        username = findViewById(R.id.btnusername);
        username.setOnClickListener(this);
        password = findViewById(R.id.btnpassword);
        password.setOnClickListener(this);
        signin = findViewById(R.id.btnsignin);
        signin.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
        database= FirebaseDatabase.getInstance();
        databaseReference= database.getReference("Users");

    }

    @Override
    public void onClick(View v) {
        if (v == signin) {
            if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty())
            {
                Toast.makeText(this, "כל השדות חייבים להיות מלאים", Toast.LENGTH_SHORT).show();

            }
            else
            {
                firebaseAuth.signInWithEmailAndPassword(username.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            if (snapshot.exists()) {
                                                boolean isTeacher = snapshot.child(firebaseAuth.getCurrentUser().getUid()).child("isTeacher").getValue(Boolean.class);
                                                if(isTeacher) {
                                                    Intent intent = new Intent( SigninActivity.this, TeacherProfile_Activity.class);
                                                    startActivity(intent);
                                                }
                                                else {
                                                    Intent intent = new Intent( SigninActivity.this, StudentsProfile_Activity.class);
                                                    startActivity(intent);
                                                }
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {
                                            Toast.makeText(SigninActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                                else
                                {
                                    Toast.makeText(SigninActivity.this, "האימייל או הסיסמה לא נכונים.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }

        }

    }
}