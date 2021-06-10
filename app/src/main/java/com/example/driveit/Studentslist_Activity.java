package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Studentslist_Activity extends AppCompatActivity implements View.OnClickListener {
    private Dialog d;
    private EditText studentname, mail;
    private Button plus, add, firststudent;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseUser firebaseUser;
    private Teacher teacher;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentslist__t);

        firststudent=findViewById(R.id.btnstudentname);
        plus = (Button) findViewById(R.id.btnplus);
        plus.setOnClickListener (this);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference("Users");
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();


    }
    @Override
    public void onClick(View v) {
        if (v== plus){
            d=new Dialog(this);
            d.setContentView(R.layout.newstudent_dialog);
            studentname = d.findViewById(R.id.studentname);
            mail = d.findViewById(R.id.mail);
            add= d.findViewById(R.id.btnDialogLogin);
            d.getWindow().setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            d.setCancelable(true);
            d.show();

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    databaseReference.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            teacher= snapshot.getValue(Teacher.class);
                            databaseReference.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                                        student=  dataSnapshot.getValue(Student.class);
                                        if(student.getName().equals(studentname.getText().toString())
                                                &&student.getMail().equals(mail.getText().toString())){
                                            student.setTeacher(teacher);
                                            teacher.setStudents(student);
                                            databaseReference.setValue(teacher);
                                            databaseReference.setValue(student);

                                            firststudent.setText(student.getName());
                                            firststudent.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent=new Intent(Studentslist_Activity.this,
                                                            Lessonlist_Activity.class);
                                                    intent.putExtra("StudentMail", student.getMail());
                                                    startActivity(intent);
                                                }
                                            });
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            });
        }

            }
        }



