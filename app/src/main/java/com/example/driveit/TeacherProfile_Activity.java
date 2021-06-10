package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TeacherProfile_Activity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private TextView teacherprofile;
    private ImageButton profilepic;
    private TextView teachername;
    private TextView studyarea;
    private TextView school;
    private TextView studentsnum;
    private ImageButton students;
    private ImageButton info;
    private ImageButton setting;
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile_);

        teacherprofile = findViewById(R.id.txtteacherprofile);
        profilepic = findViewById(R.id.btnprofilepic);
        teachername = findViewById(R.id.txtteachername);
        studyarea = findViewById(R.id.txtstudyarea);
        school = findViewById(R.id.txtschool);
        studentsnum = findViewById(R.id.txtstudentsnum);
        students = findViewById(R.id.btnstudents);
        info = findViewById(R.id.btninfo);
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        profilepic.setOnClickListener(this);
        students.setOnClickListener(this);
        info.setOnClickListener(this);
        setting.setOnClickListener(this);


        this.databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String username = snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("name").getValue(String.class);
                    teachername.setText(username);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(TeacherProfile_Activity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }


        });


        @Override
        public void onClick (View v){
            if (v == profilepic) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }


            if (v == students) {
                Intent intent = new Intent(this, Studentslist_Activity.class);
                startActivity(intent);
            }

            if (v == info) {
                Intent intent = new Intent(this, Info_Activity.class);

                startActivity(intent);

            }

        }


        protected void onActivityResult ( int requrstCode, int resultCode, Intent data)
        {
            super.onActivityResult(requrstCode, resultCode, data);

            if (resultCode == 0) {
                if (requrstCode == RESULT_OK) {
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    profilepic.setImageBitmap(bitmap);
                }

            }
        }
    }
}