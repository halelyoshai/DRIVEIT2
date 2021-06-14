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

public class activity_Edittest extends AppCompatActivity  implements View.OnClickListener{


    private EditText testnum, testdate;
    private Button save, cancel;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__edittest);

        testnum= findViewById(R.id.testnum);
        testdate= findViewById(R.id.testdate);
        save= findViewById(R.id.btnsave);
        cancel= findViewById(R.id.btncancel);

        save.setOnClickListener (this);
        cancel.setOnClickListener(this);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference("Users");


    }
    public void onClick(View v){
        if(v==save){
            if (testnum.getText().toString().length()>0 && testdate.getText().toString().length()>0) {
                Intent intent= new Intent(this, Testslist_Activity.class);

                Test test= new Test(testnum.getText().toString(), testnum.getText().toString());
                databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("tests")
                        .child(System.currentTimeMillis()+"").setValue(test);
                startActivity(intent);
                finish();
            }
            else
                Snackbar.make(findViewById(android.R.id.content),"מלא את כל השדות", Snackbar.LENGTH_SHORT).show();
        }
    }


}
