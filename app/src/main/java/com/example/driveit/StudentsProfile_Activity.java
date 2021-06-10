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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentsProfile_Activity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference databaseReference;
    private TextView studentprofile;
    private ImageButton picture;
    private TextView name;
    private TextView teacher;
    private TextView bigtest;
    private TextView enptycircle;
    private TextView lessonsnum;
    private Button info;
    private Button lessons;
    private Button tests;
    private Button teachers;
    private String permmisions_gallery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofile__s);

        studentprofile = findViewById(R.id.txtstudentprofile);
        picture = findViewById(R.id.btnpicture);
        name = findViewById(R.id.txtname);
        teacher = findViewById(R.id.txtteacher);
        bigtest = findViewById(R.id.txtbigtest);
        enptycircle = findViewById(R.id.txtemptycircle);
        lessonsnum = findViewById(R.id.txtlessonsnum);
        info = findViewById(R.id.btninfo);
        lessons = findViewById(R.id.btnlessons);
        tests = findViewById(R.id.btntests);
        teachers = findViewById(R.id.btnteachers);
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        picture.setOnClickListener(this);
        info.setOnClickListener(this);
        lessons.setOnClickListener(this);
        tests.setOnClickListener(this);
        teachers.setOnClickListener(this);


        this.databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String username = snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("name").getValue(String.class);
                    name.setText(username);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(StudentsProfile_Activity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }


        });
    }
    @Override
    public void onClick(View v) {
        if (v == picture){
            Intent intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,0);
        }


        if (v == lessons ) {
            Intent intent = new Intent( this, Lessonlist_Activity.class);
            startActivity(intent);
        }


        if (v == tests){
            Intent intent = new Intent ( this, Testslist_Activity.class);
            startActivity(intent);
        }

        if (v == info){
            Intent intent = new Intent ( this, Info_Activity.class);
            startActivity(intent);
        }
        if (v == teachers){
            Intent intent = new Intent (this, TeachersActivity.class);
            startActivityForResult(intent,0);
        }


    }

    @Override
    protected void onActivityResult(int requrstCode, int resultCode, Intent data){
        super.onActivityResult(requrstCode, resultCode, data);

        if (resultCode == 0)
        {
            if(requrstCode==RESULT_OK)
            {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                picture.setImageBitmap(bitmap);
            }
        }
    }

}
                        
                    