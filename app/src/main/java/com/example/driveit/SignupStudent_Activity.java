package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupStudent_Activity extends AppCompatActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_signup_student_);

        fullname = findViewById(R.id.btnname);
        phonenumber = findViewById(R.id.btnphonenumber);
        mailadress = findViewById(R.id.btnmailadress);
        password = findViewById(R.id.btnpassword);
        passwordagain = findViewById(R.id.btnpasswordagain);
        finish = findViewById(R.id.btnfinish2);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");

        finish.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == finish) {

            if ((fullname.getText().toString().isEmpty()) || (phonenumber.getText().toString().isEmpty()) || (password.getText().toString().isEmpty()) || (mailadress.getText().toString().isEmpty())) {
                Toast.makeText(this, "כל השדות חייבים להיות מלאים", Toast.LENGTH_SHORT).show();
            }
            else if(phonenumber.getText().toString().trim().length() < 7) {
                Toast.makeText(this, "מספר הטלפון צריך להיות ארוך מ7 תווים.", Toast.LENGTH_SHORT).show();

            }
            else if (!password.getText().toString().trim().equals(passwordagain.getText().toString().trim())) {
                Toast.makeText(this, "הסיסמאות אינן זהות", Toast.LENGTH_SHORT).show();
                password.setText("");
                passwordagain.setText("");
            } else if (password.getText().toString().length() < 6) {
                Toast.makeText(this, "הסיסמה קצרה מדי", Toast.LENGTH_SHORT).show();
                password.setText("");
                passwordagain.setText("");
            } else {
                firebaseAuth.createUserWithEmailAndPassword(mailadress.getText().toString(), password.getText().toString()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    student = new Student(fullname.getText().toString(), phonenumber.getText().toString(), mailadress.getText().toString(), password.getText().toString());
                                    databaseReference.child(firebaseAuth.getCurrentUser().getUid()).setValue(student);
                                    Intent intent = new Intent(SignupStudent_Activity.this, StudentsProfile_Activity.class);
                                    startActivity(intent);
                                }

                                else
                                {
                                    Toast.makeText(SignupStudent_Activity.this, "האימייל כבר קיים במערכת או לא תקין.", Toast.LENGTH_SHORT).show();
                                }
                            }

                        });
            }
        }

    }
}


