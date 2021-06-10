package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class SignupTeacher_Activity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private EditText fullname;
    private EditText phonenumber;
    private EditText mailadress;
    private EditText school;
    private EditText studyarea;
    private Spinner manualorautomatic;
    private EditText lessonslength;
    private EditText priceperlesson;
    private EditText password;
    private EditText passwordagain;
    private Button finish;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private Teacher teacher;
    List<String> typelesson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupteacher);

        fullname = findViewById(R.id.btnfullname);
        phonenumber = findViewById(R.id.btnphonenumber);
        mailadress = findViewById(R.id.btnmailadress);
        studyarea = findViewById(R.id.btnstudyarea);
        school = findViewById(R.id.btnschool);
        manualorautomatic = (Spinner) findViewById(R.id.btnmanualorautomatic);
        lessonslength = findViewById(R.id.btnlessonlength);
        priceperlesson = findViewById(R.id.btnpriceperlesson);
        password = findViewById(R.id.btnpassword);
        passwordagain = findViewById(R.id.btnpasswordagain);
        finish = findViewById(R.id.btnfinish3);
        finish.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");

        fullname.setOnClickListener(this);
        phonenumber.setOnClickListener(this);
        mailadress.setOnClickListener(this);
        school.setOnClickListener(this);
        studyarea.setOnClickListener(this);
        lessonslength.setOnClickListener(this);
        priceperlesson.setOnClickListener(this);
        password.setOnClickListener(this);
        passwordagain.setOnClickListener(this);
        finish.setOnClickListener(this);

        typelesson = new ArrayList<String>();
        typelesson.add("manual");
        typelesson.add("automatic");
        typelesson.add("both");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, typelesson);
        manualorautomatic.setAdapter(adapter);

    }


    @Override
    public void onClick(View v) {
        if (v == finish) {
            if (password.getText().toString().trim().equals(passwordagain.getText().toString().trim())) {

                firebaseAuth.createUserWithEmailAndPassword(mailadress.getText().toString(), password.getText().toString()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    teacher = new Teacher(fullname.getText().toString(), phonenumber.getText().toString(), mailadress.getText().toString(),
                                            password.getText().toString());
                                    databaseReference.child(firebaseAuth.getCurrentUser().getUid()).setValue(teacher);
                                    Intent intent = new Intent(SignupTeacher_Activity.this, TeacherProfile_Activity.class);
                                    startActivity(intent);

                                }

                            }

                        });


            } else {
                Toast.makeText(this, "הסיסמאות אינן זהות", Toast.LENGTH_SHORT).show();
                password.setText("");
                passwordagain.setText("");
                return;
            }
            if (password.getText().toString().length() >= 6) {
                Intent intent = new Intent(SignupTeacher_Activity.this, StudentsProfile_Activity.class);
                startActivity(intent);

            } else {
                Toast.makeText(this, "הסיסמה קצרה מדי", Toast.LENGTH_SHORT).show();
                password.setText("");
                passwordagain.setText("");
                return;
            }
            if ((fullname.getText().toString().trim().length()!=0)||(phonenumber.getText().toString().trim().length()==10)||
                    (mailadress.getText().toString().trim().length()!=0))
            {
                Intent intent = new Intent(SignupTeacher_Activity.this, StudentsProfile_Activity.class);
                startActivity(intent);

            } else {
                Toast.makeText(this, "כל השדות חייבים להיות מלאים", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }

    public void onitemselected(AdapterView<?> parent, View view, int posltion, long id) {
        String item = parent.getItemAtPosition(posltion).toString();
        Toast.makeText(parent.getContext(), "selected" + item, Toast.LENGTH_LONG).show();
    }


}
