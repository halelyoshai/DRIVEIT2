package com.example.driveit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentsProfile_Activity extends AppCompatActivity implements View.OnClickListener {
    private View v;
    private ImageView studentprofile;
    private TextView name;
    private TextView city;
    private TextView teacher;
    private TextView school;
    private TextView bigtest;
    private TextView smalltest;
    private TextView lessonsnum;
    private Button info;
    private Button scheduling;
    private Button rating;
    private Button setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofile__s);

        studentprofile = findViewById(R.id.btnstudentprufile);
        name = findViewById(R.id.txtname);
        city = findViewById(R.id.txtcity);
        teacher = findViewById(R.id.txtteacher);
        school = findViewById(R.id.txtschool);
        bigtest = findViewById(R.id.txtbigtest);
        smalltest = findViewById(R.id.txtsmalltest);
        lessonsnum = findViewById(R.id.txtlessonscounting);
        rating = findViewById(R.id.btnrating);
        scheduling = findViewById(R.id.btnscheduling);
        info = findViewById(R.id.btninfo);
        setting = findViewById(R.id.btnsetting);


        studentprofile.setOnClickListener (this);
        name.setOnClickListener(this);
        city.setOnClickListener(this);
        teacher.setOnClickListener(this);
        school.setOnClickListener(this);
        bigtest.setOnClickListener(this);
        smalltest.setOnClickListener(this);
        lessonsnum.setOnClickListener(this);
        rating.setOnClickListener (this);
        scheduling.setOnClickListener(this);
        info.setOnClickListener (this);
        setting.setOnClickListener(this);




    }
    @Override
    public void onClick(View v) {
        if (v == rating){
        Intent intent = new Intent ( this, RatingActivity_S.class);
            startActivity(intent);
        }



        if (v == scheduling ) {
            Intent intent = new Intent( this, SchedulingActivity.class);
            startActivity(intent);
        }


        if (v == setting){
            Intent intent = new Intent ( this, SignupStudent_Activity.class);
            startActivity(intent);
        }

        if (v == info){
            Intent intent = new Intent ( this, Info_Activity.class);
            startActivity(intent);
        }
        if (v == studentprofile){
            Intent intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
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
                 studentprofile.setImageBitmap(bitmap);
             }
         }
     }
}
                       
                        
                    