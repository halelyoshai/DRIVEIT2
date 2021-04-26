package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private View v1;
    private TextView driveit;
    private Button signin;
    private Button signups;
    private Button signup;
    private Button finishsignin;
    private Button finishsighnups;
    private Button finishsighnupt;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        driveit = findViewById(R.id.driveit);
        signin = findViewById(R.id.btnsignin);
        signups = findViewById(R.id.btnsignups);
        signup = findViewById(R.id.btnsignup);
        finishsignin = findViewById(R.id.btnsignin1);
        finishsighnups = findViewById(R.id.btnfinish2);
        finishsighnupt = findViewById(R.id.btnfinish3);

        firebaseAuth = FirebaseAuth.getInstance();
        signin.setOnClickListener(this);
        signups.setOnClickListener(this);
        signup.setOnClickListener(this);
        finishsignin.setOnClickListener(this);
        finishsighnups.setOnClickListener(this);
        finishsighnupt.setOnClickListener(this);

        firebaseDatabase = FirebaseDatabase.getInstance();
        if (firebaseAuth.getCurrentUser()!=null){

            Intent Intent = new Intent(packageContext this,StudentsProfile_Activity)
           startActivity(intent);
        }

        firebaseDatabase= firebaseDatabase.getInstance();
        databaseReference = DatabaseReference.getReference(path: "Users");

    }



        @Override
    public void onClick(View v1) {
        if (v1 == signin) {
            Intent intent = new Intent( this, SigninActivity.class);
            startActivity(intent);
        }

            if (v1 == signups) {
                Intent intent = new Intent( this, SignupStudent_Activity.class);
                startActivity(intent);

            }

            if (v1 == signup) {
                Intent intent = new Intent( this, SignupTeacher_Activity.class);
                startActivity(intent);

            }

      if (v1 == finishsignin) {
        signin();
    }

            if (v1 == finishsighnups) {
        signup();
    }

            if (v1 == finishsighnupt) {
        sighnup();
    }
}


        public void signin(){
            String email =
        }

    public void signup(){
        String email = btnemailadress.getText().toString().trim();
        String email = btnpassword.getText().toString().trim();
        String email = btnpasswordagain.getText().toString().trim();

        if (passwors.length()<5){
            tvReg.setText("הסיסמה חייבת לכלול 5 תווים או יותר");
        }
              firebaseAuth.createUserWithEmailAndPassword(email,password
                      .addOnCompleteListener(activity this, new OnCompleteListener<AuthResult>(){
                       @Override
                       public void   onComplete

        }
    }

    public void sign(){
        String email =
    }


        }






