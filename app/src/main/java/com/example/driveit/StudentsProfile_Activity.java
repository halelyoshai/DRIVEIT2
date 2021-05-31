package com.example.driveit;

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

public class StudentsProfile_Activity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private TextView studentprofile;
    private ImageButton picture;
    private Button choospeic;
    private TextView name;
    private TextView teacher;
    private TextView bigtest;
    private TextView enptycircle;
    private TextView lessonsnum;
    private ImageButton info;
    private ImageButton lessons;
    private ImageButton tests;
    private ImageButton teachers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofile__s);

        studentprofile = findViewById(R.id.txtstudentprofile);
        picture = findViewById(R.id.btnpicture);
        choospeic = findViewById(R.id.btnchoosepic);
        choospeic.setOnClickListener(this);
        findViewById(R.id.btnchoosepic);
        name = findViewById(R.id.txtname);
        teacher = findViewById(R.id.txtteacher);
        bigtest = findViewById(R.id.txtbigtest);
        enptycircle = findViewById(R.id.txtemptycircle);
        lessonsnum = findViewById(R.id.txtlessonscounting);
        findViewById(R.id.btninfo);
        info.setOnClickListener(this);
        findViewById(R.id.btnlessons);
        lessons.setOnClickListener(this);
        findViewById(R.id.btntests);
        tests.setOnClickListener(this);
        findViewById(R.id.btnteachers);
        teachers.setOnClickListener(this);
        choospeic.setOnClickListener(this);
        findViewById(R.id.btnchoosepic);
        studentprofile.setOnClickListener (this);
        picture.setOnClickListener (this);
        choospeic.setOnClickListener (this);
        name.setOnClickListener(this);
        teacher.setOnClickListener(this);
        bigtest.setOnClickListener(this);
        enptycircle.setOnClickListener(this);
        lessonsnum.setOnClickListener(this);
        info.setOnClickListener (this);
        lessons.setOnClickListener(this);
        tests.setOnClickListener (this);
        teachers.setOnClickListener(this);




    }
    @Override
    public void onClick(View v) {
        if (v == choospeic){
                Intent intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
        }


        if (v == lessons ) {
            Intent intent = new Intent( this, Lessonslist_Activity.class);
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

         if (requrstCode == 0)
         {
             if(requrstCode==RESULT_OK)
             {
                 Bitmap bitmap = (Bitmap) data.getExtras().get("data");
             // choospeic.setImageBitmap(bitmap);
             }
         }
     }
}
                       
                        
                    