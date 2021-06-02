package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        if(firebaseAuth.getCurrentUser()!=null)
        {
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot d : snapshot.getChildren()) {
                        if (d.getValue(Person.class).getMail().equals("123@gmail.com")) {
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            databaseReference.child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.getValue(Person.class).isIsteacher()){
                        Intent intent= new Intent(SigninActivity.this, TeacherProfile_Activity.class);
                        startActivity(intent);
                    }
                    else {
                        Intent intent= new Intent(SigninActivity.this, StudentsProfile_Activity.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

    }

    @Override
    public void onClick(View v) {
        if (v == signin) {
            firebaseAuth.signInWithEmailAndPassword(username.getText().toString(),password.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Intent intent = new Intent( SigninActivity.this, StudentsProfile_Activity.class);
                        startActivity(intent);
                    }
                }
            });

        }

    }
}