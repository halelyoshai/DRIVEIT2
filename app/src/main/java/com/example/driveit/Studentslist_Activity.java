package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Studentslist_Activity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Student> students;
    private TextView studentlist;
    private Dialog d;
    private ListView lv_s;
    private EditText studentname, mail;
    private Button plus, add;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseUser firebaseUser;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentslist);

        studentlist=findViewById(R.id.txtstudentlist);
        plus = (Button) findViewById(R.id.plus);
        student = new Student();
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

                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()) {
                                boolean isTeacher = dataSnapshot.child("isTeacher").getValue(Boolean.class);
                                if (!isTeacher) {
                                    student.setName(dataSnapshot.child("name").getValue(String.class));
                                    student.setMail(dataSnapshot.child("mail").getValue(String.class));

                                    if (student.getName().equals(studentname.getText().toString()) && student.getMail().equals(mail.getText().toString())) {
                                        student.setTeacherName(snapshot.child(firebaseUser.getUid()).getValue(Teacher.class).getName());

                                        //  snapshot.child(firebaseUser.getUid()).getValue(Teacher.class).setListOfStudents(student);
                                        databaseReference.child(firebaseUser.getUid()).child("listOfStudents").child(System.currentTimeMillis() + "").setValue(student);
                                        String num = snapshot.child(firebaseUser.getUid()).getValue(Teacher.class).getNumOfStudents();
                                        int temp= Integer.valueOf(num);
                                        temp++;
                                        databaseReference.child(firebaseUser.getUid()).child("numOfStudents").setValue(String.valueOf(temp));
                                        databaseReference.child(dataSnapshot.getKey()).setValue(student);
                                        Log.d("MSG2", dataSnapshot.getKey());
                                        Intent intent = new Intent(Studentslist_Activity.this, TeacherProfile_Activity.class);
                                        startActivity(intent);
                                        break;
                                    }

                                }
                            }
                                d.dismiss();
                                Snackbar.make(findViewById(android.R.id.content), "התלמיד לא נמצא", Snackbar.LENGTH_SHORT).show();
                                return;

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



