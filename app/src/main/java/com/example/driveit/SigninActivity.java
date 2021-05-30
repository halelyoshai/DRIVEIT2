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

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private TextView driveit;
    private EditText username;
    private EditText password;
    private Button signin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        driveit = findViewById(R.id.txtdriveit);
        username = findViewById(R.id.btnusername);
        username.setOnClickListener(this);
        password = findViewById(R.id.btnpassword);
        password.setOnClickListener(this);
        signin = findViewById(R.id.btnsignin);
        signin.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();


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