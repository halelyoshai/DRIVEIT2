package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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
import android.widget.Toast;

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
    private Button plus, add;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseUser firebaseUser;
    private Teacher teacher;
    private Student student;
    private RecyclerView firststudent;
    private void tt()
    {
        Toast.makeText(this, "found student", Toast.LENGTH_SHORT).show();
    }
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
        student = new Student();
        String[] ar ={"noa","yafa","halel"};
        CustomAdapter adp = new CustomAdapter(ar);
        firststudent.setAdapter(adp);

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
                            String teacherName = snapshot.child(firebaseUser.getUid()).child("name").getValue(String.class);
                            String numOfStudents = snapshot.child(firebaseUser.getUid()).child("numOfStudents").getValue(String.class);
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                                boolean isTeacher = dataSnapshot.child("isTeacher").getValue(Boolean.class);
                                if(isTeacher) {
                                    continue;
                                }
                                String techer = dataSnapshot.child("teacherName").getValue(String.class);
                                if(!techer.equals("עדיין לא ידוע")) {
                                    continue;
                                }
                                else {
                                    student.setName(dataSnapshot.child("name").getValue(String.class));
                                    student.setMail(dataSnapshot.child("mail").getValue(String.class));
                                    if(student.getName().equals(studentname.getText().toString())){ //&& student.getMail().equals(mail.getText().toString())){
                                        databaseReference.child(dataSnapshot.getKey()).child("teacherName").setValue(teacherName);
                                        databaseReference.child(firebaseUser.getUid()).child("numOfStudents").setValue(String.valueOf(Integer.parseInt(numOfStudents) + 1));
                                       Intent intent=new Intent(Studentslist_Activity.this, TeacherProfile_Activity.class);
                                       startActivity(intent);
                                       tt();
                                        break;
                                    }
                                }
                            }
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



