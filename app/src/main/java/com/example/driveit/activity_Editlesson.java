package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class activity_Editlesson extends AppCompatActivity  implements View.OnClickListener{


    private EditText lessonnum, lessondate;
    private Button save, cancel;

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
                setResult(RESULT_OK, intent);
                finish();
            }
            else
                Snackbar.make(findViewById(android.R.id.content),"מלא את כל השדות", Snackbar.LENGTH_SHORT).show();
        }
    }


}
