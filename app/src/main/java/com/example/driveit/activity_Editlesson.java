package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_Editlesson extends AppCompatActivity  implements View.OnClickListener{


    private EditText lessonnum, lessondate;
    private Button save, cancel;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__editlesson);

        lessonnum= findViewById(R.id.lessonnum1);
        lessondate= findViewById(R.id.lessondate);
        save= findViewById(R.id.btnsave);
        cancel= findViewById(R.id.btncancel);

        save.setOnClickListener (this);
        cancel.setOnClickListener(this);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference("Users");


        Intent intent= getIntent();

        if(intent.getExtras()!=null) {
            String numlesson= intent.getExtras().getString("numlesson");
            String datelesson= intent.getExtras().getString("datelesson");

            lessonnum.setText(numlesson);
            lessondate.setText(datelesson);


        }

    }
    public void onClick(View v){
        if(v==save){
            if (lessonnum.getText().toString().length()>0 && lessondate.getText().toString().length()>0) {
                Intent intent= new Intent();
                intent.putExtra("lessonnum", lessonnum.getText().toString());
                intent.putExtra("lessondate", lessondate.getText().toString());

                Lesson lesson= new Lesson(lessonnum.getText().toString(), lessondate.getText().toString());
                databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("lessons").setValue(lesson);
                setResult(RESULT_OK, intent);
                finish();
            }
            else
                Snackbar.make(findViewById(android.R.id.content),"מלא את כל השדות", Snackbar.LENGTH_SHORT).show();
        }
    }


}
